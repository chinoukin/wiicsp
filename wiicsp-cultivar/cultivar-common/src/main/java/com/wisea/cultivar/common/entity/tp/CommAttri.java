package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * comm_attri 表实体
 * 商品属性值
 * 2018/09/18 14:36:47
 */
public class CommAttri extends DataLongEntity<CommAttri> {
    private static final long serialVersionUID = 1L;

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

    @ApiModelProperty("属性ID（添加使用）")
    private Long attribtId;

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

    /**
     * 获取商品发布id
     */
    public Long getCommPubId() {
        return commPubId;
    }

    /**
     * 设置商品发布id
     */
    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    /**
     * 获取属性id
     */
    public Long getCommAttriId() {
        return commAttriId;
    }

    /**
     * 设置属性id
     */
    public void setCommAttriId(Long commAttriId) {
        this.commAttriId = commAttriId;
    }

    /**
     * 获取属性名称
     */
    public String getCommAttriName() {
        return commAttriName;
    }

    /**
     * 设置属性名称
     */
    public void setCommAttriName(String commAttriName) {
        this.commAttriName = commAttriName == null ? null : commAttriName.trim();
    }

    /**
     * 获取属性字段
     */
    public String getCommAttriColumn() {
        return commAttriColumn;
    }

    /**
     * 设置属性字段
     */
    public void setCommAttriColumn(String commAttriColumn) {
        this.commAttriColumn = commAttriColumn == null ? null : commAttriColumn.trim();
    }

    /**
     * 获取属性类型
     */
    public String getCommAttriType() {
        return commAttriType;
    }

    /**
     * 设置属性类型
     */
    public void setCommAttriType(String commAttriType) {
        this.commAttriType = commAttriType == null ? null : commAttriType.trim();
    }

    /**
     * 获取属性值
     */
    public String getCommAttriVal() {
        return commAttriVal;
    }

    /**
     * 设置属性值
     */
    public void setCommAttriVal(String commAttriVal) {
        this.commAttriVal = commAttriVal == null ? null : commAttriVal.trim();
    }

    /**
     * 获取长度
     */
    public Integer getLength() {
        return length;
    }

    /**
     * 设置长度
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * 获取是否必填
     */
    public String getIfRequ() {
        return ifRequ;
    }

    /**
     * 设置是否必填
     */
    public void setIfRequ(String ifRequ) {
        this.ifRequ = ifRequ == null ? null : ifRequ.trim();
    }

    /**
     * 获取显示顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置显示顺序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取字典值
     */
    public String getDictVal() {
        return dictVal;
    }

    /**
     * 设置字典值
     */
    public void setDictVal(String dictVal) {
        this.dictVal = dictVal == null ? null : dictVal.trim();
    }

    public Long getAttribtId() {
        return attribtId;
    }

    public void setAttribtId(Long attribtId) {
        this.attribtId = attribtId;
    }
}
