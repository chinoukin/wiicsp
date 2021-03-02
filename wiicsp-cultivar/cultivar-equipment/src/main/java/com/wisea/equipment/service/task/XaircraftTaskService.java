package com.wisea.equipment.service.task;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.mss.RemoteFilesMss;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.MultipartFileUtils;
import com.wisea.cloud.common.vo.FileVo;
import com.wisea.cloud.common.vo.UploadVo;
import com.wisea.cloud.influxdb.config.InfluxDBClient;
import com.wisea.equipment.config.XaircraftConfig;
import com.wisea.equipment.dao.EquInfoMapper;
import com.wisea.equipment.dao.EquMeteorologyMapper;
import com.wisea.equipment.entity.EquMeteorology;
import com.wisea.equipment.entity.influx.MeteorologyInflux;
import com.wisea.equipment.entity.xaircraft.XaircraftDeviceInfo;
import com.wisea.equipment.entity.xaircraft.XaircraftResult;
import com.wisea.equipment.po.EquInfoListPo;
import com.wisea.equipment.utils.XaircraftHttpClientUtil;
import com.wisea.equipment.utils.EquipmentUtil;
import com.wisea.equipment.vo.EquInfoListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * @author jirg
 * @version 1.0
 * @className TaskService
 * @date 2020/7/8 9:50
 * @Description 讯飞物联网定时任务Service
 */
@Service
@ConditionalOnProperty(name = "equipment.xaircraft.enable", havingValue = "true", matchIfMissing = false)
public class XaircraftTaskService extends BaseService {
    @Autowired
    private EquInfoMapper equInfoMapper;
    @Autowired
    private EquMeteorologyMapper equMeteorologyMapper;
    @Autowired(required = false)
    private XaircraftConfig config;
    @Autowired
    private RemoteFilesMss remoteFilesMss;
    @Autowired
    private InfluxDBClient influxDBClient;

    /**
     * @author jirg
     * @date 2020/7/8 9:54
     * @Description 讯飞定时任务获取物联网设备数据，基于讯飞V5接口
     */
    @Transactional(readOnly = false)
    public void xaircraftTask() {
        //获取极飞数据列表
        EquInfoListPo po = new EquInfoListPo();
        po.setEquEntpName("极飞");
        po.setPage(null);
        List<EquInfoListVo> equInfos = equInfoMapper.findPageList(po);
        //获取设备数据
        List<XaircraftResult> xaircraftResults = getDataPoints(equInfos);
        //保存数据点
        saveXaircraftResults(xaircraftResults);
    }

