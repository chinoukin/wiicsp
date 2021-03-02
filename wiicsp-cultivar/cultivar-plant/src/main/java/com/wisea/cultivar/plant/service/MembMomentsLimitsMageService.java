package com.wisea.cultivar.plant.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cultivar.common.utils.BeanCopyUtils;
import com.wisea.cultivar.plant.entity.MembMomentsLimitsMage;
import com.wisea.cultivar.plant.mapper.MembMomentsLimitsMageMapper;
import com.wisea.cultivar.plant.po.MembMomentsLimitsMagePageListPo;
import com.wisea.cultivar.plant.po.MembMomentsLimitsMagePo;
import com.wisea.cultivar.plant.vo.MembMomentsLimitsMageInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className MembMomentsLimitsMageService
 * @date 2020/08/06 18:28:39
 * @Description
 */
@Service
public class MembMomentsLimitsMageService extends BaseService {
    @Autowired
    private MembMomentsLimitsMageMapper mapper;

    /**
     * 设置圈子权限信息
     *
     * @param po
     * @return
     */
    public ResultPoJo update(MembMomentsLimitsMagePo po) {
        LoggerUtil.infoWithContext("【update】设置圈子权限信息：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);

        //修改
        MembMomentsLimitsMage membMomentsLimitsMage = new MembMomentsLimitsMage();
        membMomentsLimitsMage.setMembId(po.getMembId());
        membMomentsLimitsMage.setMembMomentsLimitsType(po.getMembMomentsLimitsType());
        membMomentsLimitsMage = mapper.findByConditions(membMomentsLimitsMage).get(0);
        if (ConverterUtil.isNotEmpty(membMomentsLimitsMage)) {
            BeanCopyUtils.copyPropertiesIgnoreNull(po, membMomentsLimitsMage);
            membMomentsLimitsMage.preUpdate();
            mapper.updateByPrimaryKeySelective(membMomentsLimitsMage);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 查询圈子权限
     *
     * @param po
     * @return
     */
    public ResultPoJo<List<MembMomentsLimitsMageInfoVo>> findMembMomentsLimits(MembMomentsLimitsMagePageListPo po) {
        LoggerUtil.infoWithContext("【findMembMomentsLimits】查询圈子权限：", po);
        ResultPoJo<List<MembMomentsLimitsMageInfoVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        List<MembMomentsLimitsMageInfoVo> vo = mapper.findMembMomentsLimits(po);
        resultPoJo.setResult(vo);
        return resultPoJo;
    }
}
