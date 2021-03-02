package com.wisea.cultivar.supply.enums;

import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.constants.QdcyStandardsDict;
import com.wisea.cultivar.constants.QdcyStandardsError;

import java.util.Objects;

/**
 * 服务单状态
 * @author chengq
 * @date 2020/8/16 19:12
 */
public enum PubCommCheckEnum {

    IS_CHECK(QdcyStandardsDict.ENTP_COMM_PUB_EXAM_TYPE_0, QdcyStandardsDict.COMM_STATE_TYPE_2),
    UN_CHECK(QdcyStandardsDict.ENTP_COMM_PUB_EXAM_TYPE_1, QdcyStandardsDict.COMM_STATE_TYPE_0);

    PubCommCheckEnum(String checkState, String pubState) {
        this.checkState = checkState;
        this.pubState = pubState;
    }

    /**
     * 是否需要审核
     */
    private final String checkState;

    /**
     * 商品状态
     */
    private final String pubState;

    public String getCheckState() {
        return checkState;
    }

    public String getPubState() {
        return pubState;
    }

    public static PubCommCheckEnum findByCheckState(String checkState) {
        if (ConverterUtil.isEmpty(checkState)) {
            return UN_CHECK;
        }
        for (PubCommCheckEnum stateEnum : values()) {
            if (Objects.equals(stateEnum.getCheckState(), checkState)) {
                return stateEnum;
            }
        }
        throw new VerifyException(QdcyStandardsError.ERR_10013, QdcyStandardsError.MSG_10013);
    }
}
