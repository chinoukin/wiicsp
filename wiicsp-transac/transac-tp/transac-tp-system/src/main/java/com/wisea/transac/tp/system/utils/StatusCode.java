package com.wisea.transac.tp.system.utils;

import com.wisea.cloud.common.exception.ErrorStatus;

/**
 * @author wangjh
 */
public enum StatusCode implements ErrorStatus {

    /**
     * 成功
     */
    SUCCESS("000", "请求成功"),
    /**
     * 重复设置
     */
    REPEAT_SET("898", "重复设置！"),
    /**
     * 后台没有发票信息或者发票不可用
     */
    INVALID_INVOINFO("899","后台发票信息不可用。"),
    /**
     * 失败
     */
    FAIL("900", "请求失败"),
    /**
     * 系统异常
     */
    SYS_ERROR("901", "系统出现异常！"),

    /**
     * 设置失败
     */
    SET_FAIL("902", "设置失败！"),
    /**
     * 请求数据异常
     */
    REQ_DATA_EXCEPTION("903", "请求数据异常！"),
    /**
     * 修改失败
     */
    UPDATE_FAIL("904", "修改失败！"),
    /**
     * 新增失败
     */
    ADD_FAIL("905", "新增失败！"),
    /**
     * 删除失败
     */
    DELETE_FAIL("906", "删除失败！"),

    /**
     * 无此数据
     */
    NO_DATA("907", "无此数据！"),
    /**
     * 操作失败
     */
    OPERATE_FAIL("908", "操作失败！"),

    /**
     * 不是同一商家
     */
    NOT_ONLY_ENPTID("909", "不是同一商家！"),

    /**
     * 不是同一状态
     */
    NOT_ONLY_TYPE("909", "不是同一状态！"),
    /**
     * 标题重复
     */
    TITLE_REPEAT("910", "标题重复！"),
    /**
     * 不是管理员
     */
    NOT_ADMIN("911", "不是管理员！");

    private final String code;

    private final String message;

    StatusCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
