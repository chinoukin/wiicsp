package com.wisea.transac.operation.evnt.user;

import org.springframework.stereotype.Component;

import com.wisea.cloud.common.events.listener.SpringEventListener;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.rabbit.events.info.UserLogoutEventInfo;
import com.wisea.transac.common.utils.MembUtils;

/**
 * 退出登录的时候清空refresh缓存
 *
 * @author wangh(wisea)
 *
 * @date 2020年8月11日
 * @version 1.0
 */
@Component
public class SelLocalUserLogoutEvent extends SpringEventListener<UserLogoutEventInfo>{


    @Override
    public void run(UserLogoutEventInfo info) {
    	LoggerUtil.debug("Receive UserLogoutEventInfo with JID = {0}", info.getLogoutDate());
    	Long id = info.getUser().getId();
    	MembUtils.RemoveMobileLoginRefresh(ConverterUtil.toString(id));
    }
}
