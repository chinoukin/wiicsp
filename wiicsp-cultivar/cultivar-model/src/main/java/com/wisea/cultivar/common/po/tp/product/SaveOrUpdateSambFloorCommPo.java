package com.wisea.cultivar.common.po.tp.product;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2019/5/29
 */
@ApiModel("新增或修改品类或品种")
public class SaveOrUpdateSambFloorCommPo {

    @ApiModelProperty("数据id修改时传递")
    private Long id;

    @ApiModelProperty("品类id")
    @Check(test = "required",requiredMsg = "品类id不能为空")
    private Long commId;

    @ApiModelProperty("楼层id")
    @Check(test = "required",requiredMsg = "楼层id不能为空")
    private Long sambFloorId;

    @ApiModelProperty("品种id")
    private Long commVarietId;

    @ApiModelProperty("排序")
    @Check(test = "required",requiredMsg = "排序字段不能为空")
    private Integer sort;

    private String remarks;

    public Long getSambFloorId() {
        return sambFloorId;
    }

    public void setSambFloorId(Long sambFloorId) {
        this.sambFloorId = sambFloorId;
    }

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

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
