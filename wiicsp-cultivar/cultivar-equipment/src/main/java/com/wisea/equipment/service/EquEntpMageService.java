package com.wisea.equipment.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.equipment.constants.ConstantCodeMsg;
import com.wisea.equipment.dao.EquEntpMageMapper;
import com.wisea.equipment.entity.EquEntpMage;
import com.wisea.equipment.po.EquEntpListPo;
import com.wisea.equipment.po.EquEntpPo;
import com.wisea.equipment.vo.EquEntpListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className EquEntpMageService
 * @date 2020/7/6 14:51
 * @Description 设备厂商管理Sewrvice
 */
@Service
public class EquEntpMageService extends BaseService {
    @Autowired
    private EquEntpMageMapper mapper;

    /**
     * @author jirg
     * @date 2020/7/6 15:02
     * @Description 分页查询设备厂商列表
     */
    public ResultPoJo<Page<EquEntpListVo>> findPageList(EquEntpListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询设备厂商列表：", po);
        ResultPoJo<Page<EquEntpListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<EquEntpListVo> page = po.getPage();
        List<EquEntpListVo> list = mapper.findPageList(po);
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/7/6 15:02
     * @Description 查询所有设备厂商列表
     */
    public ResultPoJo<List<EquEntpListVo>> findList(EquEntpListPo po) {
        LoggerUtil.infoWithContext("【findList】查询所有设备厂商列表：", po);
        ResultPoJo<List<EquEntpListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        po.setPage(null);
        List<EquEntpListVo> list = mapper.findPageList(po);
        resultPoJo.setResult(list);
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/7/6 15:44
     * @Description 保存或修改设备厂商
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> saveOrUpdate(EquEntpPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】保存或修改设备厂商", null);
        ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //校验设备厂商名称是否重复
        EquEntpMage equEntpMage = mapper.selectByEquEntpName(po);
        if(ConverterUtil.isNotEmpty(equEntpMage)){
            resultPoJo.setCode(ConstantCodeMsg.ERR_300);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_300);
            return resultPoJo;
        }
        if (ConverterUtil.isNotEmpty(po.getId())) {
            //修改
            equEntpMage = mapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isEmpty(equEntpMage)) {
                resultPoJo.setCode(ConstantCodeMsg.ERR_004);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
                return resultPoJo;
            }
            BeanUtils.copyProperties(po, equEntpMage);
            equEntpMage.preUpdate();
            mapper.updateByPrimaryKey(equEntpMage);
        } else {
            //新增
            equEntpMage = new EquEntpMage();
            BeanUtils.copyProperties(po, equEntpMage);
            equEntpMage.preInsert();
            mapper.insert(equEntpMage);
        }
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/7/6 15:55
     * @Description 查询设备厂商详细信息
     */
    public ResultPoJo<EquEntpMage> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询设备厂商详细信息：", po);
        ResultPoJo<EquEntpMage> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        EquEntpMage equEntpMage = mapper.selectByPrimaryKey(po.getId());
        if(ConverterUtil.isNotEmpty(equEntpMage)){
            resultPoJo.setResult(equEntpMage);
        }else{
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/7/6 15:58
     * @Description 删除设备厂商
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> delEquEntp(LongIdPo po) {
        LoggerUtil.infoWithContext("【delEquEntp】删除设备厂商：", po);
        ResultPoJo<EquEntpMage> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        EquEntpMage equEntpMage = mapper.selectByPrimaryKey(po.getId());
        if(ConverterUtil.isNotEmpty(equEntpMage)){
            equEntpMage.setDelFlag(EquEntpMage.DEL_FLAG_DELETE);
            equEntpMage.preUpdate();
            mapper.updateByPrimaryKey(equEntpMage);
        }else{
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }
}
