package com.wisea.transac.operation.customer.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wisea.cloud.common.events.listener.SpringEventListener;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.tencentim.event.TIMUserLoginEventInfo;
import com.wisea.transac.operation.customer.service.SysImCustomerStatusService;

/**
 * 客服上线消费者
 *
 * @author XuDL(Wisea)
 *
 *         2020年5月19日 下午5:03:18
 */
@Component
public class TIMUserLoginEventConsumer extends SpringEventListener<TIMUserLoginEventInfo> {

    @Autowired
    private SysImCustomerStatusService sysImCustomerStatusService;

    @Override
    public void run(TIMUserLoginEventInfo info) {
        LoggerUtil.debug("Receive LoginEvent with JID = {0}", info.getLoginUserId());
        sysImCustomerStatusService.online(info);
    }

}
