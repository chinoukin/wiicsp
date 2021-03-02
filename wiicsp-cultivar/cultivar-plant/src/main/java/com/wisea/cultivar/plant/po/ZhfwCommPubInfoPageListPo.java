package com.wisea.cultivar.plant.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.ZhfwCommPubInfoPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询ZhfwCommPubInfoPo")
public class ZhfwCommPubInfoPageListPo extends PagePo<ZhfwCommPubInfoPageListVo> {
    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="商品标题")
    private String commTitle;

    @ApiModelProperty(value="品类id")
    private Long commId;

       @ApiModelProperty(value = "排序 默认=0   发布时间倒序 0 销量倒序1 价格正序2 价格倒序3  更新时间=4")
    private Integer sort=0;


    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

}
