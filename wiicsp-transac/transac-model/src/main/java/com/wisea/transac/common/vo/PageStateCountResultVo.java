package com.wisea.transac.common.vo;

import com.wisea.cloud.model.Page;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/**
 * Auth： itudou
 * CreateDate:  2017/12/23
 * projectName:  wtp
 * remark:  分页信息
 */
public class PageStateCountResultVo<T> {
    @ApiModelProperty("分页")
    private Page<T> page;
    @ApiModelProperty("各个状态总数  key ：状态 、value : 该状态下数量")
    private Map<String, Integer> stateCountMap;

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }

    public Map<String, Integer> getStateCountMap() {
        return stateCountMap;
    }

    public void setStateCountMap(Map<String, Integer> stateCountMap) {
        this.stateCountMap = stateCountMap;
    }
}
