package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

@ApiModel("分页查询SerListOpreateInfoVo")
public class SerListOpreateInfoPageListVo {
    @ApiModelProperty(value="服务单id")
    private Long serListId;

    @ApiModelProperty(value="操作者")
    private String operator;

    @ApiModelProperty(value="操作时间")
    private OffsetDateTime opreatDate;

    @ApiModelProperty(value="操作内容")
    private String opreatContent;

    public Long getSerListId() {
        return serListId;
    }

    public void setSerListId(Long serListId) {
        this.serListId = serListId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public OffsetDateTime getOpreatDate() {
        return opreatDate;
    }

    public void setOpreatDate(OffsetDateTime opreatDate) {
        this.opreatDate = opreatDate;
    }

    public String getOpreatContent() {
        return opreatContent;
    }

    public void setOpreatContent(String opreatContent) {
        this.opreatContent = opreatContent;
    }
}
