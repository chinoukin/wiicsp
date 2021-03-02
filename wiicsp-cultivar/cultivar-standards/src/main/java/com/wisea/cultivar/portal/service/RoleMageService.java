package com.wisea.cultivar.portal.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.IdGen;
import com.wisea.cloud.common.util.TreeUtils;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.constants.QdcyStandardsError;
import com.wisea.cultivar.portal.entity.RoleMage;
import com.wisea.cultivar.portal.mapper.RoleMageMapper;
import com.wisea.cultivar.portal.po.RoleMageBatDeletePo;
import com.wisea.cultivar.portal.po.RoleMageGetPo;
import com.wisea.cultivar.portal.po.RoleMageInsertPo;
import com.wisea.cultivar.portal.po.RoleMageListPo;
import com.wisea.cultivar.portal.po.RoleMagePagePo;
import com.wisea.cultivar.portal.po.RoleMageUpdatePo;
import com.wisea.cultivar.portal.vo.RoleMageGetVo;
import com.wisea.cultivar.portal.vo.RoleMageListVo;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.wisea.cultivar.portal.vo.ViewMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * RoleMageService
 * 角色管理 Service
 * 2020/08/24 20:28:13
 */
@Service
public class RoleMageService extends BaseService {
    @Autowired
    protected RoleMageMapper roleMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<RoleMageListVo>> findPage(RoleMagePagePo roleMagePagePo) {
        ResultPoJo<Page<RoleMageListVo>> result = new ResultPoJo<>();
        Page<RoleMageListVo> page = roleMagePagePo.getPage();
        List<RoleMageListVo> list = roleMageMapper.findPage(roleMagePagePo);
        List<RoleMageListVo> listRole=new ArrayList<>();
        for (RoleMageListVo roleMageListVo : list) {
            Long id = roleMageListVo.getSysRoleId();
            List <String> menuIds=roleMageMapper.selectByRoleId(id);
            roleMageListVo.setMenuIds(menuIds);
            Integer count=roleMageMapper.userCount(id);
            roleMageListVo.setUserCount(count);
            listRole.add(roleMageListVo);
        }
        page.setList(listRole);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<RoleMageListVo>> findList(RoleMageListPo roleMageListPo) {
        ResultPoJo<List<RoleMageListVo>> result = new ResultPoJo<>();
        result.setResult(roleMageMapper.findList(roleMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<RoleMageGetVo> get(RoleMageGetPo roleMageGetPo) {
        ResultPoJo<RoleMageGetVo> result = new ResultPoJo<>();
        RoleMage entity = roleMageMapper.selectByPrimaryKey(roleMageGetPo.getId());
        RoleMageGetVo vo = new RoleMageGetVo();
        ConverterUtil.copyProperties(entity, vo);

       List <String> menuIds=roleMageMapper.selectByRoleId(entity.getSysRoleId());
       vo.setMenuIds(menuIds);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(RoleMageInsertPo roleMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        String idvar=null;
       List<RoleMageListVo> listName=roleMageMapper.selectByName(roleMageInsertPo.getName(),idvar);
        List<RoleMageListVo> listCode=roleMageMapper.selectByCode(roleMageInsertPo.getCode(),idvar);
        if (listName.size()>0){
            result.setCode(QdcyStandardsError.ERR_30004);
            result.setMsg(QdcyStandardsError.MSG_30004);
            return result;
        }
        if (listCode.size()>0){
            result.setCode(QdcyStandardsError.ERR_30001);
            result.setMsg(QdcyStandardsError.MSG_30001);
            return result;
        }
        Long roleId = IdGen.randomLong();

        RoleMage roleMage = new RoleMage();
        ConverterUtil.copyProperties(roleMageInsertPo, roleMage);
        roleMage.setId(roleId);
        roleMage.setUpdateDate(OffsetDateTime.now());
        roleMage.setCreateDate(OffsetDateTime.now());
        roleMage.setRtype("1");  //用户角色
        Long sysRoleId = IdGen.randomLong();
        roleMage.setSid(sysRoleId);



        roleMage.preInsert();
        roleMage.setSysRoleId(sysRoleId);
        roleMageMapper.insert(roleMage);

        RoleMage entity = roleMageMapper.selectByPrimaryKey(roleMage.getId());
        entity.setId(sysRoleId);
        roleMageMapper.addSysRole(entity);

        Long id = roleMage.getSysRoleId();
        List<String> menuIds = roleMageInsertPo.getMenuIds();
        for (String menuId : menuIds) {
            roleMageMapper.addsysRoleMenu(id,menuId);
        }
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(RoleMageUpdatePo roleMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        String idvar=String.valueOf(roleMageUpdatePo.getSysRoleId());
        List<RoleMageListVo> listName=roleMageMapper.selectByName(roleMageUpdatePo.getName(),idvar);
        List<RoleMageListVo> listCode=roleMageMapper.selectByCode(roleMageUpdatePo.getCode(),idvar);
        if (listName.size()>0){
            result.setCode(QdcyStandardsError.ERR_30004);
            result.setMsg(QdcyStandardsError.MSG_30004);
            return result;
        }
        if (listCode.size()>0){
            result.setCode(QdcyStandardsError.ERR_30001);
            result.setMsg(QdcyStandardsError.MSG_30001);
            return result;
        }
        RoleMage roleMage = new RoleMage();
        ConverterUtil.copyProperties(roleMageUpdatePo, roleMage);
        roleMage.preUpdate();
        roleMageMapper.updateByPrimaryKeySelective(roleMage);
        RoleMage entity = roleMageMapper.selectByPrimaryKey(roleMage.getId());

        roleMage.setSysRoleIdvar(String.valueOf(roleMage.getSysRoleId()));
        roleMage.setUpdateBy(entity.getUpdateBy());
        roleMage.setUpdateDate(entity.getUpdateDate());
        roleMage.setRtype("1");
        roleMageMapper.updateSysRole(roleMage);
        roleMageMapper.deleteSysRoleMenu(roleMage.getSysRoleId());
        List<String> menuIds = roleMageUpdatePo.getMenuIds();
        for (String menuId : menuIds) {
            roleMageMapper.addsysRoleMenu(roleMage.getSysRoleId(),menuId);
        }
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(RoleMageBatDeletePo roleMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : roleMageBatDeletePo.getDelList()) {
            RoleMage entity = roleMageMapper.selectByPrimaryKey(delId);

            RoleMage roleMage = new RoleMage();
            roleMage.setId(delId);
            roleMage.preUpdate();
            roleMageMapper.deleteLogic(roleMage);

            roleMageMapper.deleteSysRole(String.valueOf(entity.getSysRoleId()));
            roleMageMapper.deleteSysRoleMenu(entity.getSysRoleId());
        }
        return result;
    }

    public ResultPoJo<Object> tree(Long sysUserId) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        List<ViewMenuVo> list = roleMageMapper.tree(sysUserId);
        list = TreeUtils.listToTree(list);
        result.setResult(list);
        return result;
    }
}
