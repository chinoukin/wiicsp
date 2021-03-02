package com.wisea.transac.operation.evnt.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wisea.cloud.common.events.listener.SpringEventListener;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.rabbit.events.info.UserLoginEventInfo;
import com.wisea.transac.operation.service.user.UserLoginExtendsService;

/**
 *
 *
 * @author wangh(wisea)
 *
 * @date 2020年8月11日
 * @version 1.0
 */
@Component
public class SelUserLoginEventInfo  extends SpringEventListener<UserLoginEventInfo>{

	@Autowired
	private UserLoginExtendsService userLoginExtendsService;

	@Override
    public void run(UserLoginEventInfo info) {
		LoggerUtil.debug("Receive UserLoginEventInfo with JID = {0}", info.getLoginDate());
		userLoginExtendsService.loginInitRefreshToken(info);

    }
}
