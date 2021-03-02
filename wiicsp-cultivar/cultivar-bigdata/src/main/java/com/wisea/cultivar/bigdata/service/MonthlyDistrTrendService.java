package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.common.dao.bigdata.MonthlyDistrTrendMapper;
import com.wisea.cultivar.common.entity.bigdata.MonthlyDistrTrend;
import com.wisea.cultivar.common.po.bigdata.MonthlyDistrTrendBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.MonthlyDistrTrendGetPo;
import com.wisea.cultivar.common.po.bigdata.MonthlyDistrTrendInsertPo;
import com.wisea.cultivar.common.po.bigdata.MonthlyDistrTrendListPo;
import com.wisea.cultivar.common.po.bigdata.MonthlyDistrUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.MonthlyDistrTrendGetVo;
import com.wisea.cultivar.common.vo.bigdata.MonthlyDistrTrendListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * MonthlyDistrTrendService
 * 月配送单量趋势 Service
 * 2020/09/02 15:33:51
 */
@Service
public class MonthlyDistrTrendService extends BaseService {
    @Autowired
    protected MonthlyDistrTrendMapper monthlyDistrTrendMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<List<MonthlyDistrTrendListVo>> findAllList() {
        ResultPoJo<List<MonthlyDistrTrendListVo>> result = new ResultPoJo<>();
        List<MonthlyDistrTrendListVo> list = monthlyDistrTrendMapper.findList(new MonthlyDistrTrendListPo());
        if (list.isEmpty()) {
            list.add(new MonthlyDistrTrendListVo());
            list.add(new MonthlyDistrTrendListVo());
            list.add(new MonthlyDistrTrendListVo());
            list.add(new MonthlyDistrTrendListVo());
            list.add(new MonthlyDistrTrendListVo());
            list.add(new MonthlyDistrTrendListVo());
        }
        OffsetDateTime now = OffsetDateTime.now();
        //当前月不算进去
        int month = now.getMonthValue() - 1;
        int year = now.getYear() % 100;
        if (month <= 6) {
            for (int i = list.size() - 1; i >= 0; i--) {
                MonthlyDistrTrendListVo vo = list.get(i);
                if (month > 0) {
                    vo.setMonth(month + "月");
                    vo.setYear(year + "年");
                } else {
                    vo.setMonth(12 + month + "月");
                    vo.setYear(year - 1 + "年");
                }
                month--;
            }
        } else {
            for (int i = list.size() - 1; i >= 0; i--) {
                MonthlyDistrTrendListVo vo = list.get(i);
                vo.setMonth(month + "月");
                vo.setYear(year + "年");
                month--;
            }
        }
        result.setResult(list);
        return result;
    }


    /**
     * 查询列表
     */
    public ResultPoJo<List<MonthlyDistrTrendListVo>> findList(MonthlyDistrTrendListPo monthlyDistrTrendListPo) {
        ResultPoJo<List<MonthlyDistrTrendListVo>> result = new ResultPoJo<>();
        result.setResult(monthlyDistrTrendMapper.findList(monthlyDistrTrendListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<MonthlyDistrTrendGetVo> get(MonthlyDistrTrendGetPo monthlyDistrTrendGetPo) {
        ResultPoJo<MonthlyDistrTrendGetVo> result = new ResultPoJo<>();
        MonthlyDistrTrend entity = monthlyDistrTrendMapper.selectByPrimaryKey(monthlyDistrTrendGetPo.getId());
        MonthlyDistrTrendGetVo vo = new MonthlyDistrTrendGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(MonthlyDistrTrendInsertPo monthlyDistrTrendInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        MonthlyDistrTrend monthlyDistrTrend = new MonthlyDistrTrend();
        ConverterUtil.copyProperties(monthlyDistrTrendInsertPo, monthlyDistrTrend);
        monthlyDistrTrend.preInsert();
        monthlyDistrTrendMapper.insert(monthlyDistrTrend);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(MonthlyDistrUpdatePo po) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        List<MonthlyDistrTrendListVo> list = monthlyDistrTrendMapper.findList(new MonthlyDistrTrendListPo());

        //删除以前的
        MonthlyDistrTrendBatDeletePo deletePo = new MonthlyDistrTrendBatDeletePo();
        deletePo.setDelList(list.stream().map(MonthlyDistrTrendListVo::getId).collect(toList()));
        batDelete(deletePo);

        //新增
        po.getList().forEach(i->{
            MonthlyDistrTrendInsertPo insertPo = new MonthlyDistrTrendInsertPo();
            insertPo.setNum(i.getNum());
            insertPo.setRemarks(i.getRemarks());
            insert(insertPo);
        });
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(MonthlyDistrTrendBatDeletePo monthlyDistrTrendBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for (Long delId : monthlyDistrTrendBatDeletePo.getDelList()) {
            MonthlyDistrTrend monthlyDistrTrend = new MonthlyDistrTrend();
            monthlyDistrTrend.setId(delId);
            monthlyDistrTrend.preUpdate();
            monthlyDistrTrendMapper.deleteLogic(monthlyDistrTrend);
        }
        return result;
    }
}
