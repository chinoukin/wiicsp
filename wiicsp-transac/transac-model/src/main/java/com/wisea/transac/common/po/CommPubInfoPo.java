package com.wisea.transac.common.po;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.transac.common.po.product.CommAttriMagePo;
import com.wisea.transac.common.po.product.CommPictureMagePo;
import com.wisea.transac.common.po.product.LevelSpecQuoteMagePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.javers.core.metamodel.annotation.DiffInclude;

import java.util.List;

/**
 * @Author wangs
 *
 */
@ApiModel("商品发布新增或修改Po")
public class CommPubInfoPo {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "商品编号")
    private String commNum;

    @ApiModelProperty(value = "会员id（商家）")
    private Long membId;

    @ApiModelProperty(value = "销售员工id")
    private Long saleStaffId;

    @ApiModelProperty(value = "档口id")
    @DiffInclude
    private Long stallsMageId;

    @Check(test = "required", requiredMsg = "品类不能为空")
    @ApiModelProperty(value = "品类id")
    @DiffInclude
    private Long commId;

    @Check(test = {"required", "regex"}, requiredMsg = "商品标题不能为空", regex = "^(.|\\n){0,30}$", regexMsg = "商品名称不能超过30个字符")
    @ApiModelProperty(value = "商品标题")
    @DiffInclude
    private String commTitle;

    @Check(test = "required", requiredMsg = "商品品种不能为空")
    @ApiModelProperty(value = "商品品种id")
    @DiffInclude
    private Long commVarietId;

    @ApiModelProperty(value = "商品品牌id")
    private Long brandMageId;

    @ApiModelProperty(value = "产地类型")
    private String originPlaceType;

    @ApiModelProperty(value = "国外产地id")
    @Check(test = "logic", logic = "'1'.equals(#originPlaceType)?#isNotEmpty(#abroadId):#isEmpty(#abroadId)",logicMsg = "国外产地信息不符")
    private Long abroadId;

    @Check(test = "logic", logic = "'0'.equals(#originPlaceType)?#isNotEmpty(#commLocalProv):#isEmpty(#commLocalProv)",logicMsg = "商品产地省不能为空")
    @ApiModelProperty(value = "商品产地类型是 0 ,商品产省份必填")
    private String commLocalProv;

    @Check(test = "logic", logic = "'0'.equals(#originPlaceType)?#isNotEmpty(#commLocalProv):#isEmpty(#commLocalProv)",logicMsg = "商品产地市不能为空")
    @ApiModelProperty(value = "商品产地类型是 0 ,商品产地市必填")
    private String commLocalCity;

    @Check(test = "logic", logic = "'0'.equals(#originPlaceType)?#isNotEmpty(#commLocalProv):#isEmpty(#commLocalProv)",logicMsg = "商品产地县不能为空")
    @ApiModelProperty(value = "商品产地类型是 0 ,商品产地县必填")
    private String commLocalCou;

    @ApiModelProperty(value = "商品描述")
    private String commSignature;

    @ApiModelProperty(value = "推荐语")
    private String recommend;

    @ApiModelProperty(value = "购买须知")
    private String notesToBuy;

    @ApiModelProperty(value = "商品发布状态")
    @Check(test = "required", requiredMsg = "商品状态不能为空")
    private String commStateType;

    @ApiModelProperty(value = "驳回原因（审核意见）")
    private String rejectReason;

    @ApiModelProperty(value = "审核人id(后台管理员id)")
    private Long examId;

    @Check(test = "required", requiredMsg = "商品销售配置id不能为空")
    @ApiModelProperty(value = "商品销售分类配置id")
    private Long commSaleSetId;

    @ApiModelProperty(value = "服务支持")
    private String serSupportType;

    @ApiModelProperty(value = "商品服务")
    private String serTypeExpres;

    @ApiModelProperty("仓库类型")
    private String storageType;

    @ApiModelProperty("所在仓储id")
    private Long storageId;

    @ApiModelProperty("所在种植园id")
    private Long plantationId;

    @ApiModelProperty("口岸id")
    private Long portId;

    @ApiModelProperty("基地id")
    private Long baseId;

    @ApiModelProperty(value = "版本号")
    private String versionNum;

