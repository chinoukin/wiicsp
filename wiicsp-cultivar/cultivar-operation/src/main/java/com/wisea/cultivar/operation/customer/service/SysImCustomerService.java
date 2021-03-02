package com.wisea.cultivar.operation.customer.service;

import java.util.List;

import com.wisea.cultivar.operation.customer.dao.SysImCustomerMapper;
import com.wisea.cultivar.operation.customer.entity.SysImCustomer;
import com.wisea.cultivar.operation.customer.entity.SysImCustomerCnt;
import com.wisea.cultivar.operation.customer.po.SysImCustomerAddSerCountPo;
import com.wisea.cultivar.operation.customer.po.SysImCustomerDispatchPo;
import com.wisea.cultivar.operation.customer.po.SysImCustomerSubSerCountPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.security.utils.UserUtils;
import com.wisea.cultivar.common.po.customer.SysImCustomerConfigGetVo;

/**
 * SysImCustomerService 客服管理表 Service 2018/09/29 13:46:47
 */
@Service
public class SysImCustomerService extends BaseService {

    @Autowired
    protected SysImCustomerConfigService sysImCustomerConfigService;

    @Autowired
    protected SysImCustomerCntService sysImCustomerCntService;

    @Autowired
    protected SysImCustomerMapper sysImCustomerMapper;

    // /**
    // * 查询分页列表
    // */
    // public ResultPoJo<Page<SysImCustomerListVo>> findPage(SysImCustomerPagePo sysImCustomerPagePo) {
    // ResultPoJo<Page<SysImCustomerListVo>> result = new ResultPoJo<>();
    // User loginUser = SystemUtils.getUser();
    // // 获取groupId
    // String groupId = sysImCustomerConfigService.getGroupId(loginUser);
    // sysImCustomerPagePo.setGroupId(groupId);
    // Page<SysImCustomerListVo> page = sysImCustomerPagePo.getPage();
    // List<SysImCustomerListVo> list = sysImCustomerMapper.findPage(sysImCustomerPagePo);
    // page.setList(list);
    // result.setResult(page);
    // return result;
    // }

    /**
     * 判断一个用户是否为客服
     *
     * @param user
     * @return
     */
    public boolean isCustomer(Long userId) {
        List<SysImCustomer> entity = sysImCustomerMapper.selectByUser(userId);
        if (ConverterUtil.isNotEmpty(entity)) {
            return true;
        }
        return false;
    }

    /**
     * 增加当前服务人数
     *
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public void addSerCount(SysImCustomerAddSerCountPo po) {
        // 获取groupId
        String groupId = po.getGroupId();

        // 查询当前客服
        SysImCustomer customer = sysImCustomerMapper.selectByGroupAndUser(groupId, po.getCustomerId());
        if (ConverterUtil.isEmpty(customer)) {
            throw ConstantError.VER_915;
        }
        // 获取被接待用户
        User custUser = SystemUtils.getById(po.getUserId());
        // 用户不存在就报错
        if (ConverterUtil.isEmpty(custUser)) {
            if (ConverterUtil.isEmpty(customer)) {
                throw ConstantError.VER_907;
            }
        }
        // 获取配置
        SysImCustomerConfigGetVo config = sysImCustomerConfigService.get(groupId);

        // 获取最大接待数量
        int serCount = customer.getSerCount();
        int tempCount = serCount + 1;
        // 如果接待数量超过最大接待者则报错
        if (tempCount > config.getSerMaxCount()) {
            // 现在的业务允许超过最大接待数量 不报错了 要记录值
            // throw ConstantError.VER_916;
            logger.debug("customer id = {} is overflow ! MaxServerCount = {} ", customer.getId(), config.getSerMaxCount());
        }

        // 修改人数
        SysImCustomer uEntity = new SysImCustomer();
        uEntity.setId(customer.getId());
        // 增加服务人数
        uEntity.setSerCount(tempCount);
        uEntity.preUpdate();
        sysImCustomerMapper.updateByPrimaryKeySelective(uEntity);

        // 增加一个接待
        SysImCustomerCnt sysImCustomerCn = new SysImCustomerCnt();
        sysImCustomerCn.setGroupId(groupId);
        sysImCustomerCn.setCustomerId(po.getCustomerId());
        sysImCustomerCn.setUserId(po.getUserId());
        sysImCustomerCntService.insert(sysImCustomerCn);
    }

    /**
     * 减少当前服务人数
     *
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> subSerCount(SysImCustomerSubSerCountPo po) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        // 获取groupId
        String groupId = po.getGroupId();

        // 查询当前客服
        SysImCustomer customer = sysImCustomerMapper.selectByGroupAndUser(groupId, po.getCustomerId());
        if (ConverterUtil.isEmpty(customer)) {
            throw ConstantError.VER_915;
        }

        SysImCustomer uEntity = new SysImCustomer();
        uEntity.setId(customer.getId());
        // 减少服务人数
        int serCount = customer.getSerCount() - 1;
        // 不能小于0
        if (serCount < 0) {
            serCount = 0;
        }
        uEntity.setSerCount(serCount);
        uEntity.preUpdate();
        sysImCustomerMapper.updateByPrimaryKeySelective(uEntity);
        return result;
    }

    /**
     * 设置客服在线状态
     *
     * @param groupId
     * @param userId
     * @param status
     */
    @Transactional(readOnly = false)
    public void setStatus(Long userId, String status) {
        if (ConverterUtil.isNotEmpty(userId)) {
            if (ConverterUtil.isEmpty(status)) {
                status = SysImCustomerConfigService.OFFLINE;
            }
            // 查询userId对应的客服 避免同一个人配置了多个客服的情况
            List<SysImCustomer> customerList = sysImCustomerMapper.selectByUser(userId);
            if (ConverterUtil.isNotEmpty(customerList)) {
                for (SysImCustomer customer : customerList) {
                    SysImCustomer uEntity = new SysImCustomer();
                    uEntity.setId(customer.getId());
                    uEntity.setStatus(status);
                    if (SysImCustomerConfigService.OFFLINE.equals(status)) {
                        // 客服下线了需要设置接待数量为0,避免客服直接关闭浏览器后接待数量不减少
                        uEntity.setSerCount(0);
                    }
                    uEntity.preUpdate();
                    sysImCustomerMapper.updateByPrimaryKeySelective(uEntity);
                }
            }
        }
    }

