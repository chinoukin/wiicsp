package com.wisea.cultivar.plant.service.oritrapla;

import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.entity.oritrapla.EquInfoMage;
import com.wisea.cultivar.plant.entity.oritrapla.PadMage;
import com.wisea.cultivar.plant.entity.oritrapla.PadYjInfo;
import com.wisea.cultivar.plant.mapper.MembCollectionMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.EquInfoMageMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.PadMageMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.PadYjInfoMapper;
import com.wisea.cultivar.plant.mss.EquipmentJobMss;
import com.wisea.cultivar.plant.mss.po.EquDataPointPo;
import com.wisea.cultivar.plant.mss.vo.XaircraftInfluxVo;
import com.wisea.cultivar.plant.po.PolicyTechnologyInfoPo;
import com.wisea.cultivar.plant.po.oritrapla.*;
import com.wisea.cultivar.plant.vo.oritrapla.ArchBasicInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.HealthCheckVo;
import com.wisea.cultivar.plant.vo.oritrapla.PadMageGetVo;
import com.wisea.cultivar.plant.vo.oritrapla.PadMageListVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019-08-21 08:50
 */
@Service
public class PadMageService extends BaseService {

    private final static Logger log = LoggerFactory.getLogger(PadMageService.class);

    @Autowired
    private PadMageMapper padMageMapper;
    @Autowired
    private PadYjInfoMapper padYjInfoMapper;
    @Autowired
    private EquInfoMageMapper equInfoMageMapper;
    @Autowired
    private InsectPestsWarningSendService sendService;
    @Autowired
    private EquipmentJobMss equipmentJobMss;
    @Autowired
    private JedisDao jedisdao;
    @Autowired
    private MembCollectionMapper membCollectionMapper;

    /**
     * 格式health_check_equ_id_设备ID_病虫害ID
     */
    private static final String HEALTH_CHECK_PREFIX = "health_check_equ_id_";
    private static final String HEALTH_CONTINUED_CHECK_PREFIX = "health_continued_check_equ_id_";
    private static final String LAST_DATA_POINT_MAP = "last_data_point_map";

    /**
     * 按ID查询
     * @param
     * @return
     */
    public ResultPoJo<PadMageGetVo> findById(PolicyTechnologyInfoPo po) {
        ResultPoJo<PadMageGetVo> poJo = new ResultPoJo<>();
        Long collectionId = null;
        if (ConverterUtil.isNotEmpty(po.getCollectionType(),po.getMembId())) {
            //查询是否收藏
            collectionId = membCollectionMapper.ifStatus(po);
            //添加浏览次数
            padMageMapper.updateViewsByKey(po.getId());
        }
        //查询详细信息
        PadMageGetVo vo = padMageMapper.findById(po.getId());
        //判断是否被收藏
        if (ConverterUtil.isNotEmpty(collectionId)) {
            vo.setStatus("0");
            vo.setMembCollectionId(collectionId);
        } else {
            vo.setStatus("1");
        }
        if (vo != null) {
            poJo.setResult(vo);
        }
        return poJo;
    }

    /**
     * 按名称查询
     * @return
     */
    public ResultPoJo<List<PadMageListVo>> findList(PadMageListPo po) {
        List<PadMageListVo> list = padMageMapper.findList(po);
        ResultPoJo<List<PadMageListVo>> poJo = new ResultPoJo<>();
        poJo.setResult(list);
        return poJo;
    }

    /**
     * 分页查询
     * @param po
     * @return
     */
    public ResultPoJo<Page<PadMageListVo>> findForPages(PadMagePagePo po) {
        Page<PadMageListVo> page = po.getPage();
        List<PadMageListVo> list = padMageMapper.findPage(po);
        page.setList(list);

        ResultPoJo<Page<PadMageListVo>> poJo = new ResultPoJo<>();
        poJo.setResult(page);
        return poJo;
    }

