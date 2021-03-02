package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * memb_label_list 表实体
 * 会员标签列表
 * 2018/10/12 16:56:34
 */
public class MembLabelList extends DataLongEntity<MembLabelList> {
    private static final long serialVersionUID = 1L;


    private String labelCatgType;

    private String certType;

    private String labelName;

    private String alredyActUrl;

    private String notActUrl;

    private String labelDesc;

    private Integer sort;

    public String getLabelCatgType() {
        return labelCatgType;
    }

    public void setLabelCatgType(String labelCatgType) {
        this.labelCatgType = labelCatgType == null ? null : labelCatgType.trim();
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    public String getAlredyActUrl() {
        return alredyActUrl;
    }

    public void setAlredyActUrl(String alredyActUrl) {
        this.alredyActUrl = alredyActUrl == null ? null : alredyActUrl.trim();
    }

    public String getNotActUrl() {
        return notActUrl;
    }

    public void setNotActUrl(String notActUrl) {
        this.notActUrl = notActUrl == null ? null : notActUrl.trim();
    }

    public String getLabelDesc() {
        return labelDesc;
    }

    public void setLabelDesc(String labelDesc) {
        this.labelDesc = labelDesc == null ? null : labelDesc.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}
}
