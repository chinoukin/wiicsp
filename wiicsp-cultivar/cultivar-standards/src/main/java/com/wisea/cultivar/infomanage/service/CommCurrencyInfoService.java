package com.wisea.cultivar.infomanage.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.dao.CommCurrencyInfoMapper;
import com.wisea.cultivar.common.entity.ZhfwCommCurrencyInfo;
import com.wisea.cultivar.common.entity.EntpCommPubExamType;
import com.wisea.cultivar.common.po.CommCurrencyInfoPageListPo;
import com.wisea.cultivar.common.po.CommCurrencyInfoPo;
import com.wisea.cultivar.common.po.DelAllPo;
import com.wisea.cultivar.common.po.EntpCommPubExamTypePo;
import com.wisea.cultivar.common.vo.CommCurrencyInfoInfoVo;
import com.wisea.cultivar.common.vo.CommCurrencyInfoPageListVo;
import com.wisea.cultivar.common.vo.EntpCommPubExamTypeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className CommCurrencyInfoService
 * @date 2020/05/11 14:30:27
 * @Description
 */
@Service
public class CommCurrencyInfoService extends BaseService {
    @Autowired
    private CommCurrencyInfoMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 14:30:27
     * @Description 分页查询CommCurrencyInfo
     */
    public ResultPoJo<Page<CommCurrencyInfoPageListVo>> findPageList(CommCurrencyInfoPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<Page<CommCurrencyInfoPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<CommCurrencyInfoPageListVo> page = po.getPage();
        List<CommCurrencyInfoPageListVo> list = mapper.findPageList(po);
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 14:30:27
     * @Description 逻辑删除CommCurrencyInfo
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        ZhfwCommCurrencyInfo entity = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(entity)) {
            entity.setDelFlag(ZhfwCommCurrencyInfo.DEL_FLAG_DELETE);
            entity.preUpdate();
            mapper.updateByPrimaryKey(entity);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 14:30:27
     * @Description 新增或修改CommCurrencyInfo
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo saveOrUpdate(CommCurrencyInfoPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        if (ConverterUtil.isNotEmpty(po.getId())) {
            //修改
            ZhfwCommCurrencyInfo entity = mapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isNotEmpty(entity)) {
                BeanUtils.copyProperties(po, entity);
                entity.preUpdate();
                mapper.updateByPrimaryKeySelective(entity);
            } else {
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
            }
        } else {
            //新增
            ZhfwCommCurrencyInfo entity = new ZhfwCommCurrencyInfo();
            BeanUtils.copyProperties(po, entity);
            entity.preInsert();
            mapper.insert(entity);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 14:30:27
     * @Description 查询详细信息CommCurrencyInfo
     */
    public ResultPoJo<CommCurrencyInfoInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<CommCurrencyInfoInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        CommCurrencyInfoInfoVo vo = mapper.findInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    public ResultPoJo<CommCurrencyInfoInfoVo> findDetail() {
        ResultPoJo<CommCurrencyInfoInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        CommCurrencyInfoInfoVo vo = mapper.findDetail();
        if (ConverterUtil.isNotEmpty(vo)) {
            resultPoJo.setResult(vo);
        }
        return resultPoJo;
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo set(CommCurrencyInfoPo po) {
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        CommCurrencyInfoInfoVo detail = mapper.findDetail();
        if (ConverterUtil.isNotEmpty(detail)) {
            //修改
            ZhfwCommCurrencyInfo entity = mapper.selectByPrimaryKey(detail.getId());
            entity.setCommCurrencyContent(po.getCommCurrencyContent());
            entity.preUpdate();
            mapper.updateByPrimaryKeySelective(entity);
        } else {
            //新增
            ZhfwCommCurrencyInfo entity = new ZhfwCommCurrencyInfo();
            BeanUtils.copyProperties(po, entity);
            entity.preInsert();
            mapper.insert(entity);
        }
        return resultPoJo;
    }

    public ResultPoJo<EntpCommPubExamTypeVo> findEntpCommPubExamType() {
        ResultPoJo<EntpCommPubExamTypeVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        EntpCommPubExamTypeVo vo = mapper.findEntpCommPubExamType();
        if (ConverterUtil.isNotEmpty(vo)) {
            resultPoJo.setResult(vo);
        }else{
            vo.setEntpCommPubExamType("1");
            resultPoJo.setResult(vo);
        }
        return resultPoJo;
    }

    public ResultPoJo<EntpCommPubExamTypeVo> updateEntpCommPubExamType(EntpCommPubExamTypePo po) {
        EntpCommPubExamTypeVo vo = mapper.findEntpCommPubExamType();
        System.err.println(vo.getId());
        if(ConverterUtil.isNotEmpty(vo.getId())){
            vo.setEntpCommPubExamType(po.getEntpCommPubExamType());
            mapper.updateEntpCommPubExamType(vo);
        }else{
            EntpCommPubExamType entpCommPubExamType = new EntpCommPubExamType();
            ConverterUtil.copyProperties(po,entpCommPubExamType);
            entpCommPubExamType.preInsert();
            entpCommPubExamType.setEntpCommPubExamType(po.getEntpCommPubExamType());

            mapper.insertEntpCommPubExamType(entpCommPubExamType);
        }
        return new ResultPoJo<>(ConstantError.NOMAL);
    }

    /**
     * TODO:批量删除
     * Author: xiehy
     * Date: 2020/9/12 10:17
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo delAll(DelAllPo po) {
        for (Long id : po.getIds()) {
            LongIdPo longIdPo = new LongIdPo();
            longIdPo.setId(id);
            logicDel(longIdPo);
        }
        return new ResultPoJo(ConstantError.NOMAL);
    }
}