    /**
     * @author jirg
     * @date 2020/7/9 10:05
     * @Description 获取设备信息
     */
    public List<XaircraftResult> getDataPoints(List<EquInfoListVo> equInfos){
        String deviceInfoUrl = config.getBaseUrl().concat(config.getDeviceInfoUrl());
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Set<Callable<List<XaircraftResult>>> callables = new HashSet<Callable<List<XaircraftResult>>>();
        equInfos.stream().filter(e->e.getEquNum()!=null).forEach(e -> {
            callables.add(()->{
                List<XaircraftResult> results = Lists.newArrayList();
                String equNum = e.getEquNum().trim();
                String deviceUrl = MessageFormat.format(deviceInfoUrl, config.getAccount(), equNum);
                //查询设备信息
                String deviceInfoResult = XaircraftHttpClientUtil.get(deviceUrl, null);
                if (EquipmentUtil.validateJson(deviceInfoResult)) {
                    XaircraftDeviceInfo deviceInfo = ConverterUtil.gson.fromJson(deviceInfoResult, XaircraftDeviceInfo.class);
                    if(ConverterUtil.isNotEmpty(deviceInfo)){
                        //判断设备是否在线
                        if(deviceInfo.getStatus() == 1){
                            //判断设备型号
                            if(deviceInfo.getType() == 1 && deviceInfo.getModel() == 2){
                                //FM1 data_type 可取 1 气象数据 、 2 图像数据 、 15 全天时景URL
                                XaircraftResult lastPoint = getLastPoint(e.getId(), equNum, "1");
                                XaircraftResult lastImage = getLastPoint(e.getId(), equNum, "2");
                                results.add(lastPoint);
                                results.add(lastImage);
                            }
                            if(deviceInfo.getType() == 13 && deviceInfo.getModel() == 2){
                                //IWS7 data_type 可取 1 气象数据 、 14 数值统计数据
                                XaircraftResult lastPoint = getLastPoint(e.getId(), equNum, "1");
                                results.add(lastPoint);
                            }
                            if(deviceInfo.getType() == 13 && deviceInfo.getModel() == 1){
                                //IFC16 data_type 可取 2 图像数据 、 15 视频统计数据
                                XaircraftResult lastImage = getLastPoint(e.getId(), equNum, "2");
                                XaircraftResult yesterdayVideo = getLastPoint(e.getId(), equNum, "15");
                                results.add(lastImage);
                                results.add(yesterdayVideo);
                            }
                        }
                    }
                }
                return results;
            });
        });
        List<Future<List<XaircraftResult>>> futures = null;
        List<XaircraftResult> dataPoints = Lists.newArrayList();
        try {
            futures = executorService.invokeAll(callables);
            for(Future<List<XaircraftResult>> future : futures){
                dataPoints.addAll(future.get());
            }
            executorService.shutdown();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dataPoints;
    }


    /**
     * @author jirg
     * @date 2020/9/18 17:11
     * @Description
     */
    public XaircraftResult getLastPoint(Long equId, String equNum, String dataType){
        String lastPointUrl = config.getBaseUrl().concat(config.getLastPointUrl());
        String pointUrl = MessageFormat.format(lastPointUrl, config.getAccount(), equNum);
        //获取设备数据点
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("encoding", "json");
        paramMap.put("data_type", dataType);
        //获取极飞物联返回的json字符串
        String result = XaircraftHttpClientUtil.get(pointUrl, paramMap);
        if (EquipmentUtil.validateJson(result)) {
            XaircraftResult res = ConverterUtil.gson.fromJson(result, XaircraftResult.class);
            res.setEquId(equId);
            return res;
        }else{
            return null;
        }
    }

    /**
     * @author jirg
     * @date 2020/9/18 18:01
     * @Description 文件上传  fileType： 0 图片 、 1 视频
     */
    public String updateFile(String fileUurl, String fileType){
        if(ConverterUtil.isNotEmpty(fileUurl)){
            try {
                String fileName = fileUurl.substring(fileUurl.lastIndexOf("/") + 1).replaceAll("_","");

                String filePath = "file_temp".concat(File.separator) + fileName ;
                File file = new File(filePath);
                if(!file.getParentFile().exists()){
                    file.getParentFile().mkdirs();
                }

                FileOutputStream fileOutputStream = new FileOutputStream(file);
                URL url = new URL(fileUurl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                DataInputStream inputStream = new DataInputStream(conn.getInputStream());
                StreamUtils.copy(inputStream, fileOutputStream);

                //临时文件上传至文件服务器
                if (file.exists()) {
                    // 将普通file转成MultipartFile
                    MultipartFile mfile = MultipartFileUtils.fileToMulitipart(file);
                    ResultPoJo<UploadVo> poJo = null;
                    if(fileType.equals("0")){
                        poJo = remoteFilesMss.uploadImg(mfile, false,"");
                    }else if (fileType.equals("1")){
                        poJo = remoteFilesMss.uploadAud(mfile, false);
                    }
                    // 修改申请信息，保存文件路径
                    UploadVo uploadVo = poJo.getResult();
                    Map<String, List<FileVo>> filesMap = uploadVo.getFilesMap();
                    List<FileVo> fileVos = filesMap.get("file");
                    FileVo fileVo = fileVos.get(0);
                    String path = fileVo.getPath();

                    //关闭流，删除临时文件
                    inputStream.close();
                    fileOutputStream.close();
                    file.delete();

                    return path;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }


    /**
     * @author jirg
     * @date 2020/7/8 11:19
     * @Description 保存数据点
     */
    @Transactional(readOnly = false)
    public void saveXaircraftResults(List<XaircraftResult> xaircraftResults){
        //过滤数据 - 返回数据时间大于本地最新时间才做保存操作
        List<XaircraftResult> results = xaircraftResults.stream().filter(e -> {
            return ConverterUtil.isNotEmpty(e) && EquipmentUtil.checkDataPoint(e.getEquId(), e.getCreatedAt(), EquipmentUtil.getEquDateType(e.getType()));
        }).collect(Collectors.toList());

        if(results.size() > 0){
            //过滤图片/视频数据 - 上传网络图片/视频到图片服务器
            results.stream().filter(e->e.getType() == 2).forEach(e->{
                //图片数据，获取图片地址，上传到图片服务器
                String image = e.getData().getImage();
                if(ConverterUtil.isNotEmpty(image)){
                    String imageUrl = updateFile(image, "0");
                    e.getData().setImage(imageUrl);
                }
                String video = e.getData().getVideo();
                if(ConverterUtil.isNotEmpty(video)){
                    String videoUrl = updateFile(video, "1");
                    e.getData().setVideo(videoUrl);
                }
            });

            List<EquMeteorology> equMeteorologies = Lists.newArrayList();
            List<MeteorologyInflux> meteorologyInfluxes = Lists.newArrayList(); //时序数据列表

            results.forEach(e -> {
                EquMeteorology equMeteorology = new EquMeteorology();
                ConverterUtil.copyProperties(e.getData(), equMeteorology);
                equMeteorology.setEquId(e.getEquId());
                equMeteorology.setEquDateType(EquipmentUtil.getEquDateType(e.getType()));
                equMeteorology.preInsert();
                equMeteorology.setCreateDate(e.getCreatedAt());
                equMeteorologies.add(equMeteorology);

                //时序数据
                MeteorologyInflux xaircraftInfluxe = new MeteorologyInflux();
                ConverterUtil.copyProperties(equMeteorology, xaircraftInfluxe);
                xaircraftInfluxe.setId(equMeteorology.getId().toString());
                xaircraftInfluxe.setEquId(equMeteorology.getEquId().toString());
                Long time = equMeteorology.getCreateDate().toEpochSecond() * 1000;
                xaircraftInfluxe.setTime(time.toString());
                meteorologyInfluxes.add(xaircraftInfluxe);
            });

            //批量插入设备气象数据
            equMeteorologyMapper.batchInsert(equMeteorologies);

            //更新设备气象数据最新时间
            results.forEach(e -> {
                EquipmentUtil.cacheDataPointMaxDate(e.getEquId(), e.getCreatedAt(), EquipmentUtil.getEquDateType(e.getType()));
            });

            //异步将设备气象数据列表插入到时序数据库中
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void afterCommit() {
                    //事物提交之后执行
                    influxDBClient.batchInsert(meteorologyInfluxes);
                }
            });
        }
    }
}
