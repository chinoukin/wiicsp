package com.wisea.cultivar.common.po.product;

import io.swagger.annotations.ApiModelProperty;
import org.javers.core.metamodel.annotation.DiffInclude;

/**
 * @Description: 商品属性信息
 * @author: wangs
 * @date :2020/5/7
 */
public class CommAttriMagePo {

    @ApiModelProperty("冗余ID")
    private Long id;
    @DiffInclude
    @ApiModelProperty("属性值")
    private String commAttriVal;
    @DiffInclude
    @ApiModelProperty("属性ID（新增时使用）")
    private Long commAttriId;

    private String dictVal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommAttriVal() {
        return commAttriVal;
    }

    public void setCommAttriVal(String commAttriVal) {
        this.commAttriVal = commAttriVal;
    }

    public Long getCommAttriId() {
        return commAttriId;
    }

    public void setCommAttriId(Long commAttriId) {
        this.commAttriId = commAttriId;
    }

    public String getDictVal() {
        return dictVal;
    }

    public void setDictVal(String dictVal) {
        this.dictVal = dictVal;
    }
}
