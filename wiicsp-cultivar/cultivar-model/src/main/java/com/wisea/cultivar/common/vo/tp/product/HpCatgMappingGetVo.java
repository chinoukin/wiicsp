package com.wisea.cultivar.common.vo.tp.product;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2019/5/30
 */
public class HpCatgMappingGetVo {

    @ApiModelProperty("映射关系id,编辑时传递")
    private Long id;
    /**
     * 首页分类id
     */
    @ApiModelProperty("首页分类id")
    private Long hpCatgId;

    /**
     * 映射类型（品类、品种、搜索）
     */
    @ApiModelProperty("映射类型（品类、品种、搜索）")
    private String mappingType;

    /**
     * 商品分类
     */
    @ApiModelProperty("商品分类")
    private Long commId;

    @ApiModelProperty("商品分类名称")
    private String commName;

    /**
     * 商品品种
     */
    @ApiModelProperty("商品品种")
    private Long commVarietId;

    @ApiModelProperty("商品品种名称")
    private String commVarietName;

    /**
     * 搜索内容
     */
    @ApiModelProperty("搜索内容")
    private String searchKey;

    private String remarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHpCatgId() {
        return hpCatgId;
    }

    public void setHpCatgId(Long hpCatgId) {
        this.hpCatgId = hpCatgId;
    }

    public String getMappingType() {
        return mappingType;
    }

    public void setMappingType(String mappingType) {
        this.mappingType = mappingType;
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

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    public String getCommVarietName() {
        return commVarietName;
    }

    public void setCommVarietName(String commVarietName) {
        this.commVarietName = commVarietName;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
