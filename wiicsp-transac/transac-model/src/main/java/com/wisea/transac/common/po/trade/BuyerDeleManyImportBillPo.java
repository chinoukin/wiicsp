package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuyerDeleManyImportBillPo
 * 2018/09/18 17:40:35
 */
@ApiModel("批量删除进货单po")
public class BuyerDeleManyImportBillPo{

	@ApiModelProperty(value = "进货单IDs,id 以  , 分隔")
	@Check(test = "required")
	private String importBillIds;

    public String getImportBillIds() {
        return importBillIds;
    }

    public void setImportBillIds(String importBillIds) {
        this.importBillIds = importBillIds;
    }
}
