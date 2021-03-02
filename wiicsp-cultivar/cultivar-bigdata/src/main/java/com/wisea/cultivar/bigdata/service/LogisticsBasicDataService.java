package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.common.dao.bigdata.LogisticsBasicDataMapper;
import com.wisea.cultivar.common.entity.bigdata.LogisticsBasicData;
import com.wisea.cultivar.common.po.bigdata.LogisticBasicDataPo;
import com.wisea.cultivar.common.po.bigdata.LogisticsBasicDataBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.LogisticsBasicDataInsertPo;
import com.wisea.cultivar.common.po.bigdata.LogisticsBasicDataListPo;
import com.wisea.cultivar.common.vo.bigdata.LogisticsBasicDataListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * LogisticsBasicDataService
 * 物流基础数据 Service
 * 2020/09/03 10:24:52
 */
@Service
public class LogisticsBasicDataService extends BaseService {
    @Autowired
    protected LogisticsBasicDataMapper logisticsBasicDataMapper;


    /**
     * 查询列表
     */
    public ResultPoJo<List<LogisticsBasicDataListVo>> findList() {
        ResultPoJo<List<LogisticsBasicDataListVo>> result = new ResultPoJo<>();
        List<LogisticsBasicDataListVo> list = logisticsBasicDataMapper.findList(new LogisticsBasicDataListPo());
        if (list.isEmpty()) {
            LogisticsBasicDataListVo vo1 = new LogisticsBasicDataListVo();
            vo1.setLogisticsBasicDataType("0");
            LogisticsBasicDataListVo vo2 = new LogisticsBasicDataListVo();
            vo2.setLogisticsBasicDataType("1");
            LogisticsBasicDataListVo vo3 = new LogisticsBasicDataListVo();
            vo3.setLogisticsBasicDataType("2");
            LogisticsBasicDataListVo vo4 = new LogisticsBasicDataListVo();
            vo4.setLogisticsBasicDataType("3");
            LogisticsBasicDataListVo vo5 = new LogisticsBasicDataListVo();
            vo5.setLogisticsBasicDataType("4");
            LogisticsBasicDataListVo vo6 = new LogisticsBasicDataListVo();
            vo6.setLogisticsBasicDataType("5");


            list.add(vo1);
            list.add(vo2);
            list.add(vo3);
            list.add(vo4);
            list.add(vo5);
            list.add(vo6);
        }
        result.setResult(list);
        return result;
    }


    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(LogisticsBasicDataInsertPo logisticsBasicDataInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        LogisticsBasicData logisticsBasicData = new LogisticsBasicData();
        ConverterUtil.copyProperties(logisticsBasicDataInsertPo, logisticsBasicData);
        logisticsBasicData.preInsert();
        logisticsBasicDataMapper.insert(logisticsBasicData);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(LogisticBasicDataPo po) {
        ResultPoJo<Object> result = new ResultPoJo<>();

        List<LogisticsBasicDataListVo> list = logisticsBasicDataMapper.findList(new LogisticsBasicDataListPo());

        //删除以前的
        LogisticsBasicDataBatDeletePo deletePo = new LogisticsBasicDataBatDeletePo();
        deletePo.setDelList(list.stream().map(LogisticsBasicDataListVo::getId).collect(Collectors.toList()));
        batDelete(deletePo);

        //新增
        po.getList().forEach(i->{
            LogisticsBasicDataInsertPo insertPo = new LogisticsBasicDataInsertPo();
            insertPo.setLogisticsBasicDataType(i.getLogisticsBasicDataType());
            insertPo.setNum(i.getNum());
            insert(insertPo);
        });

        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(LogisticsBasicDataBatDeletePo logisticsBasicDataBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : logisticsBasicDataBatDeletePo.getDelList()) {
            LogisticsBasicData logisticsBasicData = new LogisticsBasicData();
            logisticsBasicData.setId(delId);
            logisticsBasicData.preUpdate();
            logisticsBasicDataMapper.deleteLogic(logisticsBasicData);
        }
        return result;
    }
}
