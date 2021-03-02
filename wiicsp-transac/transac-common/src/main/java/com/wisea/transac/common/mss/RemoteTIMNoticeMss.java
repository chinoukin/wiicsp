package com.wisea.transac.common.mss;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wisea.cloud.common.mss.RemoteSecurityMssConditional;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.po.TIMNoticeSendPo;

/**
 * TIM通知远程接口
 *
 * @author XuDL(Wisea)
 *
 *         2020年5月6日 上午11:00:48
 */
@Conditional(RemoteSecurityMssConditional.class)
@FeignClient(contextId = "RemoteTIMNoticeMss", name = "${wbfc.mss.security:RemoteTIMNoticeMss}", url = "${wbfc.mssurl.security:}", configuration = FeignJobRemotConfiguration.class)
public interface RemoteTIMNoticeMss {
    /**
     * 发送TIM通知
     *
     * @param registerUser
     * @return
     */
    @RequestMapping(value = "/w/tim/noticeManager/sendTIMNotice", method = RequestMethod.POST)
    public ResultPoJo<Object> sendTIMNotice(TIMNoticeSendPo po);
}
