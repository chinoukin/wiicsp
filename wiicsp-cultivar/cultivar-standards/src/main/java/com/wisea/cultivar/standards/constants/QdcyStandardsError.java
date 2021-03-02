package com.wisea.cultivar.standards.constants;

/**
 * 产业标准管理系统错误码
 *
 */
public class QdcyStandardsError {
    /** 错误代码:80002 操作对象不存在 */
    public static final String ERR_80002 = "80002";
    /** 错误代码:80003 操作对象存在子级数据 */ public static final String ERR_80003 = "80003";
    /** 错误消息:80002 操作对象不存在 */ public static final String MSG_80002 = "操作对象不存在";
    /** 错误消息80003:操作对象存在子级数据 */public static final String MSG_80003="操作对象存在子级数据,请删除子级数据再操作";
    /** 错误代码:70002 导入失败，请检查必填项是否为空或导入数据格式是否正确！ */ public static final String ERR_70002 = "70002";
    /** 错误消息:70002 导入失败，请检查必填项是否为空或导入数据格式是否正确！ */ public static final String MSG_70002 = "导入失败，请检查必填项是否为空或导入数据格式是否正确！";
}
