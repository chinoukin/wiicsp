package com.wisea.cultivar.common.po.product;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.product.CommDataListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangs
 */
public class CommDataListPo extends PagePo<CommDataListVo> {

    private static final long serialVersionUID = -3865130845697189245L;


    /**
     * 商品状态类型
     */
    @ApiModelProperty(value = "商品状态类型")
    private String commStateType;

    /**
     * 商品编号、货号、名称、检索字段
     */
    @ApiModelProperty(value = "商品名称/服务商名称")
    private String likeName;

    @ApiModelProperty(value = "查询端用户类型：0 市场 、1 卖家", hidden = true)
    private String queryUserFlag;
    /**
     * 商品分类
     */
    @ApiModelProperty(value = "商品分类")
    @JsonSerialize(using = IdSerializer.class)
    private Long commId;

    public String getQueryUserFlag() {
        return queryUserFlag;
    }

    public void setQueryUserFlag(String queryUserFlag) {
        this.queryUserFlag = queryUserFlag;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }

    public String getLikeName() {
        return likeName;
    }

    public void setLikeName(String likeName) {
        this.likeName = likeName;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }
}
