package com.wisea.cultivar.common.po.bigdata;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;

import com.wisea.cultivar.common.vo.bigdata.BaseInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className BaseInfoPo
 * @date 2019/7/19 15:06
 * @Description
 */
@ApiModel("基地详细信息PO")
public class BaseInfoPo extends PagePo<BaseInfoVo> {
    @ApiModelProperty("基地ID")
    @Check(test = "required")
    private Long id;
    @ApiModelProperty("现在时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime nowDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public OffsetDateTime getNowDate() {
		return nowDate;
	}

	public void setNowDate(OffsetDateTime nowDate) {
		this.nowDate = nowDate;
	}
}
