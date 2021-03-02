package com.wisea.cultivar.supply.enums;

import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cultivar.constants.QdcyStandardsDict;
import com.wisea.cultivar.constants.QdcyStandardsError;

import java.util.Objects;

/**
 * 服务单类型枚举
 * @author chengq
 * @date 2020/8/20 16:16
 */
public enum  StateTypeEnum {

    SER_TYPE_0(QdcyStandardsDict.SER_LIST_STATE_TYPE_0, "待确认服务单"),
    SER_TYPE_1(QdcyStandardsDict.SER_LIST_STATE_TYPE_1, "待服务服务单"),
    SER_TYPE_2(QdcyStandardsDict.SER_LIST_STATE_TYPE_2, "服务中服务单"),
    SER_TYPE_3(QdcyStandardsDict.SER_LIST_STATE_TYPE_3, "已取消服务单"),
    SER_TYPE_4(QdcyStandardsDict.SER_LIST_STATE_TYPE_4, "已完成服务单");

    StateTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * 状态类型
     */
    private final String type;

    /**
     * 名称
     */
    private final String name;

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static StateTypeEnum findByStateType(String type) {
        for (StateTypeEnum stateEnum : values()) {
            if (Objects.equals(stateEnum.getType(), type)) {
                return stateEnum;
            }
        }
        throw new VerifyException(QdcyStandardsError.ERR_10012, QdcyStandardsError.MSG_10012);
    }
}
