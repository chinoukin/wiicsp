package com.wisea.cultivar.common.vo.tp.portal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 资讯推荐详细信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月31日
 * @version 1.0
 */
@ApiModel("资讯推荐详细信息VO")
public class ZxTjMageGetVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 资讯列表id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "资讯列表id")
    private Long zxListId;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getZxListId() {
		return zxListId;
	}

	public void setZxListId(Long zxListId) {
		this.zxListId = zxListId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
