package com.wisea.transac.common.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.OrdOpreateInfoPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("分页查询Po")
public class OrdOpreateInfoPageListPo extends PagePo<OrdOpreateInfoPageListVo> {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="订单id")
    private Long ordId;

    @ApiModelProperty(value="操作者")
    private String operator;

    @ApiModelProperty(value="操作时间")
    private OffsetDateTime opreatDate;

    @ApiModelProperty(value="操作内容")
    private String opreatContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
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
