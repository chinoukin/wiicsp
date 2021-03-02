package com.wisea.cultivar.plant.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.SproutCatalogMagePageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询SproutCatalogMagePo")
public class SproutCatalogMagePageListPo extends PagePo<SproutCatalogMagePageListVo> {
    @ApiModelProperty(value="种苗目录名称")
    private String sproutCatalogName;

    @ApiModelProperty(value="年份")
    private Integer sproutYear;

    @ApiModelProperty(value="种苗目录状态类型")
    private String sproutCatalogStateType;

    @ApiModelProperty(value="主推品种数")
    private Integer mainThrustNum;

    public String getSproutCatalogName() {
        return sproutCatalogName;
    }

    public void setSproutCatalogName(String sproutCatalogName) {
        this.sproutCatalogName = sproutCatalogName;
    }

    public Integer getSproutYear() {
        return sproutYear;
    }

    public void setSproutYear(Integer sproutYear) {
        this.sproutYear = sproutYear;
    }

    public String getSproutCatalogStateType() {
        return sproutCatalogStateType;
    }

    public void setSproutCatalogStateType(String sproutCatalogStateType) {
        this.sproutCatalogStateType = sproutCatalogStateType;
    }

    public Integer getMainThrustNum() {
        return mainThrustNum;
    }

    public void setMainThrustNum(Integer mainThrustNum) {
        this.mainThrustNum = mainThrustNum;
    }
}
