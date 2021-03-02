package com.wisea.cultivar.common.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author chengq
 * @date 2020/8/15 18:22
 */
public class CommMageSearchPo {

    @ApiModelProperty("名称")
    private String name;

    /**
     * 过滤的id
     */
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<Long> filterMageIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getFilterMageIds() {
        return filterMageIds;
    }

    public void setFilterMageIds(List<Long> filterMageIds) {
        this.filterMageIds = filterMageIds;
    }
}
