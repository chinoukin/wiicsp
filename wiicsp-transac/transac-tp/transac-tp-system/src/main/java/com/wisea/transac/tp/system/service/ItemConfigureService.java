package com.wisea.transac.tp.system.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.dao.ItemConfigureMapper;
import com.wisea.transac.common.entity.ItemConfigure;
import com.wisea.transac.common.entity.ItemConfigureWithBLOBs;
import com.wisea.transac.common.po.ItemConfigurePageListPo;
import com.wisea.transac.common.po.ItemConfigurePo;
import com.wisea.transac.common.vo.ItemConfigureInfoVo;
import com.wisea.transac.common.vo.ItemConfigurePageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className ItemConfigureService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class ItemConfigureService extends BaseService {
    @Autowired
    private ItemConfigureMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询ItemConfigure
     */
    public ResultPoJo<Page<ItemConfigurePageListVo>> findPageList(ItemConfigurePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<Page<ItemConfigurePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<ItemConfigurePageListVo> page = po.getPage();
        List<ItemConfigurePageListVo> list = mapper.findPageList(po);
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除ItemConfigure
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        ItemConfigure entity = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(entity)) {
            entity.setDelFlag(ItemConfigure.DEL_FLAG_DELETE);
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
     * @Description 新增或修改ItemConfigure
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo saveOrUpdate(ItemConfigurePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
        ResultPoJo<Long> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        if (ConverterUtil.isNotEmpty(po.getId())) {
            //修改
            ItemConfigureWithBLOBs entity = mapper.findById(po.getId());
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
            ItemConfigureWithBLOBs entity = new ItemConfigureWithBLOBs();
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
     * @Description 查询详细信息ItemConfigure
     */
    public ResultPoJo<ItemConfigureInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<ItemConfigureInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        ItemConfigureInfoVo vo = mapper.findInfo(po);
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
    public ResultPoJo<ItemConfigureInfoVo> findInfo() {
        ResultPoJo<ItemConfigureInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        ItemConfigureInfoVo vo = mapper.findDetail();
        if (ConverterUtil.isNotEmpty(vo)) {
            resultPoJo.setResult(vo);
        }
        return resultPoJo;
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo set(ItemConfigurePo po) {
        ResultPoJo<Long> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        ItemConfigureInfoVo vo = mapper.findDetail();
        if (ConverterUtil.isNotEmpty(vo)) {
            po.setId(vo.getId());
            //修改
            ItemConfigureWithBLOBs entity = mapper.findById(vo.getId());
            ConverterUtil.copyProperties(po, entity);
            entity.preUpdate();
            mapper.updateByPrimaryKeySelective(entity);
        } else {
            //新增
            ItemConfigureWithBLOBs entity = new ItemConfigureWithBLOBs();
            BeanUtils.copyProperties(po, entity);
            entity.preInsert();
            mapper.insert(entity);
        }
        return resultPoJo;
    }


}
