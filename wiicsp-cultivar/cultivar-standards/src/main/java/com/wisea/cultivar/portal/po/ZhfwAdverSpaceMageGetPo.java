package com.wisea.cultivar.portal.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * ZhfwAdverSpaceMageGetPo
 * 2020/08/24 20:28:13
 */
public class ZhfwAdverSpaceMageGetPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="id")
    @Check(test = "required")
    private Long id;

    /**
     * 广告位名称
     */
    @ApiModelProperty(value = "广告位名称")
    private String adverSpaceName;

    public String getAdverSpaceName() {
        return adverSpaceName;
    }

    public void setAdverSpaceName(String adverSpaceName) {
        this.adverSpaceName = adverSpaceName;
    }

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

}
