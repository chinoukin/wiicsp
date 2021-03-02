package com.wisea.cultivar.common.entity.tp;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @author: wangs
 * @date :2018/11/1
 */
public class MembLabelRedisPo implements Serializable {

    @ApiModelProperty("商品标签后台配置项不包含品,检")
    private List<EntpCertMage> entpCertMages;
    @ApiModelProperty("商品,品,检标签")
    private List<CommSampRela> commSampRelas;
    @ApiModelProperty("商品标签的key")
    private String membLabelKey;
    @ApiModelProperty("商品标签的id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<EntpCertMage> getEntpCertMages() {
        return entpCertMages;
    }

    public void setEntpCertMages(List<EntpCertMage> entpCertMages) {
        this.entpCertMages = entpCertMages;
    }

    public List<CommSampRela> getCommSampRelas() {
        return commSampRelas;
    }

    public void setCommSampRelas(List<CommSampRela> commSampRelas) {
        this.commSampRelas = commSampRelas;
    }

    public String getMembLabelKey() {
        return membLabelKey;
    }

    public void setMembLabelKey(String membLabelKey) {
        this.membLabelKey = membLabelKey;
    }
}
