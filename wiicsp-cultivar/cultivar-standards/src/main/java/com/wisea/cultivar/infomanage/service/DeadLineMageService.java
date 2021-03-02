package com.wisea.cultivar.infomanage.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.constants.DictConstants;
import com.wisea.cultivar.common.dao.DeadLineMageMapper;
import com.wisea.cultivar.common.entity.DeadLineMage;
import com.wisea.cultivar.common.po.system.DeadLineInsertPo;
import com.wisea.cultivar.common.utils.DeadLineUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangjh
 * @version 1.0
 * @className DeadLineMageService
 * @since 2018/9/18 17:25
 */
@Service
public class DeadLineMageService extends BaseService {

    @Autowired
    private DeadLineMageMapper mapper;

    /**
     * @Author jirg
     * @Date 2020/4/30 15:43
     * @Description 查询所有期限设置
     **/
    public ResultPoJo<List<DeadLineMage>> findAllDeadLine() {
        LoggerUtil.infoWithContext("【findAllDeadLine】查询所有期限设置：", null);
        ResultPoJo<List<DeadLineMage>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<DeadLineMage> deadLines = DeadLineUtils.getAllDeadLine();
        resultPoJo.setResult(deadLines);
        return resultPoJo;
    }

    /**
     * @Author jirg
     * @Date 2020/4/30 16:07
     * @Description 保存期限设置
     **/
    public ResultPoJo<?> saveDeadLines(DeadLineInsertPo po){
        LoggerUtil.infoWithContext("【saveDeadLines】保存期限设置：", null);
        ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        List<DeadLineMage> deadLines = Lists.newArrayList();
        deadLines.add(getDeadLineMage(DictConstants.DEAD_LINE_TYPE_0,po));
        deadLines.add(getDeadLineMage(DictConstants.DEAD_LINE_TYPE_1,po));
        deadLines.add(getDeadLineMage(DictConstants.DEAD_LINE_TYPE_2,po));
        deadLines.add(getDeadLineMage(DictConstants.DEAD_LINE_TYPE_3,po));
        deadLines.add(getDeadLineMage(DictConstants.DEAD_LINE_TYPE_4,po));
        deadLines.add(getDeadLineMage(DictConstants.DEAD_LINE_TYPE_5,po));
        deadLines.add(getDeadLineMage(DictConstants.DEAD_LINE_TYPE_6,po));
        deadLines.add(getDeadLineMage(DictConstants.DEAD_LINE_TYPE_7,po));

        //删除旧数据
        mapper.deleteAll();
        //批量插入新数据
        mapper.batchInsert(deadLines);
        //删除缓存数据
        DeadLineUtils.clearCache();
        return resultPoJo;
    }


    private DeadLineMage getDeadLineMage(String deadLineType, DeadLineInsertPo po){
        DeadLineMage deadLine = new DeadLineMage();
        deadLine.setDeadLineType(deadLineType);
        if(deadLineType.equals(DictConstants.DEAD_LINE_TYPE_0)){
            deadLine.setLimitDays(po.getConfirmDeadline());
        }else if(deadLineType.equals(DictConstants.DEAD_LINE_TYPE_1)){
            deadLine.setLimitDays(po.getPayDeadline());
        }
        deadLine.preInsert();
        return deadLine;
    }
}
