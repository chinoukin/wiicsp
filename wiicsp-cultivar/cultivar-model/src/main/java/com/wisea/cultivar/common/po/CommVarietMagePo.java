package com.wisea.cultivar.common.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增或修改Po")
public class CommVarietMagePo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="商品id")
    private Long commId;

    @ApiModelProperty(value="品种名称")
    private String commVarietName;

    @ApiModelProperty(value="显示顺序")
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getCommVarietName() {
        return commVarietName;
    }

    public void setCommVarietName(String commVarietName) {
        this.commVarietName = commVarietName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
