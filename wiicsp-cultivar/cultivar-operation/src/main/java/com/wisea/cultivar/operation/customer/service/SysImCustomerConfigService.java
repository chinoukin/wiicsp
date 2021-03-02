package com.wisea.cultivar.operation.customer.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.wisea.cultivar.operation.customer.dao.SysImCustomerConfigMapper;
import com.wisea.cultivar.operation.customer.dao.SysImCustomerMapper;
import com.wisea.cultivar.operation.customer.entity.SysImCustomer;
import com.wisea.cultivar.operation.customer.entity.SysImCustomerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.common.po.customer.CustomerConfigUserInsertPo;
import com.wisea.cultivar.common.po.customer.SysImCustomerConfigGetVo;
import com.wisea.cultivar.common.po.customer.SysImCustomerConfigInsertPo;
import com.wisea.cultivar.common.po.customer.SysImCustomerConfigUpdatePo;
import com.wisea.cultivar.common.po.customer.SysImCustomerListDeletePo;
import com.wisea.cultivar.common.po.customer.SysImCustomerListInsertPo;
import com.wisea.cultivar.common.po.customer.SysImCustomerListUpdatePo;

/**
 * SysImCustomerConfigService 客服管理配置表 Service 2018/09/29 13:46:47
 */
@Service
public class SysImCustomerConfigService extends BaseService {
    /** 0:离线 */
    public final static String OFFLINE = "0";
    /** 1:在线 */
    public final static String ONLINE = "1";
    /** 0:轮询 */
    public final static String CUSTOM_TYPE_LOOP = "0";
    /** 1:指定 */
    public final static String CUSTOM_TYPE_SPECIF = "1";

    @Autowired
    protected SysImCustomerMapper sysImCustomerMapper;
    @Autowired
    protected SysImCustomerConfigMapper sysImCustomerConfigMapper;

    /* 系统客服分组ID */
    public static final String IM_CUSTOMER_SYSTEM_GROUP_ID = "1";

