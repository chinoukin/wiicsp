package com.wisea.equipment.constants;

import com.wisea.equipment.service.jxiotcity.PushMessageService;
import com.wisea.equipment.service.jxiotcity.SelectRelayServiceImpl;
import com.wisea.equipment.service.jxiotcity.UpdateRelayServiceImpl;
import com.wisea.equipment.service.jxiotcity.UploadIntervalServiceImpl;

import java.util.Objects;

/**
 * 消息回复策略枚举
 * @author chengq
 * @date 2020/11/26 10:41
 */
public enum JxiotcityPushMessageEnum {

    UPLOAD_INTERVAL("0001", UploadIntervalServiceImpl.class),//上传间隔
    EQU_STATE("0011", SelectRelayServiceImpl.class),//继电器地址、继电器数量
    IP_UPDATE("0012", UpdateRelayServiceImpl.class);//继电器地址、数值


    /**
     * 消息命令
     */
    private final String code;

    /**
     * 消息推送实现类
     */
    private final Class<? extends PushMessageService> pushMessageService;

    JxiotcityPushMessageEnum(String code, Class<? extends PushMessageService> pushMessageService) {
        this.code = code;
        this.pushMessageService = pushMessageService;
    }

    /**
     * 获取真实执行的service
     * @param code 消息命令
     */
    public static Class<? extends PushMessageService> getService(String code) {
        for (JxiotcityPushMessageEnum pushMessageEnum : values()) {
            if (Objects.equals(pushMessageEnum.code, code)) {
                return pushMessageEnum.pushMessageService;
            }
        }
        return null;
    }
}