    /**
     * 查询分发的客服配置
     * <p/>
     * 如果当前配置没有找到就向后继续查找 直到有配置值或循环结束
     *
     * @param groupIdList
     * @return
     */
    private SysImCustomerConfigGetVo getDispatchConfig(List<String> groupIdList) {
        int index = 0;
        SysImCustomerConfigGetVo config = sysImCustomerConfigService.get(groupIdList.get(0));
        // 如果当前配置没有找到就向后继续查找 直到有配置值或循环结束
        if (null == config) {
            int nextIndex = index + 1;
            if (nextIndex < groupIdList.size()) {
                config = getDispatchConfig(groupIdList.subList(nextIndex, groupIdList.size()));
            }
        }
        return config;
    }

    /**
     * 分配客服
     *
     * @return
     */
    public ResultPoJo<String> dispatch(SysImCustomerDispatchPo po) {
        ResultPoJo<String> result = new ResultPoJo<>();
        User logicUser = UserUtils.getUserOnlyId();
        List<String> groupIdList = po.getGroupIds();
        // 如果最后一个不是平台客服就添加到分配中，避免出现一个客服都没有的情况
        if (!groupIdList.get(groupIdList.size() - 1).equals("1")) {
            groupIdList.add("1");
        }
        for (int i = 0; i < groupIdList.size(); i++) {
            String groupId = groupIdList.get(i);
            // 获取配置 截断是为了第一次查询是自己group的 如果没有再后查找
            SysImCustomerConfigGetVo config = getDispatchConfig(groupIdList.subList(i, groupIdList.size()));
            // 最近联系人优先
            boolean retContact = false;
            if (null != config) {
                retContact = ConverterUtil.toBoolean(config.getRetContact());
                if (retContact) {
                    // 查询当前用户在对应的分组中是否有过接待记录(返回值为按接待时间倒序第一个)
                    SysImCustomerCnt customneCnt = sysImCustomerCntService.selectByGroupIdAndUserId(groupId, logicUser.getId());
                    if (null != customneCnt) {
                        // 如果有就查询对应的userID
                        SysImCustomer sysImCustomer = sysImCustomerMapper.selectByPrimaryKey(customneCnt.getCustomerId());
                        // 一般不是手动造数据的话 此处不会为null
                        if (null != sysImCustomer) {
                            // 如果之前是admin接待的 现在又配置了admin不参与就重新分配
                            if (!ConverterUtil.toBoolean(config.getDepNoAdmin()) && !ConverterUtil.toBoolean(sysImCustomer.getIsAdmin())) {
                                // 返回用户id
                                result.setResult(ConverterUtil.toString(sysImCustomer.getUserId()));
                                return result;
                            }
                        }
                    }
                }
                // 按客服接待数量轮询分配 包括不在线的和最大接待数量超过的 因为现在的业务规定必须返回一个客服，即使超过了最大接待数量，依然要弹出窗口
                SysImCustomer customer = autoDispatchCustomer(groupId, config.getDepNoAdmin());
                if (null != customer) {
                    result.setResult(ConverterUtil.toString(customer.getUserId()));
                    // 如果分配的客服在线 自动添加接待数量
                    if (ConverterUtil.toBoolean(customer.getStatus())) {
                        SysImCustomerAddSerCountPo addSerCountPo = new SysImCustomerAddSerCountPo();
                        addSerCountPo.setGroupId(groupId);
                        addSerCountPo.setCustomerId(customer.getId());
                        addSerCountPo.setUserId(logicUser.getId());
                        addSerCount(addSerCountPo);
                    }
                    return result;
                }
            }
        }

        // 如果查询客服不存在，可能是分组id不正确或配置有问题 如果此处，说明上面的分组中一个都没有客服设置 这样的数据是不正确的 至少应该配置一个平台客服
        result.setCode(ConstantError.ERR_915);
        result.setMsg(ConstantError.MSG_915 + "[配置项错误，至少应该配置一个平台客服，请将此情况反馈给相关人员]");
        return result;
    }

    /**
     * 自动分配客服
     * <p/>
     * 在线状态优先级大于离线 <br/>
     * 当前服务数量约小越优先<br/>
     * 更新时间越历史前越优先<br/>
     *
     * @param groupId
     *            分组id
     * @param depNoAdmin
     *            管理员不参与自动分配 0:否 1:是
     * @return
     */
    private SysImCustomer autoDispatchCustomer(String groupId, String depNoAdmin) {
        SysImCustomer query = new SysImCustomer();
        query.setGroupId(groupId);
        if (Constants.YES.equals(depNoAdmin)) {
            query.setIsAdmin(Constants.NO);
        }
        return sysImCustomerMapper.dispatch(query);
    }
}
