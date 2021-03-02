package com.wisea.cultivar.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class CommAttri extends DataLongEntity<CommAttri> {
    /**
     * 商品发布id
     */
    private Long commPubId;

    /**
     * 属性id
     */
    private Long commAttriId;

    /**
     * 属性名称
     */
    private String commAttriName;

    /**
     * 属性字段
     */
    private String commAttriColumn;

    /**
     * 属性类型
     */
    private String commAttriType;

    /**
     * 属性值
     */
    private String commAttriVal;

    /**
     * 长度
     */
    private Integer length;

    /**
     * 是否必填
     */
    private String ifRequ;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 字典值
     */
    private String dictVal;

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public Long getCommAttriId() {
        return commAttriId;
    }

    public void setCommAttriId(Long commAttriId) {
        this.commAttriId = commAttriId;
    }

    public String getCommAttriName() {
        return commAttriName;
    }

    public void setCommAttriName(String commAttriName) {
        this.commAttriName = commAttriName;
    }

    public String getCommAttriColumn() {
        return commAttriColumn;
    }

    public void setCommAttriColumn(String commAttriColumn) {
        this.commAttriColumn = commAttriColumn;
    }

    public String getCommAttriType() {
        return commAttriType;
    }

    public void setCommAttriType(String commAttriType) {
        this.commAttriType = commAttriType;
    }

    public String getCommAttriVal() {
        return commAttriVal;
    }

    public void setCommAttriVal(String commAttriVal) {
        this.commAttriVal = commAttriVal;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getIfRequ() {
        return ifRequ;
    }

    public void setIfRequ(String ifRequ) {
        this.ifRequ = ifRequ;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDictVal() {
        return dictVal;
    }

    public void setDictVal(String dictVal) {
        this.dictVal = dictVal;
    }
}
