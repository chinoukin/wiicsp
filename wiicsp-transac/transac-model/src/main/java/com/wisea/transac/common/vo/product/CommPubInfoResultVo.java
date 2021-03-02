package com.wisea.transac.common.vo.product;

import com.wisea.cloud.model.Page;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/**
 * Auth：wangs
 * 商品返回结果集
 * @param <T>
 */
public class CommPubInfoResultVo<T> {
    @ApiModelProperty("分页")
    private Page<T> page;
    @ApiModelProperty("各个状态总数  key ：状态 、value : 该状态下数量")
    private Map<String, Object> stateCountMap;

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }

    public Map<String, Object> getStateCountMap() {
        return stateCountMap;
    }

    public void setStateCountMap(Map<String, Object> stateCountMap) {
        this.stateCountMap = stateCountMap;
    }
}
