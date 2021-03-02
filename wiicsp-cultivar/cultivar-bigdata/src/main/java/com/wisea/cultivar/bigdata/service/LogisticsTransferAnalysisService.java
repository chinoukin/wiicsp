package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.common.dao.bigdata.LogisticsTransferAnalysisMapper;
import com.wisea.cultivar.common.entity.bigdata.LogisticsTransferAnalysis;
import com.wisea.cultivar.common.po.bigdata.LogisticsTransferAnalysisBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.LogisticsTransferAnalysisInsertPo;
import com.wisea.cultivar.common.po.bigdata.LogisticsTransferAnalysisListPo;
import com.wisea.cultivar.common.po.bigdata.LogisticsTransferPo;
import com.wisea.cultivar.common.vo.bigdata.LogisticsTransferAnalysisListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * LogisticsTransferAnalysisService
 * 物流中转分析 Service
 * 2020/09/02 15:33:51
 */
@Service
public class LogisticsTransferAnalysisService extends BaseService {
    @Autowired
    protected LogisticsTransferAnalysisMapper logisticsTransferAnalysisMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<List<LogisticsTransferAnalysisListVo>> findAllList() {
        ResultPoJo<List<LogisticsTransferAnalysisListVo>> result = new ResultPoJo<>();
        List<LogisticsTransferAnalysisListVo> list = logisticsTransferAnalysisMapper.findList(new LogisticsTransferAnalysisListPo());
        if (list.isEmpty()) {
            LogisticsTransferAnalysisListVo vo1 = new LogisticsTransferAnalysisListVo();
            vo1.setLogisticsTransferAnalysisType("0");
            vo1.setNum(0D);
            vo1.setRemarks("应到");
            LogisticsTransferAnalysisListVo vo2 = new LogisticsTransferAnalysisListVo();
            vo2.setLogisticsTransferAnalysisType("1");
            vo2.setNum(0D);
            vo2.setRemarks("未到");
            LogisticsTransferAnalysisListVo vo3 = new LogisticsTransferAnalysisListVo();
            vo3.setLogisticsTransferAnalysisType("2");
            vo3.setNum(0D);
            vo3.setRemarks("未发货");
            LogisticsTransferAnalysisListVo vo4 = new LogisticsTransferAnalysisListVo();
            vo4.setLogisticsTransferAnalysisType("3");
            vo4.setNum(0D);
            vo4.setRemarks("应发");
            LogisticsTransferAnalysisListVo vo5 = new LogisticsTransferAnalysisListVo();
            vo5.setLogisticsTransferAnalysisType("4");
            vo5.setNum(0D);
            vo5.setRemarks("实发");
            LogisticsTransferAnalysisListVo vo6 = new LogisticsTransferAnalysisListVo();
            vo6.setLogisticsTransferAnalysisType("5");
            vo6.setNum(0D);
            vo6.setRemarks("未发出");

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
    public ResultPoJo<Object> insert(LogisticsTransferAnalysisInsertPo logisticsTransferAnalysisInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        LogisticsTransferAnalysis logisticsTransferAnalysis = new LogisticsTransferAnalysis();
        ConverterUtil.copyProperties(logisticsTransferAnalysisInsertPo, logisticsTransferAnalysis);
        logisticsTransferAnalysis.preInsert();
        logisticsTransferAnalysisMapper.insert(logisticsTransferAnalysis);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(LogisticsTransferPo po) {
        ResultPoJo<Object> result = new ResultPoJo<>();

        List<LogisticsTransferAnalysisListVo> list = logisticsTransferAnalysisMapper.findList(new LogisticsTransferAnalysisListPo());
        //删除之前的
        LogisticsTransferAnalysisBatDeletePo deletePo = new LogisticsTransferAnalysisBatDeletePo();
        deletePo.setDelList(list.stream().map(LogisticsTransferAnalysisListVo::getId).collect(Collectors.toList()));
        batDelete(deletePo);

        //新增
        po.getList().forEach(i->{
            LogisticsTransferAnalysisInsertPo insertPo = new LogisticsTransferAnalysisInsertPo();
            insertPo.setLogisticsTransferAnalysisType(i.getLogisticsTransferAnalysisType());
            insertPo.setNum(i.getNum());
            String remarks = "";
            switch (i.getLogisticsTransferAnalysisType()) {
                case "0":remarks = "应到";break;
                case "1":remarks = "未到";break;
                case "2":remarks = "未发货";break;
                case "3":remarks = "应发";break;
                case "4":remarks = "实发";break;
                case "5":remarks = "未发出";break;
                default:break;
            }
            insertPo.setRemarks(remarks);
            insert(insertPo);
        });

        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(LogisticsTransferAnalysisBatDeletePo logisticsTransferAnalysisBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : logisticsTransferAnalysisBatDeletePo.getDelList()) {
            LogisticsTransferAnalysis logisticsTransferAnalysis = new LogisticsTransferAnalysis();
            logisticsTransferAnalysis.setId(delId);
            logisticsTransferAnalysis.preUpdate();
            logisticsTransferAnalysisMapper.deleteLogic(logisticsTransferAnalysis);
        }
        return result;
    }
}
