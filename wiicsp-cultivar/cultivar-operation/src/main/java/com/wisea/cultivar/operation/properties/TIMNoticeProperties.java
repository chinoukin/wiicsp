package com.wisea.cultivar.operation.properties;

import com.wisea.cultivar.common.constants.TIMNoticeConstants;
import com.wisea.cultivar.operation.entity.TIMNoticeUser;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * TIM通知用户配置
 *
 * @author XuDL(Wisea)
 *
 *         2020年5月6日 下午1:40:38
 */
@ConfigurationProperties(prefix = "tpb.tim.notice")
public class TIMNoticeProperties {
    private Map<String, TIMNoticeUser> users = new HashMap<String, TIMNoticeUser>() {
        private static final long serialVersionUID = 2891366924781361613L;

        {
            put(TIMNoticeConstants.TYPE_ORDER, new TIMNoticeUser("NoticeSender_ord", "订单助手", null));
            put(TIMNoticeConstants.TYPE_NOTICE, new TIMNoticeUser("NoticeSender_ntc", "通知消息", null));
            put(TIMNoticeConstants.TYPE_SYSTEM, new TIMNoticeUser("NoticeSender_sys", "系统消息", null));
            put(TIMNoticeConstants.TYPE_SER, new TIMNoticeUser("NoticeSender_ser", "服务单助手", null));
        }
    };

    public Map<String, TIMNoticeUser> getUsers() {
        return users;
    }

    public void setUsers(Map<String, TIMNoticeUser> users) {
        this.users = users;
    }

}
