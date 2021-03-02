package com.wisea.cultivar.common.vo.tp.lta;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description: 列表返回信息
 * @author: wangs
 * @date :2019/5/8
 */
@ApiModel("商品列表返回值")
public class LtaCommRelaListVo {

    @ApiModelProperty("长协商品id")
    @JsonSerialize(using = IdSerializer.class)
    private Long id;

    @ApiModelProperty("长协发布会员id;")
    @JsonSerialize(using = IdSerializer.class)
    private Long membId;
    /**
     * 商品编号
     */
    @ApiModelProperty("商品编号")
    private String commNum;

    /**
     * 商品货号
     */
    @ApiModelProperty("商品货号")
    private String commHh;

    /**
     * 商品图片url
     */
    @ApiModelProperty("商品图片url")
    private String commPicUrl;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String commName;

    /**
     * 商品品牌(品牌管理表id)
     */
    @ApiModelProperty("品牌id")
    @JsonSerialize(using = IdSerializer.class)
    private Long brandId;

    @ApiModelProperty("品牌名称")
    private String brandName;

    /**
     * 商品id
     */
    @ApiModelProperty("后台商品树id")
    @JsonSerialize(using = IdSerializer.class)
    private Long commCatgId;

    /**
     * 品种id
     */
    @ApiModelProperty("后台商品品种id")
    @JsonSerialize(using = IdSerializer.class)
    private Long commVariId;

    /**
     * 等级
     */
    @ApiModelProperty("等级")
    private String level;

    /**
     * 标记信息 用于拼接商品名称热带水果 -> 苹果 -> 品种名称和id信息
     */
    @ApiModelProperty("标记信息 用于拼接商品名称热带水果 -> 苹果 -> 品种名称和id信息")
    private String remarks;

    /**
     * 商品状态
     */
    @ApiModelProperty("商品状态")
    private String ltaCommStateType;

    /**
     * 长协商品包装规格设置集合
     */
    @ApiModelProperty(value = "长协商品包装规格设置集合")
    private List<LtaCommPackListVo> ltaCommPackPos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public String getCommHh() {
        return commHh;
    }

    public void setCommHh(String commHh) {
        this.commHh = commHh;
    }

    public String getCommPicUrl() {
        return commPicUrl;
    }

    public void setCommPicUrl(String commPicUrl) {
        this.commPicUrl = commPicUrl;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getCommCatgId() {
        return commCatgId;
    }

    public void setCommCatgId(Long commCatgId) {
        this.commCatgId = commCatgId;
    }

    public Long getCommVariId() {
        return commVariId;
    }

    public void setCommVariId(Long commVariId) {
        this.commVariId = commVariId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getLtaCommStateType() {
        return ltaCommStateType;
    }

    public void setLtaCommStateType(String ltaCommStateType) {
        this.ltaCommStateType = ltaCommStateType;
    }

    public List<LtaCommPackListVo> getLtaCommPackPos() {
        return ltaCommPackPos;
    }

    public void setLtaCommPackPos(List<LtaCommPackListVo> ltaCommPackPos) {
        this.ltaCommPackPos = ltaCommPackPos;
    }
}
