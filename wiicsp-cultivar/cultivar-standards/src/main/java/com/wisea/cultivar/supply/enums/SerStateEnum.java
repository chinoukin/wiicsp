package com.wisea.cultivar.supply.enums;

import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cultivar.constants.QdcyStandardsDict;
import com.wisea.cultivar.constants.QdcyStandardsError;

import java.util.Objects;

/**
 * 服务单状态
 * @author chengq
 * @date 2020/8/16 19:12
 */
public enum SerStateEnum {

    TYPE_1(QdcyStandardsDict.SER_LIST_STATE_TYPE_1, "商家已确认"),
    TYPE_2(QdcyStandardsDict.SER_LIST_STATE_TYPE_2, "商家服务中"),
    TYPE_3(QdcyStandardsDict.SER_LIST_STATE_TYPE_3, "商家取消，取消原因为：");

    SerStateEnum(String type, String name) {
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
    private String name;

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static SerStateEnum findByState(String type) {
        for (SerStateEnum stateEnum : values()) {
            if (Objects.equals(stateEnum.getType(), type)) {
                return stateEnum;
            }
        }
        throw new VerifyException(QdcyStandardsError.ERR_10011, QdcyStandardsError.MSG_10011);
    }
}
