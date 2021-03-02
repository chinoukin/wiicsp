package com.wisea.cultivar.common.vo.tp.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 品类,品种编辑返回参数
 * @author: wangs
 * @date :2019/5/29
 */
@ApiModel("品类,品种编辑返回参数")
public class SambFloorCommGetVo {

    @ApiModelProperty("记录id")
    private Long id;
    /**
     * 中小零批页楼层id
     */
    @ApiModelProperty("楼层id")
    private Long sambFloorId;

    /**
     * 商品分类
     */
    @ApiModelProperty("商品分类")
    private Long commId;

    @ApiModelProperty("品类名称")
    private String commName;

    /**
     * 商品品种
     */
    @ApiModelProperty("商品品种")
    private Long commVarietId;

    @ApiModelProperty("品种名称")
    private String commVarietName;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("预留字段")
    private String remarks;

    private String delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getCommVarietName() {
        return commVarietName;
    }

    public void setCommVarietName(String commVarietName) {
        this.commVarietName = commVarietName;
    }

    public Long getSambFloorId() {
        return sambFloorId;
    }

    public void setSambFloorId(Long sambFloorId) {
        this.sambFloorId = sambFloorId;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
