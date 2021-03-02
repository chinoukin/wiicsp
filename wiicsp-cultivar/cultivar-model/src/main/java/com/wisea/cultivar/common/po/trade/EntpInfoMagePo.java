package com.wisea.cultivar.common.po.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: EntpInfoMagePo
 * @Author: tgz
 * @Date: 2020/8/7 18:23
 */
@ApiModel("企业信息查询")
public class EntpInfoMagePo {
    /**
     * 品种名称/字母
     */
    @ApiModelProperty(value = "品种名称/字母")
    private String query;

    private Long id;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
