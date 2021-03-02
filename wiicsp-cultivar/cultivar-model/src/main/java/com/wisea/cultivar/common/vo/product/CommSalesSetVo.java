package com.wisea.cultivar.common.vo.product;

import com.wisea.cultivar.common.vo.CommSaleCatgInfoVo;
import com.wisea.cultivar.common.vo.CommVarietMageInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description: 模糊查询 销售分类,分类配置,品类,品种
 * @author: wangs
 * @date :2020/5/8
 */
@ApiModel("模糊查询 销售分类,分类配置,品种")
public class CommSalesSetVo {

    /**
     * 销售分类配置id
     */
    private Long id;
    /**
     * 商品销售分类id
     */
    @ApiModelProperty("商品销售分类id")
    private Long commSaleCatgId;

    /**
     * 基础品类id
     */
    @ApiModelProperty("基础品类id")
    private Long commId;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String commName;

    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private Integer sort;

    /**
     * 销售分类信息
     */
    @ApiModelProperty("销售分类信息")
    private CommSaleCatgInfoVo commSaleCatgInfo;

    /**
     * 品种信息
     */
    @ApiModelProperty("品种信息")
    private List<CommVarietMageInfoVo> commVarietMageInfoVo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommSaleCatgId() {
        return commSaleCatgId;
    }

    public void setCommSaleCatgId(Long commSaleCatgId) {
        this.commSaleCatgId = commSaleCatgId;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public CommSaleCatgInfoVo getCommSaleCatgInfo() {
        return commSaleCatgInfo;
    }

    public void setCommSaleCatgInfo(CommSaleCatgInfoVo commSaleCatgInfo) {
        this.commSaleCatgInfo = commSaleCatgInfo;
    }

    public List<CommVarietMageInfoVo> getCommVarietMageInfoVo() {
        return commVarietMageInfoVo;
    }

    public void setCommVarietMageInfoVo(List<CommVarietMageInfoVo> commVarietMageInfoVo) {
        this.commVarietMageInfoVo = commVarietMageInfoVo;
    }
}
