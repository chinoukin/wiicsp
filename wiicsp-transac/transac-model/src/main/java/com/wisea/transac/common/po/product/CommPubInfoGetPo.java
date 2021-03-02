package com.wisea.transac.common.po.product;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Author wangs
 * CommPubInfoGetPo
 * 2018/09/18 14:36:47
 */
public class CommPubInfoGetPo {

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    @Check(test = "required")
    private Long id;

    private Long membId;

    private String updateTime;

    private List<CommPubInfoGetPo> listPo;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public List<CommPubInfoGetPo> getListPo() {
        return listPo;
    }

    public void setListPo(List<CommPubInfoGetPo> listPo) {
        this.listPo = listPo;
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
