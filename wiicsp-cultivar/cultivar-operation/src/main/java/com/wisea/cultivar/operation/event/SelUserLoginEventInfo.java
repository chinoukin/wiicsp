package com.wisea.cultivar.operation.event;

import com.wisea.cloud.common.events.listener.SpringEventListener;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.rabbit.events.info.UserLoginEventInfo;
import com.wisea.cultivar.operation.service.LoginExtendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 登录监听事件的处理
 *
 * @author wangh(wisea)
 *
 * @date 2020年8月11日
 * @version 1.0
 */
@Component
public class SelUserLoginEventInfo extends SpringEventListener<UserLoginEventInfo>{

	@Autowired
	private LoginExtendsService loginExtendsService;

	@Override
    public void run(UserLoginEventInfo info) {
		LoggerUtil.debug("Receive UserLoginEventInfo with JID = {0}", info.getLoginDate());
		loginExtendsService.loginInitRefreshToken(info);

    }
}
