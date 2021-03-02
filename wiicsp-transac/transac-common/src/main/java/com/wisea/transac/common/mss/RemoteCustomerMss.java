package com.wisea.transac.common.mss;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wisea.cloud.common.mss.RemoteSecurityMssConditional;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.po.customer.SysImCustomerConfigGetPo;
import com.wisea.transac.common.po.customer.SysImCustomerConfigGetVo;
import com.wisea.transac.common.po.customer.SysImCustomerConfigInsertPo;
import com.wisea.transac.common.po.customer.SysImCustomerConfigUpdatePo;
import com.wisea.transac.common.po.customer.SysImCustomerListDeletePo;
import com.wisea.transac.common.po.customer.SysImCustomerListInsertPo;
import com.wisea.transac.common.po.customer.SysImCustomerListUpdatePo;

/**
 * 客服相关远程接口
 *
 * @author XuDL(Wisea)
 *
 *         2020年5月6日 上午11:00:48
 */
@Conditional(RemoteSecurityMssConditional.class)
@FeignClient(contextId = "RemoteCustomerMss", name = "${wbfc.mss.security:RemoteCustomerMss}", url = "${wbfc.mssurl.security:}")
public interface RemoteCustomerMss {
    /**
     * 查询客服管理配置
     *
     * @param po
     * @return
     */
    @RequestMapping(value = "/w/im/customer/config/get", method = RequestMethod.POST)
    public ResultPoJo<SysImCustomerConfigGetVo> get(SysImCustomerConfigGetPo po);

    /**
     * 新增客服管理配置
     *
     * @param registerUser
     * @return
     */
    @RequestMapping(value = "/w/im/customer/config/insert", method = RequestMethod.POST)
    public ResultPoJo<Object> customerConfigInsert(SysImCustomerConfigInsertPo po);

    /**
     * 修改客服管理配置
     *
     * @param registerUser
     * @return
     */
    @RequestMapping(value = "/w/im/customer/config/update", method = RequestMethod.POST)
    public ResultPoJo<Object> customerConfigUpdate(SysImCustomerConfigUpdatePo po);

    /**
     * 增加客服列表
     *
     * @param registerUser
     * @return
     */
    @RequestMapping(value = "/w/im/customer/config/customerListInsert", method = RequestMethod.POST)
    public ResultPoJo<Object> customerListInsert(SysImCustomerListInsertPo po);

    /**
     * 修改客服列表
     *
     * @param registerUser
     * @return
     */
    @RequestMapping(value = "/w/im/customer/config/customerListUpdate", method = RequestMethod.POST)
    public ResultPoJo<Object> customerListUpdate(SysImCustomerListUpdatePo po);

    /**
     * 删除客服列表
     *
     * @param registerUser
     * @return
     */
    @RequestMapping(value = "/w/im/customer/config/customerListDelete", method = RequestMethod.POST)
    public ResultPoJo<Object> customerListDelete(SysImCustomerListDeletePo po);
}
