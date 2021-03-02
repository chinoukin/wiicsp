package com.wisea.cultivar.plant.service.oritrapla;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.entity.oritrapla.EquInfoMage;
import com.wisea.cultivar.plant.entity.oritrapla.MassifEquRela;
import com.wisea.cultivar.plant.mapper.oritrapla.EquInfoMageMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.MassifEquRelaMapper;
import com.wisea.cultivar.plant.mss.EquipmentMss;
import com.wisea.cultivar.plant.po.oritrapla.*;
import com.wisea.cultivar.plant.vo.oritrapla.ArchBasicInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.EquInfoMageMonitorVo;
import com.wisea.cultivar.plant.vo.oritrapla.EquInfoMageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoMageService
 * @date 2019/2/25 9:46
 * @Description 设备信息管理Service
 */
@Service
public class EquInfoMageService extends BaseService {
    @Autowired
    private EquInfoMageMapper mapper;
    @Autowired
    private MassifEquRelaMapper equRelaMapper;
    @Autowired
    private EquipmentMss equipmentMss;

    /**
     * @Author jirg
     * @Date 2019/2/25 9:53
     * @Description 分页查询设备信息列表
     **/
    public ResultPoJo<Page<EquInfoMageVo>> findPageList(EquInfoMagePo po) {
        ResultPoJo<Page<EquInfoMageVo>> result = new ResultPoJo<Page<EquInfoMageVo>>(ConstantCodeMsg.NOMAL);
        User user = SystemUtils.getUser();
        //判断是会员还是管理员
        if (!SystemUtils.hasAuthor("bs:amb") && !SystemUtils.hasAuthor("bs:mot")) {
            LoggerUtil.infoWithContext("【findPageList】会员查询该用户列表下所有设备列表：", user);
            po.setUserId(user.getId()); //普通用户只查询当前用户添加的设备列表
        }
        Page<EquInfoMageVo> page = po.getPage();
        List<EquInfoMageVo> list = mapper.findPageList(po);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    public ResultPoJo<Page<EquInfoMageVo>> findPage(EquInfoMagePo po) {
        ResultPoJo<Page<EquInfoMageVo>> result = new ResultPoJo<Page<EquInfoMageVo>>(ConstantCodeMsg.NOMAL);

        Page<EquInfoMageVo> page = po.getPage();
        List<EquInfoMageVo> list = mapper.findPageList(po);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * @Author jirg
     * @Date 2019/2/25 10:39
     * @Description 保存或修改设备信息
     **/
    @Transactional(readOnly = false)
    public ResultPoJo<?> saveOrUpdate(EquInfoMageSavePo po) {
        ResultPoJo<?> result = new ResultPoJo(ConstantCodeMsg.NOMAL);
        EquInfoMage EquInfoMage = new EquInfoMage();
        BeanUtils.copyProperties(po, EquInfoMage);

        if (ConverterUtil.isNotEmpty(EquInfoMage.getSplyUrl())) {
            EquInfoMage.setBfUrl(EquInfoMage.getSplyUrl());
        }

        if (ConverterUtil.isEmpty(po.getId())) {
            EquInfoMage.preInsert();
            mapper.insert(EquInfoMage);
        } else {
            //修改操作
            EquInfoMage.preUpdate();
            mapper.updateByPrimaryKeySelective(EquInfoMage);
            //根据设备id删除【地块-设备】关联表
            equRelaMapper.deleteByEquId(po.getId());
        }
        //保存地块设备关联表
        MassifEquRela equRela = new MassifEquRela();
        equRela.setEquId(EquInfoMage.getId());
        equRela.setMassifId(po.getMassifId());
        equRela.preInsert();
        equRelaMapper.insert(equRela);

        //判断是否是监控设备
        if(po.getEquType().equals("0")){
            //调用远程设备服务，添加设备
            EquInfoRemotPo remotPo = new EquInfoRemotPo();
            remotPo.setEquName(po.getEquName());
            remotPo.setEquNum(po.getEquNum());
            remotPo.setEquEntpId(po.getEquEntpId());
            remotPo.setEquModelId(po.getEquModelId());
            ResultPoJo<?> remotResult = equipmentMss.remotSaveEquInfo(remotPo);
        }
        return result;
    }

    /**
     * @Author jirg
     * @Date 2019/2/25 18:20
     * @Description 分页查询设备监控列表
     **/
    public ResultPoJo<Page<EquInfoMageMonitorVo>> findPageEquInfoMageMonitor(EquInfoMageMonitorPo po) {
        ResultPoJo<Page<EquInfoMageMonitorVo>> result = new ResultPoJo<Page<EquInfoMageMonitorVo>>(ConstantCodeMsg.NOMAL);
        User user = SystemUtils.getUser();
        if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
            result.setCode(ConstantCodeMsg.ERR_702);
            LoggerUtil.infoWithContext("【findPageEquInfoMageMonitor】user：", user, user.getId());
            result.setMsg(ConstantCodeMsg.MSG_702);
            LoggerUtil.infoWithContext("【findPageEquInfoMageMonitor】操作异常：", ConstantCodeMsg.MSG_702);
            return result;
        }
        //判断是会员还是管理员
        if (!SystemUtils.hasAuthor("ROLE_admin")) {
            LoggerUtil.infoWithContext("【findPageList】会员查询该用户列表下所有追溯码申请列表：", user);
            po.setUserId(user.getId()); //普通用户只查询当前用户添加的设备列表
        }
        Page<EquInfoMageMonitorVo> page = po.getPage();
        List<EquInfoMageMonitorVo> list = mapper.findPageEquInfoMageMonitor(po);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * @Author jirg
     * @Date 2019/2/27 9:43
     * @Description 删除设备信息
     **/
    @Transactional(readOnly = false)
    public ResultPoJo<?> del(LongIdPo po) {
        ResultPoJo<?> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        User user = SystemUtils.getUser();
        if (ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())) {
            result.setCode(ConstantCodeMsg.ERR_702);
            LoggerUtil.infoWithContext("【del】user：", user, user.getId());
            result.setMsg(ConstantCodeMsg.MSG_702);
            LoggerUtil.infoWithContext("【del】操作异常：", ConstantCodeMsg.MSG_702);
            return result;
        }

        EquInfoMage EquInfoMage = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(EquInfoMage)) {
            if (!SystemUtils.hasAuthor("ROLE_admin")) {
                //非管理员只能删除自己添加的设备
                if (EquInfoMage.getCreateBy().equals(user.getId().toString())) {
                    EquInfoMage.setDelFlag("1");
                }
            } else if (SystemUtils.hasAuthor("ROLE_admin")) {
                //管理员能删除所有的设备
                EquInfoMage.setDelFlag("1");
            } else {
                result.setCode(ConstantCodeMsg.ERR_702);
                result.setMsg(ConstantCodeMsg.MSG_702);
                LoggerUtil.infoWithContext("【del】操作异常2：", ConstantCodeMsg.MSG_702);
                return result;
            }
            EquInfoMage.preUpdate();
            mapper.updateByPrimaryKeySelective(EquInfoMage);
        } else {
            result.setCode(ConstantCodeMsg.ERR_004);
            result.setMsg(ConstantCodeMsg.MSG_004);
        }
        return result;
    }

    /**
     * 按设备ID查询未过期的档案
     *
     * @param equId
     * @return
     */
    public ResultPoJo<List<ArchBasicInfoVo>> findAllArchBasicInfoByEquId(Long equId) {
        List<ArchBasicInfoVo> list = mapper.findArchByEquId(equId);
        ResultPoJo<List<ArchBasicInfoVo>> poJo = new ResultPoJo<>();
        poJo.setResult(list);
        return poJo;
    }
}
