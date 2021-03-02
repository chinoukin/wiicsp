package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.dao.bigdata.NationalDistrStatisticsMapper;
import com.wisea.cultivar.common.entity.bigdata.NationalDistrStatistics;
import com.wisea.cultivar.common.po.bigdata.NationalDistrStatisticsBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.NationalDistrStatisticsGetPo;
import com.wisea.cultivar.common.po.bigdata.NationalDistrStatisticsInsertPo;
import com.wisea.cultivar.common.po.bigdata.NationalDistrStatisticsListPo;
import com.wisea.cultivar.common.po.bigdata.NationalDistrStatisticsPagePo;
import com.wisea.cultivar.common.po.bigdata.NationalDistrStatisticsUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.NationalDistrStatisticsGetVo;
import com.wisea.cultivar.common.vo.bigdata.NationalDistrStatisticsListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * NationalDistrStatisticsService
 * 全国配送统计 Service
 * 2020/09/02 15:16:31
 */
@Service
public class NationalDistrStatisticsService extends BaseService {
    @Autowired
    protected NationalDistrStatisticsMapper nationalDistrStatisticsMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<NationalDistrStatisticsListVo>> findPage(NationalDistrStatisticsPagePo nationalDistrStatisticsPagePo) {
        ResultPoJo<Page<NationalDistrStatisticsListVo>> result = new ResultPoJo<>();
        Page<NationalDistrStatisticsListVo> page = nationalDistrStatisticsPagePo.getPage();
        List<NationalDistrStatisticsListVo> list = nationalDistrStatisticsMapper.findPage(nationalDistrStatisticsPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<NationalDistrStatisticsListVo>> findList(NationalDistrStatisticsListPo nationalDistrStatisticsListPo) {
        ResultPoJo<List<NationalDistrStatisticsListVo>> result = new ResultPoJo<>();
        result.setResult(nationalDistrStatisticsMapper.findList(nationalDistrStatisticsListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<NationalDistrStatisticsGetVo> get(NationalDistrStatisticsGetPo nationalDistrStatisticsGetPo) {
        ResultPoJo<NationalDistrStatisticsGetVo> result = new ResultPoJo<>();
        NationalDistrStatistics entity = nationalDistrStatisticsMapper.selectByPrimaryKey(nationalDistrStatisticsGetPo.getId());
        NationalDistrStatisticsGetVo vo = new NationalDistrStatisticsGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(NationalDistrStatisticsInsertPo nationalDistrStatisticsInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        NationalDistrStatistics nationalDistrStatistics = new NationalDistrStatistics();
        ConverterUtil.copyProperties(nationalDistrStatisticsInsertPo, nationalDistrStatistics);
        nationalDistrStatistics.preInsert();
        nationalDistrStatisticsMapper.insert(nationalDistrStatistics);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(NationalDistrStatisticsUpdatePo nationalDistrStatisticsUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        NationalDistrStatistics nationalDistrStatistics = new NationalDistrStatistics();
        ConverterUtil.copyProperties(nationalDistrStatisticsUpdatePo, nationalDistrStatistics);
        nationalDistrStatistics.preUpdate();
        nationalDistrStatisticsMapper.updateByPrimaryKeySelective(nationalDistrStatistics);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(NationalDistrStatisticsBatDeletePo nationalDistrStatisticsBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for (Long delId : nationalDistrStatisticsBatDeletePo.getDelList()) {
            NationalDistrStatistics nationalDistrStatistics = new NationalDistrStatistics();
            nationalDistrStatistics.setId(delId);
            nationalDistrStatistics.preUpdate();
            nationalDistrStatisticsMapper.deleteLogic(nationalDistrStatistics);
        }
        return result;
    }

    /**
     * @return
     */
    public ResultPoJo<List<EchartsShowDataVo>> showData() {
        ResultPoJo<List<EchartsShowDataVo>> resultPoJo = new ResultPoJo<>();
        List<EchartsShowDataVo> list = new ArrayList<>();
        List<NationalDistrStatisticsListVo> datas = nationalDistrStatisticsMapper.findList(new NationalDistrStatisticsListPo());
        if (!datas.isEmpty()) {
            list = datas.stream()
                    .map(i -> new EchartsShowDataVo(i.getCityName(), i.getNum()))
                    .collect(Collectors.toList());
        }
        resultPoJo.setResult(list);
        return resultPoJo;
    }

    public class EchartsShowDataVo {
        private String name;
        private Integer value;

        public EchartsShowDataVo(String name, Integer value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
}
