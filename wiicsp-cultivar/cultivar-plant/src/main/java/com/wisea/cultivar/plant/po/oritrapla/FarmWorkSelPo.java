package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询农事记录PO
 *
 * @author yangtao
 *
 * @version 1.0
 */
@ApiModel("查询农事记录PO")
public class FarmWorkSelPo {

    @ApiModelProperty("数据ID")
    @Check(test = "required")
    private Long id;

    @ApiModelProperty("记录状态")
    private String recordStatus;

    @ApiModelProperty("输入框查询")
    private String searchKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
}
