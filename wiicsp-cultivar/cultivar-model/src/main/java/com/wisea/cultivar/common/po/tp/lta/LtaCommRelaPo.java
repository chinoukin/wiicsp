package com.wisea.cultivar.common.po.tp.lta;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description: 长协商品新增修改传递参数
 * @author: wangs
 * @date :2019/5/7
 */
@ApiModel("长协商品新增修改传递参数")
public class LtaCommRelaPo {

    @ApiModelProperty("长协发布商品的id;只在修改时传递")
    private Long id;
    /**
     * 商品编号
     */
    @ApiModelProperty("商品编号")
    @Check(test = "required", requiredMsg = "商品编号不能为空")
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
    @Check(test = "required", requiredMsg = "商品名称不能为空")
    private String commName;

    /**
     * 商品品牌(品牌管理表id)
     */
    @ApiModelProperty("品牌id")
    private Long brandId;

    /**
     * 商品id
     */
    @ApiModelProperty("后台商品树id")
    @Check(test = "required", requiredMsg = "后台商品树id不能为空")
    private Long commCatgId;

    /**
     * 品种id
     */
    @ApiModelProperty("后台商品品种id")
    private Long commVariId;

    /**
     * 等级
     */
    @ApiModelProperty("等级")
    @Check(test = "required", requiredMsg = "等级信息不能为空")
    private String level;

    @ApiModelProperty("商品状态")
    private String ltaCommStateType;

    @ApiModelProperty("用于存储商品名称拼接信息热带水果 -> 苹果 -> 品种1号苹果")
    private String remarks;

    /**
     * 长协商品包装规格设置集合
     */
    @ApiModelProperty(value = "长协商品包装规格设置集合")
    @Check(test = "required", requiredMsg = "长协商品包装规格设置集合不能为空")
    private List<LtaCommPackPo> ltaCommPackPos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLtaCommStateType() {
        return ltaCommStateType;
    }

    public void setLtaCommStateType(String ltaCommStateType) {
        this.ltaCommStateType = ltaCommStateType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<LtaCommPackPo> getLtaCommPackPos() {
        return ltaCommPackPos;
    }

    public void setLtaCommPackPos(List<LtaCommPackPo> ltaCommPackPos) {
        this.ltaCommPackPos = ltaCommPackPos;
    }
}
