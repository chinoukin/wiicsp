package com.wisea.equipment.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.equipment.constants.ConstantCodeMsg;
import com.wisea.equipment.dao.EquModelMageMapper;
import com.wisea.equipment.entity.EquModelMage;
import com.wisea.equipment.po.EquModelListPo;
import com.wisea.equipment.po.EquModelPageListPo;
import com.wisea.equipment.po.EquModelPo;
import com.wisea.equipment.vo.EquModelListVo;
import com.wisea.equipment.vo.EquModelPageListVo;
import com.wisea.equipment.vo.EquModelVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className EquModelMageService
 * @date 2020/7/6 16:15
 * @Description
 */
@Service
public class EquModelMageService extends BaseService {
    @Autowired
    private EquModelMageMapper mapper;

    /**
     * @author jirg
     * @date 2020/7/6 16:29
     * @Description 分页查询设备型号列表
     */
    public ResultPoJo<Page<EquModelPageListVo>> findPageList(EquModelPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询设备型号列表：", po);
        ResultPoJo<Page<EquModelPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<EquModelPageListVo> page = po.getPage();
        List<EquModelPageListVo> list = mapper.findPageList(po);
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/7/6 16:29
     * @Description 根据厂商查询设备型号列表
     */
    public ResultPoJo<List<EquModelListVo>> findList(EquModelListPo po) {
        LoggerUtil.infoWithContext("【findList】根据厂商查询设备型号列表：", po);
        ResultPoJo<List<EquModelListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        List<EquModelListVo> list = mapper.findListByEntpId(po);
        resultPoJo.setResult(list);
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/7/6 16:40
     * @Description
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> saveOrUpdate(EquModelPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】保存或修改设备厂商", null);
        ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //校验设备型号名称是否重复
        EquModelMage equModelMage = mapper.selectByEquModelName(po);
        if(ConverterUtil.isNotEmpty(equModelMage)){
            resultPoJo.setCode(ConstantCodeMsg.ERR_300);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_300);
            return resultPoJo;
        }
        if (ConverterUtil.isNotEmpty(po.getId())) {
            //修改
            equModelMage = mapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isEmpty(equModelMage)) {
                resultPoJo.setCode(ConstantCodeMsg.ERR_004);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
                return resultPoJo;
            }
            BeanUtils.copyProperties(po, equModelMage);
            equModelMage.preUpdate();
            mapper.updateByPrimaryKey(equModelMage);
        } else {
            //新增
            equModelMage = new EquModelMage();
            BeanUtils.copyProperties(po, equModelMage);
            equModelMage.preInsert();
            mapper.insert(equModelMage);
        }
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/7/6 16:44
     * @Description 查询设备型号详细信息
     */
    public ResultPoJo<EquModelVo> findEquModelInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询设备厂商详细信息：", po);
        ResultPoJo<EquModelVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        EquModelVo vo = mapper.findEquModelInfo(po.getId());
        if(ConverterUtil.isNotEmpty(vo)){
            resultPoJo.setResult(vo);
        }else{
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/7/6 16:45
     * @Description 删除设备型号
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> delEquModel(LongIdPo po) {
        LoggerUtil.infoWithContext("【delEquModel】删除设备型号：", po);
        ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        EquModelMage equModelMage = mapper.selectByPrimaryKey(po.getId());
        if(ConverterUtil.isNotEmpty(equModelMage)){
            equModelMage.setDelFlag(EquModelMage.DEL_FLAG_DELETE);
            equModelMage.preUpdate();
            mapper.updateByPrimaryKey(equModelMage);
        }else{
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }
}
