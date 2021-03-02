package com.wisea.cultivar.common.po.tp.lta;

import com.wisea.cultivar.common.vo.tp.lta.LtaCommRelaListVo;
import com.wisea.cloud.model.po.PagePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 长协商品列表入参
 * @author: wangs
 * @date :2019/5/8
 */
@ApiModel("长协商品列表入参")
public class LtaCommRelaPagePo extends PagePo<LtaCommRelaListVo> {

    /**
     *  商品搜索信息
     */
    @ApiModelProperty(value = "商品搜索信息(包含:商品编号,商品货号,商品名称,商品id)")
    private String search;

    /**
     *  买家商品搜索
     */
    private String searchInput;

    /**
     * 会员id
     */
    @ApiModelProperty(value = "首页传递会员id")
    private Long membId;

    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id")
    private Long commId;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }
}
