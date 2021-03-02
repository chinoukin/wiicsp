package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.exception.BusinessException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.common.util.excel.ImportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.dao.bigdata.LogisticsMapInfoMapper;
import com.wisea.cultivar.common.entity.bigdata.LogisticsMapInfo;
import com.wisea.cultivar.common.po.bigdata.LogisticsMapInfoBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.LogisticsMapInfoGetPo;
import com.wisea.cultivar.common.po.bigdata.LogisticsMapInfoInsertPo;
import com.wisea.cultivar.common.po.bigdata.LogisticsMapInfoListPo;
import com.wisea.cultivar.common.po.bigdata.LogisticsMapInfoPagePo;
import com.wisea.cultivar.common.po.bigdata.LogisticsMapInfoUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.EchartsMapDataVo;
import com.wisea.cultivar.common.vo.bigdata.LogisticsMapInfoGetVo;
import com.wisea.cultivar.common.vo.bigdata.LogisticsMapInfoListVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static com.wisea.cultivar.common.vo.bigdata.EchartsMapDataVo.getDetail;
import static com.wisea.cultivar.common.vo.bigdata.EchartsMapDataVo.getNode;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * LogisticsMapInfoService
 * 物流地图信息 Service
 * 2019/12/02 11:02:14
 */
@Service
public class LogisticsMapInfoService extends BaseService {
    @Autowired
    protected LogisticsMapInfoMapper logisticsMapInfoMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<LogisticsMapInfoListVo>> findPage(LogisticsMapInfoPagePo logisticsMapInfoPagePo) {
        ResultPoJo<Page<LogisticsMapInfoListVo>> result = new ResultPoJo<>();
        Page<LogisticsMapInfoListVo> page = logisticsMapInfoPagePo.getPage();
        List<LogisticsMapInfoListVo> list = logisticsMapInfoMapper.findPage(logisticsMapInfoPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<LogisticsMapInfoListVo>> findList(LogisticsMapInfoListPo logisticsMapInfoListPo) {
        ResultPoJo<List<LogisticsMapInfoListVo>> result = new ResultPoJo<>();
        result.setResult(logisticsMapInfoMapper.findList(logisticsMapInfoListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<LogisticsMapInfoGetVo> get(LogisticsMapInfoGetPo logisticsMapInfoGetPo) {
        ResultPoJo<LogisticsMapInfoGetVo> result = new ResultPoJo<>();
        LogisticsMapInfo entity = logisticsMapInfoMapper.selectByPrimaryKey(logisticsMapInfoGetPo.getId());
        LogisticsMapInfoGetVo vo = new LogisticsMapInfoGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(LogisticsMapInfoInsertPo logisticsMapInfoInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        //         检查坐标点是否规范
        List<String> qdzb = numberCheck(logisticsMapInfoInsertPo.getQdZb());
        if (qdzb.size() != 2) {
            throw new BusinessException(ConstantCodeMsg.ERR_113, ConstantCodeMsg.MSG_113);
        }
        List<String> zdzb = numberCheck(logisticsMapInfoInsertPo.getZdZb());
        if (zdzb.size() != 2) {
            throw new BusinessException(ConstantCodeMsg.ERR_113, ConstantCodeMsg.MSG_113);
        }
        LogisticsMapInfo logisticsMapInfo = new LogisticsMapInfo();

        ConverterUtil.copyProperties(logisticsMapInfoInsertPo, logisticsMapInfo);


        //转换坐标点位  x,y  格式
        logisticsMapInfo.setQdZb(String.join(",", qdzb));
        logisticsMapInfo.setZdZb(String.join(",", zdzb));
        logisticsMapInfo.preInsert();
        logisticsMapInfoMapper.insert(logisticsMapInfo);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(LogisticsMapInfoUpdatePo logisticsMapInfoUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        //         检查坐标点是否规范
        List<String> qdzb = numberCheck(logisticsMapInfoUpdatePo.getQdZb());
        if (qdzb.size() != 2) {
            throw new BusinessException(ConstantCodeMsg.ERR_113, ConstantCodeMsg.MSG_113);
        }
        List<String> zdzb = numberCheck(logisticsMapInfoUpdatePo.getZdZb());
        if (zdzb.size() != 2) {
            throw new BusinessException(ConstantCodeMsg.ERR_113, ConstantCodeMsg.MSG_113);
        }

        LogisticsMapInfo logisticsMapInfo = new LogisticsMapInfo();
        ConverterUtil.copyProperties(logisticsMapInfoUpdatePo, logisticsMapInfo);
        //转换坐标点位  x,y  格式
        logisticsMapInfo.setQdZb(String.join(",", qdzb));
        logisticsMapInfo.setZdZb(String.join(",", zdzb));
        logisticsMapInfo.preUpdate();
        logisticsMapInfoMapper.updateByPrimaryKeySelective(logisticsMapInfo);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(LogisticsMapInfoBatDeletePo logisticsMapInfoBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for (Long delId : logisticsMapInfoBatDeletePo.getDelList()) {
            LogisticsMapInfo logisticsMapInfo = new LogisticsMapInfo();
            logisticsMapInfo.setId(delId);
            logisticsMapInfo.preUpdate();
            logisticsMapInfoMapper.deleteLogic(logisticsMapInfo);
        }
        return result;
    }

    /**
     * 封装物流地图数据
     *
     * @return EchartsMapDataVo
     */
    public ResultPoJo<EchartsMapDataVo> findMapData() {
        ResultPoJo<EchartsMapDataVo> result = new ResultPoJo<>();
        EchartsMapDataVo vo = new EchartsMapDataVo();
        List<LogisticsMapInfoListVo> list = logisticsMapInfoMapper.findList(new LogisticsMapInfoListPo());
        if (list.size() == 0) {
            return new ResultPoJo<>();
        }
        Supplier<Stream<LogisticsMapInfoListVo>> supplier = list::stream;

        //查出所有点的名字和坐标
        EchartsMapDataVo.GeoCoordMap geoCoordMap = new EchartsMapDataVo.GeoCoordMap();
        supplier.get().forEach(i -> {
            geoCoordMap.put(i.getQd(), i.getQdZb().split(","));
            geoCoordMap.put(i.getZd(), i.getZdZb().split(","));
        });
        vo.setGeoCoordMap(geoCoordMap);

        //聚合所有起点相同的数据
        Map<String, List<LogisticsMapInfoListVo>> groupByQd = supplier.get().collect(groupingBy(LogisticsMapInfoListVo::getQd));
        Set<String> qdName = groupByQd.keySet();
        List<List<Object>> dataArr = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        for (String qd : qdName) {
            List<LogisticsMapInfoListVo> datas = groupByQd.get(qd);
            dataArr.add(getNode(qd,
                    datas.stream().map(i -> getDetail(new EchartsMapDataVo.Place(qd),//起点
                            new EchartsMapDataVo.Place(i.getZd()),//终点
                            new EchartsMapDataVo.OrderInfo(i.getOrdNum(), i.getOrdComm(), i.getOrdDate().format(formatter), i.getSendCommDate().format(formatter), i.getDqjd())))//订单详情
                            .collect(toList())));
        }
        vo.setDataArr(dataArr);
        result.setResult(vo);

        return result;
    }

    @Transactional
    public ResultPoJo excelImport(MultipartFile file) throws Exception {
        ImportExcel excel = new ImportExcel(file, 1, 0);
        List<LogisticsMapInfo> list = excel.getDataList(LogisticsMapInfo.class);
        //校验
        check(list);

        list.forEach(i -> {
            //转换坐标点位  x,y  格式
            i.setQdZb(String.join(",", numberCheck(i.getQdZb())));
            i.setZdZb(String.join(",", numberCheck(i.getZdZb())));
            i.preInsert();
            logisticsMapInfoMapper.insertSelective(i);
        });
        return new ResultPoJo();
    }

    public void excelExport(HttpServletResponse response) throws IOException {
        List<LogisticsMapInfo> list = logisticsMapInfoMapper.findAllEntity();
        new ExportExcel("物流地图信息", LogisticsMapInfo.class)
                .setDataList(list)
                .writeWithAjaxHeader(response, "物流地图信息表.xlsx")
                .dispose();
    }

    public void templateDownload(HttpServletResponse response) throws IOException {
        new ExportExcel("物流地图信息", LogisticsMapInfo.class)
                .setDataList(Collections.EMPTY_LIST)
                .writeWithAjaxHeader(response, "物流地图信息表.xlsx")
                .dispose();
    }

    /**
     * 校验数据
     *
     * @param list
     */
    private void check(List<LogisticsMapInfo> list) {
        Supplier<Stream<LogisticsMapInfo>> supplier = list::stream;
//        检查非空字段
        long count0 = supplier.get().filter(i -> i.getOrdDate() == null).count();
        if (count0 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
        }
        long count1 = supplier.get().filter(i -> i.getSendCommDate() == null).count();
        if (count1 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
        }
        long count2 = supplier.get().filter(i -> StringUtils.isEmpty(i.getQd())).count();
        if (count2 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
        }
        long count3 = supplier.get().filter(i -> StringUtils.isEmpty(i.getZd())).count();
        if (count3 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
        }
        long count4 = supplier.get().filter(i -> StringUtils.isEmpty(i.getDqjd())).count();
        if (count4 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_112, ConstantCodeMsg.MSG_112);
        }
//         检查坐标点是否规范
        long count5 = supplier.get().filter(i -> numberCheck(i.getQdZb()).size() != 2).count();
        if (count5 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_113, ConstantCodeMsg.MSG_113);
        }
        long count6 = supplier.get().filter(i -> numberCheck(i.getZdZb()).size() != 2).count();
        if (count6 > 0) {
            throw new BusinessException(ConstantCodeMsg.ERR_113, ConstantCodeMsg.MSG_113);
        }
    }

    /**
     * 正则，直接取出数字
     *
     * @param coord
     * @return
     */
    public List<String> numberCheck(String coord) {
        //language=RegExp
        String pattern = "-?([1-9]\\d*\\.\\d+|0\\.\\d*[1-9]\\d*|0?\\.0+|0|[1-9]\\d*|-[1-9]\\d*)";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(coord);
        List<String> result = new ArrayList<>();
        while (m.find()) {
            result.add(m.group());
        }
        return result;
    }

}
