package com.wisea.equipment.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.equipment.constants.ConstantCodeMsg;
import com.wisea.equipment.dao.EquInfoMapper;
import com.wisea.equipment.entity.EquInfo;
import com.wisea.equipment.po.EquInfoListPo;
import com.wisea.equipment.po.EquInfoPo;
import com.wisea.equipment.po.EquInfoRemotPo;
import com.wisea.equipment.vo.EquInfoListVo;
import com.wisea.equipment.vo.EquInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoService
 * @date 2020/7/7 9:51
 * @Description
 */
@Service
public class EquInfoService extends BaseService {
    @Autowired
    private EquInfoMapper mapper;

    /**
     * @author jirg
     * @date 2020/7/7 10:27
     * @Description 分页查询设备列表
     */
    public ResultPoJo<Page<EquInfoListVo>> findPageList(EquInfoListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询设备列表：", po);
        ResultPoJo<Page<EquInfoListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<EquInfoListVo> page = po.getPage();
        List<EquInfoListVo> list = mapper.findPageList(po);
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/7/7 10:39
     * @Description 保存或修改设备
     */
    public ResultPoJo<?> saveOrUpdate(EquInfoPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】保存或修改设备", null);
        ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //校验设备编号是否重复
        EquInfo equInfo = mapper.selectByEquNum(po);
        if(ConverterUtil.isNotEmpty(equInfo)){
            resultPoJo.setCode(ConstantCodeMsg.ERR_301);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_301);
            return resultPoJo;
        }
        if (ConverterUtil.isNotEmpty(po.getId())) {
            //修改
            equInfo = mapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isEmpty(equInfo)) {
                resultPoJo.setCode(ConstantCodeMsg.ERR_004);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
                return resultPoJo;
            }
            BeanUtils.copyProperties(po, equInfo);
            equInfo.preUpdate();
            mapper.updateByPrimaryKey(equInfo);
        } else {
            //新增
            equInfo = new EquInfo();
            BeanUtils.copyProperties(po, equInfo);
            equInfo.preInsert();
            mapper.insert(equInfo);
        }
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/7/7 10:52
     * @Description 查询设备详细信息
     */
    public ResultPoJo<EquInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询设备详细信息：", po);
        ResultPoJo<EquInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        EquInfoVo equInfo = mapper.findInfo(po);
        if(ConverterUtil.isNotEmpty(equInfo)){
            resultPoJo.setResult(equInfo);
        }else{
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/7/7 10:53
     * @Description 删除设备
     */
    public ResultPoJo<?> delEquInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【delEquEntp】删除设备厂商：", po);
        ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        EquInfo equInfo = mapper.selectByPrimaryKey(po.getId());
        if(ConverterUtil.isNotEmpty(equInfo)){
            equInfo.setDelFlag(EquInfo.DEL_FLAG_DELETE);
            equInfo.preUpdate();
            mapper.updateByPrimaryKey(equInfo);
        }else{
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/7/7 11:23
     * @Description 远程调用保存设备
     */
    public ResultPoJo<?> remotSaveEquInfo(EquInfoRemotPo po) {
        LoggerUtil.infoWithContext("【remotSaveEquInfo】远程调用保存设备", null);
        ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //校验设备编号是否重复
        EquInfoPo equInfoPo = new EquInfoPo();
        BeanUtils.copyProperties(po, equInfoPo);
        EquInfo equInfo = mapper.selectByEquNum(equInfoPo);
        if(ConverterUtil.isNotEmpty(equInfo)){
            //设备编号重复，不添加
            return resultPoJo;
        }
        equInfo = new EquInfo();
        BeanUtils.copyProperties(po, equInfo);
        equInfo.preInsert();
        mapper.insert(equInfo);
        return resultPoJo;
    }
}
