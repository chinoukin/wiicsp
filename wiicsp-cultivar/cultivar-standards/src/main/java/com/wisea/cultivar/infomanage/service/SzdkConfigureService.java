package com.wisea.cultivar.infomanage.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.dao.SzdkConfigureMapper;
import com.wisea.cultivar.common.entity.SzdkConfigure;
import com.wisea.cultivar.common.entity.SzdkConfigureWithBLOBs;
import com.wisea.cultivar.common.po.SzdkConfigurePageListPo;
import com.wisea.cultivar.common.po.SzdkConfigurePo;
import com.wisea.cultivar.common.vo.SzdkConfigureInfoVo;
import com.wisea.cultivar.common.vo.SzdkConfigurePageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className SzdkConfigureService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class SzdkConfigureService extends BaseService {
    @Autowired
    private SzdkConfigureMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询SzdkConfigure
     */
    public ResultPoJo<Page<SzdkConfigurePageListVo>> findPageList(SzdkConfigurePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<Page<SzdkConfigurePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<SzdkConfigurePageListVo> page = po.getPage();
        List<SzdkConfigurePageListVo> list = mapper.findPageList(po);
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除SzdkConfigure
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        SzdkConfigure entity = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(entity)) {
            entity.setDelFlag(SzdkConfigure.DEL_FLAG_DELETE);
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
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改SzdkConfigure
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo saveOrUpdate(SzdkConfigurePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
        ResultPoJo<Long> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        if (ConverterUtil.isNotEmpty(po.getId())) {
            //修改
            SzdkConfigureWithBLOBs entity = mapper.findById(po.getId());
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
            SzdkConfigureWithBLOBs entity = new SzdkConfigureWithBLOBs();
            BeanUtils.copyProperties(po, entity);
            entity.preInsert();
            mapper.insert(entity);
            resultPoJo.setResult(entity.getId());
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息SzdkConfigure
     */
    public ResultPoJo<SzdkConfigureInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<SzdkConfigureInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        SzdkConfigureInfoVo vo = mapper.findInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 查询默认数据
     *
     * @return
     */
    public ResultPoJo<SzdkConfigureInfoVo> findInfo() {
        ResultPoJo<SzdkConfigureInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        SzdkConfigureInfoVo vo = mapper.findDetail();
        if (ConverterUtil.isNotEmpty(vo)) {
            resultPoJo.setResult(vo);
        }
        return resultPoJo;
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo set(SzdkConfigurePo po) {
        ResultPoJo<Long> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        SzdkConfigureInfoVo vo = mapper.findDetail();
        if (ConverterUtil.isNotEmpty(vo)) {
            po.setId(vo.getId());
            //修改
            SzdkConfigureWithBLOBs entity = mapper.findById(vo.getId());
            ConverterUtil.copyProperties(po, entity);
            entity.preUpdate();
            mapper.updateByPrimaryKeySelective(entity);
        } else {
            //新增
            SzdkConfigureWithBLOBs entity = new SzdkConfigureWithBLOBs();
            BeanUtils.copyProperties(po, entity);
            entity.preInsert();
            mapper.insert(entity);
        }
        return resultPoJo;
    }


}
