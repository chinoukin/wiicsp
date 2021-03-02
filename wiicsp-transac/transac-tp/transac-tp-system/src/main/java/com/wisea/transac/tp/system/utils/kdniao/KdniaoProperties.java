package com.wisea.transac.tp.system.utils.kdniao;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 快递鸟api参数
 *
 * @author wangjiahao
 * @version 1.0
 * @className KdniaoProperties
 * @since 2019-03-08 14:17
 */
@ConfigurationProperties(prefix = "wbfc.kdniao")
public class KdniaoProperties {

    /**
     * 电商ID
     */
    private String ebusinessId = "";
    /**
     * 电商加密私钥，快递鸟提供，注意保管，不要泄漏
     */
    private String appKey = "";
    /**
     * 请求url
     */
    private String ebusinessOrderHandle = "http://api.kdniao.com/Ebusiness/EbusinessOrderHandle.aspx";

    public String getEbusinessId() {
        return ebusinessId;
    }

    public void setEbusinessId(String ebusinessId) {
        this.ebusinessId = ebusinessId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getEbusinessOrderHandle() {
        return ebusinessOrderHandle;
    }

    public void setEbusinessOrderHandle(String ebusinessOrderHandle) {
        this.ebusinessOrderHandle = ebusinessOrderHandle;
    }
}
