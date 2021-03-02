package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className CategoryAndVarietiesListVo
 * @date 2019/12/4 16:12
 * @Description
 */
public class CategoryAndVarietiesListVo{
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "品类名称")
    private String categoryName;
    @ApiModelProperty(value = "物料编码")
    private String varietiesNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getVarietiesNum() {
        return varietiesNum;
    }

    public void setVarietiesNum(String varietiesNum) {
        this.varietiesNum = varietiesNum;
    }
}