    /**
     * 新增一个记录
     * @param po
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo addOne(PadMageInsertPo po) {
        PadMage entity = new PadMage();
        ConverterUtil.copyProperties(po,entity);
        entity.setViews(0);

        entity.preInsert();

        padMageMapper.insertSelective(entity);

        return new ResultPoJo();
    }

    /**
     * 修改一个记录
     * @param po
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo updateOne(PadMageUpdatePo po) {
        PadMage entity = padMageMapper.selectByPrimaryKey(po.getId());
        if (entity == null) {
            ResultPoJo<Object> poJo = new ResultPoJo<>();
            poJo.setCode("999");
            poJo.setMsg("找不到此数据");
            return poJo;
        }
        entity = new PadMage();
        ConverterUtil.copyProperties(po,entity);
        entity.preUpdate();

        padMageMapper.updateByPrimaryKeySelective(entity);

        return new ResultPoJo();
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo delete(List<Long> ids) {
        ids.forEach(i->{
            PadMage padMage = padMageMapper.selectByPrimaryKey(i);
            if(ConverterUtil.isNotEmpty(padMage)){
                padMage.setDelFlag("1");
                padMage.preUpdate();
                padMageMapper .updateByPrimaryKeySelective(padMage);
            }
        });
        return new ResultPoJo();
    }


    /**
     * @author jirg
     * @date 2020/8/11 16:45
     * @Description 病虫害监测定时任务
     */
    public ResultPoJo healthCheck() {
        //redis存8分钟，每5分钟计算一次，第一次记录后，如果第二次断裂，则在第三次记录时重新记录
        int timeOut = 60 * 8;

        //查询所有物联网监控设备
        EquInfoMage equInfoMage = new EquInfoMage();
        equInfoMage.setEquType("0");
        List<EquInfoMage> equInfos = equInfoMageMapper.findAllList(equInfoMage);
        equInfos.forEach(eq -> {
            //获取设备最新节点数据
            EquDataPointPo remotPo = new EquDataPointPo();
            remotPo.setEquEntpId(eq.getEquEntpId());
            remotPo.setEquNum(eq.getEquNum());
            remotPo.setEquDateType("1");
            ResultPoJo<XaircraftInfluxVo> remotResult = equipmentJobMss.remotLastDataPoint(remotPo);
            XaircraftInfluxVo result = remotResult.getResult();
            if(!remotResult.getCode().equals(ConstantCodeMsg.NOMAL) || ConverterUtil.isEmpty(result)){
                return;
            }

            //查询设备下所有的档案信息
            List<ArchBasicInfoVo> archs = equInfoMageMapper.findArchByEquId(eq.getId());
            for (ArchBasicInfoVo arch : archs) {
                HealthCheckPo healthCheckPo = new HealthCheckPo();
                healthCheckPo.setCommId(arch.getCommId());
                healthCheckPo.setHumidity(result.getHumidity());
                healthCheckPo.setTemperature(result.getTemperature());

                List<PadMageListVo> padList = padMageMapper.healthCheck(healthCheckPo);
                for (PadMageListVo pad : padList) {
                    String redisKey = HEALTH_CHECK_PREFIX + eq.getId() + "_" + pad.getId() + "_" + arch.getArchId();
                    String continuedRedisKey = HEALTH_CONTINUED_CHECK_PREFIX + eq.getId() + "_" + pad.getId() + "_" + arch.getArchId();
                    if (jedisdao.exists(redisKey)) {
                        HealthCheckVo vo = jedisdao.getSerialize(redisKey, HealthCheckVo.class);
                        long duration = vo.getDuration() + 5;
                        long cxsj = vo.getBfTime() - duration;
                        if (cxsj <= 5 && cxsj >= -5) { //持续时间在爆发时间左右10分钟
                            PadYjInfo info = new PadYjInfo();
                            info.setArchId(arch.getArchId());
                            info.setEquId(eq.getId());
                            info.setPadId(pad.getId());
                            info.setPadName(pad.getPadName());
                            info.setCxsjTime((double) duration);
                            info.setReportTime(OffsetDateTime.now());

                            //判断缓存中是否存在已持续时间
                            Long continued = jedisdao.getSerialize(continuedRedisKey, Long.class);
                            continued = ConverterUtil.isEmpty(continued) ? duration : continued + duration;

                            info.setContent("当前种植可能发生了病虫害，已经持续了" + ConverterUtil.getRoundValue(continued / 60D, 0) + "个小时，请尽快前往实地查看并提前做好防治工作！");
                            info.preInsert();
                            //插入预警记录
                            padYjInfoMapper.insertSelective(info);
                            //发送通知短信
                            InsctWarningPo insctWarningPo = new InsctWarningPo();
                            insctWarningPo.setId(info.getId());
                            insctWarningPo.setEquId(info.getEquId());
                            sendService.sendWarningMsg(insctWarningPo);
                            //删除redis记录
                            jedisdao.delSerialize(redisKey);
                            //记录已持续时间
                            jedisdao.setSerializeExpire(continuedRedisKey, continued, Long.valueOf(vo.getBfTime() * 60 * 60).intValue());
                        } else {
                            vo.setDuration(vo.getDuration() + 5);
                            vo.setUpdateDate(OffsetDateTime.now());
                            jedisdao.setSerializeExpire(redisKey, vo, timeOut);
                        }
                    } else {
                        HealthCheckVo vo = new HealthCheckVo();
                        vo.setCreateDate(OffsetDateTime.now());
                        vo.setBfTime((long) (pad.getBfTime() * 60));
                        vo.setDuration(0L);
                        vo.setEquId(eq.getId());
                        vo.setPadId(pad.getId());
                        jedisdao.setSerializeExpire(redisKey, vo, timeOut);
                    }
                }
            }
        });
        return new ResultPoJo();
    }
}