//    @ApiModelProperty("发布状态（存草稿：false） 、 （发布：true）")
//    @Check(test = "required", requiredMsg = "商品发布状态不能为空")
    private Boolean releaseType;

    @ApiModelProperty("货品类型:0 非标件; 1 标价")
    private String goodsType;

    @ApiModelProperty("一件代发服务标志 : 0 是 ; 1 否")
    private String yjdfFlag;

    @ApiModelProperty(value = "商品属性列表")
    private List<CommAttriMagePo> commAttris;

    @ApiModelProperty(value = "商品图片")
    private List<CommPictureMagePo> commPictures;

    @ApiModelProperty("商品价格信息")
    private List<LevelSpecQuoteMagePo> levelSpecQuoteMagePos;

    public String getSerTypeExpres() {
        return serTypeExpres;
    }

    public void setSerTypeExpres(String serTypeExpres) {
        this.serTypeExpres = serTypeExpres;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getYjdfFlag() {
        return yjdfFlag;
    }

    public void setYjdfFlag(String yjdfFlag) {
        this.yjdfFlag = yjdfFlag;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public Long getPlantationId() {
        return plantationId;
    }

    public void setPlantationId(Long plantationId) {
        this.plantationId = plantationId;
    }

    public Long getPortId() {
        return portId;
    }

    public void setPortId(Long portId) {
        this.portId = portId;
    }

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public String getSerSupportType() {
        return serSupportType;
    }

    public void setSerSupportType(String serSupportType) {
        this.serSupportType = serSupportType;
    }

    public Boolean getReleaseType() {
        return releaseType;
    }

    public void setReleaseType(Boolean releaseType) {
        this.releaseType = releaseType;
    }

    public List<com.wisea.transac.common.po.product.CommAttriMagePo> getCommAttris() {
        return commAttris;
    }

    public void setCommAttris(List<CommAttriMagePo> commAttris) {
        this.commAttris = commAttris;
    }

    public List<CommPictureMagePo> getCommPictures() {
        return commPictures;
    }

    public void setCommPictures(List<CommPictureMagePo> commPictures) {
        this.commPictures = commPictures;
    }

    public List<LevelSpecQuoteMagePo> getLevelSpecQuoteMagePos() {
        return levelSpecQuoteMagePos;
    }

    public void setLevelSpecQuoteMagePos(List<LevelSpecQuoteMagePo> levelSpecQuoteMagePos) {
        this.levelSpecQuoteMagePos = levelSpecQuoteMagePos;
    }

    public CommPubInfoPo() {
    }

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

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getSaleStaffId() {
        return saleStaffId;
    }

    public void setSaleStaffId(Long saleStaffId) {
        this.saleStaffId = saleStaffId;
    }

    public Long getStallsMageId() {
        return stallsMageId;
    }

    public void setStallsMageId(Long stallsMageId) {
        this.stallsMageId = stallsMageId;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    public Long getBrandMageId() {
        return brandMageId;
    }

    public void setBrandMageId(Long brandMageId) {
        this.brandMageId = brandMageId;
    }

    public String getOriginPlaceType() {
        return originPlaceType;
    }

    public void setOriginPlaceType(String originPlaceType) {
        this.originPlaceType = originPlaceType;
    }

    public Long getAbroadId() {
        return abroadId;
    }

    public void setAbroadId(Long abroadId) {
        this.abroadId = abroadId;
    }

    public String getCommLocalProv() {
        return commLocalProv;
    }

    public void setCommLocalProv(String commLocalProv) {
        this.commLocalProv = commLocalProv;
    }

    public String getCommLocalCity() {
        return commLocalCity;
    }

    public void setCommLocalCity(String commLocalCity) {
        this.commLocalCity = commLocalCity;
    }

    public String getCommLocalCou() {
        return commLocalCou;
    }

    public void setCommLocalCou(String commLocalCou) {
        this.commLocalCou = commLocalCou;
    }

    public String getCommSignature() {
        return commSignature;
    }

    public void setCommSignature(String commSignature) {
        this.commSignature = commSignature;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getNotesToBuy() {
        return notesToBuy;
    }

    public void setNotesToBuy(String notesToBuy) {
        this.notesToBuy = notesToBuy;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Long getCommSaleSetId() {
        return commSaleSetId;
    }

    public void setCommSaleSetId(Long commSaleSetId) {
        this.commSaleSetId = commSaleSetId;
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }
}
