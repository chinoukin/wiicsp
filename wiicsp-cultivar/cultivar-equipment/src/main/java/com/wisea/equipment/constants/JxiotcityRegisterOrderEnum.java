package com.wisea.equipment.constants;

import com.wisea.equipment.service.jxiotcity.*;
import com.wisea.equipment.service.jxiotcity.PerformRespServiceImpl;
import com.wisea.equipment.service.jxiotcity.RegisterServiceImpl;
import com.wisea.equipment.service.jxiotcity.UploadDataServiceImpl;
import com.wisea.equipment.service.jxiotcity.UploadStateServiceImpl;

import java.util.Objects;

/**
 * 精讯命令枚举
 * 对应《精讯云2.0传输协议》
 * @author chengq
 * @date 2020/11/24 10:49
 */
public enum JxiotcityRegisterOrderEnum {
    REGISTER("1001", RegisterServiceImpl.class),//注册协议
    UPLOAD_STATE("1002", UploadStateServiceImpl.class),//上传状态协议
    UPLOAD_DATA("1003", UploadDataServiceImpl.class),//上传数据协议
    PERFORM_RESP("1004", PerformRespServiceImpl.class);//设备执行回复协议

    /**
     * 命令
     */
    private final String order;

    /**
     * 策略类
     */
    private final Class<? extends RegisterOrderService> registerOrderService;

    JxiotcityRegisterOrderEnum(String order, Class<? extends RegisterOrderService> registerOrderService) {
        this.order = order;
        this.registerOrderService = registerOrderService;
    }

    /**
     * 获取真实执行的service
     * @param order 协议号
     */
    public static Class<? extends RegisterOrderService> getService(String order) {
        for (JxiotcityRegisterOrderEnum registerOrder : values()) {
            if (Objects.equals(registerOrder.order, order)) {
                return registerOrder.registerOrderService;
            }
        }
        return null;
    }
}
