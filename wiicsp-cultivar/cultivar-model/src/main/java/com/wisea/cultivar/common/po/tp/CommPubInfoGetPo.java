package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Author
 * CommPubInfoGetPo
 * 2018/09/18 14:36:47
 */
public class CommPubInfoGetPo {

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="发布商品id")
    @Check(test = "required")
    private Long id;

    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="商家传递membId")
    private Long membId;

    private List<CommPubInfoGetPo> listPo;

    public List<CommPubInfoGetPo> getListPo() {
        return listPo;
    }

    public void setListPo(List<CommPubInfoGetPo> listPo) {
        this.listPo = listPo;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
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
