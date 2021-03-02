package com.wisea.transac.common.po.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className SortingFactoryListVo
 * @date 2020/7/1 14:49
 * @Description 分选工厂列表VO
 */
@ApiModel("分选工厂列表VO")
public class SortingFactoryListVo {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("基地id")
    private Long baseId;
    @ApiModelProperty("分选工厂名称")
    private String sortingFactoryName;
    @ApiModelProperty("工厂面积")
    private Double sortingFactoryMj;
    @ApiModelProperty("联系人")
    private String conter;
    @ApiModelProperty("联系人手机号")
    private String contTel;
    @ApiModelProperty("图片url")
    private String imgUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public String getSortingFactoryName() {
        return sortingFactoryName;
    }

    public void setSortingFactoryName(String sortingFactoryName) {
        this.sortingFactoryName = sortingFactoryName;
    }

    public Double getSortingFactoryMj() {
        return sortingFactoryMj;
    }

    public void setSortingFactoryMj(Double sortingFactoryMj) {
        this.sortingFactoryMj = sortingFactoryMj;
    }

    public String getConter() {
        return conter;
    }

    public void setConter(String conter) {
        this.conter = conter;
    }

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
