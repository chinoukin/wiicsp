package com.wisea.cultivar.supply.enums;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cultivar.constants.QdcyStandardsDict;

import java.util.Objects;

/**
 * 认证类型状态表
 * @author chengq
 * @date 2020/8/16 19:12
 */
public enum AuthTableEnum {

    ENTP_AUTH(QdcyStandardsDict.AUTH_TYPE_0, "entp_auth"),
    REAL_PERSON_AUTH(QdcyStandardsDict.AUTH_TYPE_1, "real_person_auth");

    AuthTableEnum(String type, String table) {
        this.type = type;
        this.table = table;
    }

    /**
     * 认证类型
     */
    private final String type;

    /**
     * 名称
     */
    private final String table;

    public String getType() {
        return type;
    }

    public String getTable() {
        return table;
    }

    public static AuthTableEnum findByType(String type) {
        for (AuthTableEnum stateEnum : values()) {
            if (Objects.equals(stateEnum.getType(), type)) {
                return stateEnum;
            }
        }
        throw new VerifyException(ConstantError.ERR_004, ConstantError.MSG_004);
    }
}
