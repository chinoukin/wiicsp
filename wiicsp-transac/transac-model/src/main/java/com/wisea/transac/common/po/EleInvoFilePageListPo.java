package com.wisea.transac.common.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.EleInvoFilePageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询Po")
public class EleInvoFilePageListPo extends PagePo<EleInvoFilePageListVo> {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="订单发票id")
    private Long ordInvoId;

    @ApiModelProperty(value="电子发票url")
    private String eleInvoUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdInvoId() {
        return ordInvoId;
    }

    public void setOrdInvoId(Long ordInvoId) {
        this.ordInvoId = ordInvoId;
    }

    public String getEleInvoUrl() {
        return eleInvoUrl;
    }

    public void setEleInvoUrl(String eleInvoUrl) {
        this.eleInvoUrl = eleInvoUrl;
    }
}
