package com.wisea.transac.seller.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.dao.ApPayMageMapper;
import com.wisea.transac.common.entity.ApPayMage;
import com.wisea.transac.common.po.trade.ApPayMagePageListPo;
import com.wisea.transac.common.po.trade.ApPayMagePo;
import com.wisea.transac.common.vo.trade.ApPayMageInfoVo;
import com.wisea.transac.common.vo.trade.ApPayMagePageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className ApPayMageService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class ApPayMageService extends BaseService {
    @Autowired
    private ApPayMageMapper apPayMageMapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询ApPayMage
     */
    public ResultPoJo<Page<ApPayMagePageListVo>> findPageList(ApPayMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        User user = SystemUtils.getUser();
        po.setMembId(user.getId());
        ResultPoJo<Page<ApPayMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<ApPayMagePageListVo> page = po.getPage();
        List<ApPayMagePageListVo> list = apPayMageMapper.findminiPageList(po);
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除ApPayMage
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        ApPayMage entity = apPayMageMapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(entity)) {
            entity.setDelFlag(ApPayMage.DEL_FLAG_DELETE);
            entity.preUpdate();
            apPayMageMapper.updateByPrimaryKey(entity);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改ApPayMage
     */
    public ResultPoJo saveOrUpdate(ApPayMagePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        if (ConverterUtil.isNotEmpty(po.getId())) {
            //修改
            ApPayMage entity = apPayMageMapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isNotEmpty(entity)) {
                BeanUtils.copyProperties(po, entity);
                entity.preUpdate();
                apPayMageMapper.updateByPrimaryKeySelective(entity);
            } else {
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
            }
        } else {
            //新增
            ApPayMage entity = new ApPayMage();
            BeanUtils.copyProperties(po, entity);
            entity.preInsert();
            apPayMageMapper.insert(entity);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息ApPayMage
     */
    public ResultPoJo<ApPayMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<ApPayMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        ApPayMageInfoVo vo = apPayMageMapper.findInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }
}
