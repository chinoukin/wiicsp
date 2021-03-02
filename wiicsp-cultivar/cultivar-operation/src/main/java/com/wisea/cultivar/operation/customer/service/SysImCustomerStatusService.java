package com.wisea.cultivar.operation.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.security.utils.UserUtils;
import com.wisea.cloud.tencentim.event.TIMUserLoginEventInfo;
import com.wisea.cloud.tencentim.event.TIMUserLogoutEventInfo;

/**
 * 客服状态Service
 *
 * @author XuDL(Wisea)
 *
 * 2020年5月19日 下午5:03:35
 */
@Service
public class SysImCustomerStatusService {

    @Autowired
    private SysImCustomerService sysImCustomerService;

    /**
     * 上线
     *
     * @param event
     */
    @Async
    public void online(TIMUserLoginEventInfo event) {
        String userId = event.getLoginUserId();
        // 修正有时会莫名的发送admin上线的消息
        if (ConverterUtil.isNumeric(userId)) {
            User user = UserUtils.getById(ConverterUtil.toLong(userId));
            // 是客服才进行状态修改
            if (null != user && sysImCustomerService.isCustomer(user.getId())) {
                sysImCustomerService.setStatus(user.getId(), SysImCustomerConfigService.ONLINE);
                LoggerUtil.debug("set user = {1} is online", user.getId());
            }
        }
    }

    /**
     * 离线
     *
     * @param event
     */
    @Async
    public void offline(TIMUserLogoutEventInfo event) {
        String userId = event.getLogoutUserID();
        if (ConverterUtil.isNumeric(userId)) {
            User user = UserUtils.getById(ConverterUtil.toLong(userId));
            // 是客服才进行状态修改
            if (null != user && sysImCustomerService.isCustomer(user.getId())) {
                sysImCustomerService.setStatus(user.getId(), SysImCustomerConfigService.OFFLINE);
                LoggerUtil.debug("set  user = {1} is offline", user.getId());
            }
        }
    }
}
