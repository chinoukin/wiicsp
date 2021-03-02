package com.wisea.cultivar.operation.customer.event;

import com.wisea.cultivar.operation.service.TimTrtcHouseService;
import com.wisea.cultivar.operation.customer.service.SysImCustomerStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wisea.cloud.common.events.listener.SpringEventListener;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.tencentim.event.TIMUserLogoutEventInfo;


/**
 * 客服离线消费者
 *
 * @author XuDL(Wisea)
 *
 *         2020年5月19日 下午5:03:09
 */
@Component
public class TIMUserLogoutEventConsumer extends SpringEventListener<TIMUserLogoutEventInfo> {

    @Autowired
    private SysImCustomerStatusService sysImCustomerStatusService;

    @Autowired
    private TimTrtcHouseService timTrtcHouseService;

    @Override
    public void run(TIMUserLogoutEventInfo info) {
        LoggerUtil.debug("Receive LogoutEvent with JID = {0}", info.getLogoutUserID());
        // 客服离线
        sysImCustomerStatusService.offline(info);
        // 实时音视频退出房间
        timTrtcHouseService.offine(info);
    }

}