    /**
     * 用GroupId查询配置
     */
    public SysImCustomerConfigGetVo get(String groupId) {
        SysImCustomerConfigGetVo vo = sysImCustomerConfigMapper.selectByGroupId(groupId);
        return vo;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(SysImCustomerConfigInsertPo sysImCustomerConfigInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        String groupId = sysImCustomerConfigInsertPo.getGroupId();

        SysImCustomerConfigGetVo vo = sysImCustomerConfigMapper.selectByGroupId(groupId);
        // 一个账户只能有一个客服配置 所以如果存在就报错 不存在才新增
        if (ConverterUtil.isNotEmpty(vo)) {
            result.setCode(ConstantError.ERR_914);
            result.setMsg(ConstantError.MSG_914);
            return result;
        } else {
            SysImCustomerConfig sysImCustomerConfig = new SysImCustomerConfig();
            ConverterUtil.copyProperties(sysImCustomerConfigInsertPo, sysImCustomerConfig);
            sysImCustomerConfig.setGroupId(groupId);
            sysImCustomerConfig.preInsert();
            sysImCustomerConfigMapper.insert(sysImCustomerConfig);
        }
        // 删除组下全部客服 避免数据不正确 保证新增的客服配置和客服列表能能统一对应
        sysImCustomerMapper.deleteGroupAll(groupId);
        insertCustomerList(groupId, sysImCustomerConfigInsertPo.getUserList());
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(SysImCustomerConfigUpdatePo sysImCustomerConfigUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        SysImCustomerConfig config = sysImCustomerConfigMapper.selectByPrimaryKey(sysImCustomerConfigUpdatePo.getId());
        if (null == config) {
            result.setCode(ConstantError.ERR_915);
            result.setMsg(ConstantError.MSG_915);
            return result;
        }
        // 先保存配置信息
        SysImCustomerConfig sysImCustomerConfig = new SysImCustomerConfig();
        ConverterUtil.copyProperties(sysImCustomerConfigUpdatePo, sysImCustomerConfig);
        sysImCustomerConfig.preUpdate();
        sysImCustomerConfigMapper.updateByPrimaryKeySelective(sysImCustomerConfig);
        return result;
    }

    /**
     * 客服列表新增
     *
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> customerListInsert(SysImCustomerListInsertPo po) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        // 再保存客服列表
        String groupId = po.getGroupId();
        // 判断客服配置是否存在
        SysImCustomerConfigGetVo config = sysImCustomerConfigMapper.selectByGroupId(groupId);
        if (null == config) {
            result.setCode(ConstantError.ERR_915);
            result.setMsg(ConstantError.MSG_915);
            return result;
        }
        // 查询现有的id列表并过滤 避免重复添加
        List<User> custList = sysImCustomerMapper.findCustomUserList(groupId);
        List<CustomerConfigUserInsertPo> insLit = po.getUserList();
        if (ConverterUtil.isNotEmpty(custList)) {
            Set<Long> exsIdSet = custList.stream().map(User::getId).collect(Collectors.toSet());
            insLit = insLit.stream().filter(i -> !exsIdSet.contains(i.getUserId())).collect(Collectors.toList());
        }
        // 新增客服列表
        if (ConverterUtil.isNotEmpty(insLit)) {
            insertCustomerList(groupId, insLit);
        }
        return result;
    }

    /**
     * 客服列表编辑
     *
     * @param po
     * @return
     */
    @Transactional
    public ResultPoJo<Object> customerListUpdate(SysImCustomerListUpdatePo po) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        // 再保存客服列表
        String groupId = po.getGroupId();
        // 判断客服配置是否存在
        SysImCustomerConfigGetVo config = sysImCustomerConfigMapper.selectByGroupId(groupId);
        if (null == config) {
            result.setCode(ConstantError.ERR_915);
            result.setMsg(ConstantError.MSG_915);
            return result;
        }
        // 编辑客服列表
        for (CustomerConfigUserInsertPo userPo : po.getUserList()) {
            SysImCustomer ct = sysImCustomerMapper.selectByGroupAndUser(groupId, userPo.getUserId());
            if (null != ct) {
                ct.setIsAdmin(userPo.isAdmin());
                ct.preUpdate();
                sysImCustomerMapper.updateByPrimaryKeySelective(ct);
            }
        }
        return result;
    }

    /**
     * 客服列表删除
     *
     * @param po
     * @return
     */
    @Transactional
    public ResultPoJo<Object> customerListDelete(SysImCustomerListDeletePo po) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        // 再保存客服列表
        String groupId = po.getGroupId();
        // 判断客服配置是否存在
        SysImCustomerConfigGetVo config = sysImCustomerConfigMapper.selectByGroupId(groupId);
        if (null == config) {
            result.setCode(ConstantError.ERR_915);
            result.setMsg(ConstantError.MSG_915);
            return result;
        }
        // 删除客服列表
        SysImCustomer entity = new SysImCustomer();
        entity.setGroupId(groupId);
        entity.preUpdate();
        for (Long userId : po.getUserList()) {
            entity.setUserId(userId);
            sysImCustomerMapper.deleteGroupWithUserId(entity);
        }
        return result;
    }

    /**
     * 新增客服列表
     *
     * @param groupId
     * @param userIds
     * @param isAdmin
     */
    private void insertCustomerList(String groupId, List<CustomerConfigUserInsertPo> userList) {
        for (CustomerConfigUserInsertPo userPo : userList) {
            Long userId = userPo.getUserId();
            SysImCustomer entity = new SysImCustomer();
            entity.setGroupId(groupId);
            entity.setUserId(userId);
            entity.setStatus(OFFLINE);
            if (ConverterUtil.toBoolean(userPo.isAdmin())) {
                entity.setIsAdmin(Constants.YES);
            } else {
                entity.setIsAdmin(Constants.NO);
            }
            entity.setSerCount(0);
            entity.preInsert();
            sysImCustomerMapper.insert(entity);
        }
    }

}
