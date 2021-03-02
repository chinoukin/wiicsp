package com.wisea.cultivar.supply.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.supply.vo.SerListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * 服务单列表
 * @author chengq
 * @date 2020/8/12 17:53
 */
public class SerListPo extends PagePo<SerListVo> {

    /**
     * 商品状态
     */
    @ApiModelProperty(value = "服务单状态 0-待确认 1-待服务 2-服务中 不传-全部")
//    @Check(test = {"liveable" }, liveable = {"0", "1", "2",""}, liveableMsg = "商品状态只能是0,1,2")
    private String stateType;

    @ApiModelProperty("服务单编号/客户账号")
    private String query;

    /**
     * 服务商id
     */
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public Long membId;

    public SerListPo() {
    }

    public SerListPo(String stateType) {
        this.stateType = stateType;
    }

    public String getStateType() {
        return stateType;
    }

    public void setStateType(String stateType) {
        this.stateType = stateType;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
