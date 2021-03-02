package com.wisea.transac.common.mss;

import com.wisea.cloud.common.mss.RemoteSecurityMssConditional;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.po.tim.RemotePortraitSetPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TIM帐号远程接口
 *
 * @author XuDL(Wisea)
 *
 *         2020年5月6日 上午11:00:48
 */
@Conditional(RemoteSecurityMssConditional.class)
@FeignClient(contextId = "RemoteTIMAccountMss", name = "${wbfc.mss.security:RemoteTIMAccountMss}", url = "${wbfc.mssurl.security:}")
public interface RemoteTIMAccountMss {
    /**
     * 管理员修改TIM账户资料
     *
     * @param registerUser
     * @return
     */
    @RequestMapping(value = "/w/tencentIM/portraitSet", method = RequestMethod.POST)
    public ResultPoJo<Object> portraitSet(RemotePortraitSetPo po);

    /**
     * 用户修改TIM账户资料
     *
     * @param registerUser
     * @return
     */
    @RequestMapping(value = "/w/tencentIM/userPortraitSet", method = RequestMethod.POST)
    public ResultPoJo<Object> userPortraitSet(RemotePortraitSetPo po);
}
