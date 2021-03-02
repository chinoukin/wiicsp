package com.wisea.transac.tp.product.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.dao.LevelSpecQuoteMapper;
import com.wisea.transac.common.dao.MeasUnitMageMapper;
import com.wisea.transac.common.entity.MeasUnitMage;
import com.wisea.transac.common.po.product.MeasUnitMageGetPo;
import com.wisea.transac.common.po.product.MeasUnitMageListPo;
import com.wisea.transac.common.vo.LevelSpecQuoteInfoVo;
import com.wisea.transac.common.vo.product.MeasUnitMageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2018/9/19 上午9:44
 * @Description:计量单位管理相关接口业务类
 */
@Service
@Transactional(readOnly = true)
public class MeasUnitService {

    @Autowired
    MeasUnitMageMapper measUnitMageMapper;

    @Autowired
    LevelSpecQuoteMapper levelSpecQuoteMapper;


    /**
     * 查询计量单位的列表
     */
    public ResultPoJo<List<MeasUnitMageListVo>> measList(MeasUnitMageListPo po) {
        ResultPoJo<List<MeasUnitMageListVo>> poJo = new ResultPoJo<>();
        List<MeasUnitMageListVo> measUnitMageList = measUnitMageMapper.measList(po);
        poJo.setResult(measUnitMageList);
        return poJo;
    }


    /**
     * 添加计量单位
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo addMeas(MeasUnitMage po) {
        ResultPoJo poJo = new ResultPoJo(ConstantCodeMsg.ERR_000);
        //查看编号和名称是否相同
        if (po.getUnitNum().equals(po.getMeasUnitName())) {
            poJo.setCode(ConstantCodeMsg.ERR_313);
            poJo.setMsg(ConstantCodeMsg.MSG_313);
            return poJo;
        }
        List<MeasUnitMage> measUnitMages = measUnitMageMapper.selectRepeatByNumAndName(po);
        if (measUnitMages.size() > 0) {
            poJo.setCode(ConstantCodeMsg.ERR_313);
            poJo.setMsg(ConstantCodeMsg.MSG_313);
            return poJo;
        }
        if (ConverterUtil.isEmpty(po.getSort())) {
            po.setSort(null);
        }
        po.preInsert();
        measUnitMageMapper.insertSelective(po);
        return poJo;
    }


    /**
     * 编辑计量单位
     */
    public ResultPoJo<MeasUnitMage> editMeas(MeasUnitMageGetPo po) {
        ResultPoJo<MeasUnitMage> poJo = new ResultPoJo<>();
        //修改之前查看是否有商品引用这个计量单位
        List<LevelSpecQuoteInfoVo> commCiteMeasUnit = levelSpecQuoteMapper.beforeDelSelectMeas(po.getId());
        if (commCiteMeasUnit.size() > 0) {
            poJo.setCode(ConstantCodeMsg.ERR_312);
            poJo.setMsg(ConstantCodeMsg.MSG_312);
            return poJo;
        }
        MeasUnitMage measUnitMage = measUnitMageMapper.selectByPrimaryKey(po.getId());
        poJo.setResult(measUnitMage);
        return poJo;
    }

    /**
     * 修改计量单位
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo modifyMeas(MeasUnitMage po) {
        ResultPoJo poJo = new ResultPoJo(ConstantCodeMsg.ERR_000);
        //查看编号和名称是否相同
        if (po.getUnitNum().equals(po.getMeasUnitName())) {
            poJo.setCode(ConstantCodeMsg.ERR_313);
            poJo.setMsg(ConstantCodeMsg.MSG_313);
            return poJo;
        }
        if (ConverterUtil.isEmpty(po.getSort())) {
            po.setSort(null);
        }
        List<MeasUnitMage> measUnitMages = measUnitMageMapper.selectOnlyOne(po);
        if (measUnitMages.size() > 0) {
            poJo.setCode(ConstantCodeMsg.ERR_321);
            poJo.setMsg(ConstantCodeMsg.MSG_321);
            return poJo;
        }
        measUnitMageMapper.updateByPrimaryKeySelective(po);
        return poJo;
    }

    /**
     * 删除计量单位
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo delMeas(MeasUnitMage po) {
        ResultPoJo poJo = new ResultPoJo(ConstantCodeMsg.ERR_000);
        //删除之前查看是否有商品引用这个计量单位
        List<LevelSpecQuoteInfoVo> commCiteMeasUnit = levelSpecQuoteMapper.beforeDelSelectMeas(po.getId());
        if (commCiteMeasUnit.size() > 0) {
            poJo.setCode(ConstantCodeMsg.ERR_312);
            poJo.setMsg(ConstantCodeMsg.MSG_312);
            return poJo;
        }
        measUnitMageMapper.deleteLogic(po);
        return poJo;
    }

    /**
     * 计量单位接口
     */
    public ResultPoJo<List<MeasUnitMageListVo>> measUnitInterface() {
        ResultPoJo<List<MeasUnitMageListVo>> poJo = new ResultPoJo<>();
        List<MeasUnitMageListVo> measUnitMageListVos = measUnitMageMapper.measUnitInterface();
        poJo.setResult(measUnitMageListVos);
        return poJo;
    }
}
