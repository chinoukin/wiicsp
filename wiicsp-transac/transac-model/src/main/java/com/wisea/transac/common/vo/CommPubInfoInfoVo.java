package com.wisea.transac.common.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.transac.common.vo.product.LevelSqecQuatePriceVo;
import com.wisea.transac.common.vo.seller.StallsMageInfoVo;
import com.wisea.transac.common.vo.system.EntpCommSerInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @Author wangs
 */
@ApiModel("商品详细信息Vo")
public class CommPubInfoInfoVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "商品编号")
    private String commNum;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id（商家）")
    private Long membId;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "销售员工id")
    private Long saleStaffId;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "档口id")
    private Long stallsMageId;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "品类id")
    private Long commId;

    @ApiModelProperty(value = "商品标题")
    private String commTitle;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品品种id")
    private Long commVarietId;

    @ApiModelProperty(value = "品种名称")
    private String commVarietName;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品品牌id")
    private Long brandMageId;

    @ApiModelProperty(value = "产地类型")
    private String originPlaceType;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "国外产地id")
    private Long abroadId;

    @ApiModelProperty(value = "商品产地省")
    private String commLocalProv;

    @ApiModelProperty(value = "商品产地市")
    private String commLocalCity;

    @ApiModelProperty(value = "商品产地区县")
    private String commLocalCou;

    @ApiModelProperty(value = "商品产地省名称")
    private String commLocalProvName;

    @ApiModelProperty(value = "商品产地市名称")
    private String commLocalCityName;

    @ApiModelProperty(value = "商品产地区县名称")
    private String commLocalCouName;

    @ApiModelProperty(value = "商品描述")
    private String commSignature;

    @ApiModelProperty(value = "推荐语")
    private String recommend;

    @ApiModelProperty(value = "购买须知")
    private String notesToBuy;

    @ApiModelProperty(value = "商品发布状态")
    private String commStateType;

    @ApiModelProperty(value = "驳回原因（审核意见）")
    private String rejectReason;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "审核人id(后台管理员id)")
    private Long examId;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品销售分类id")
    private Long commSaleSetId;

    @ApiModelProperty(value = "商品销售分类名称")
    private String commSaleSetName;

    @ApiModelProperty(value = "主商品的价格区间")
    private String startOrdExpres;

    @ApiModelProperty(value = "版本号")
    private String versionNum;

    @ApiModelProperty(value = "服务支持")
    private String serSupportType;

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

    @ApiModelProperty("基地图片")
    private String basePicture;

    @ApiModelProperty("所在仓储名称")
    private String storageName;

    @ApiModelProperty("所在种植园名称")
    private String plantationName;

    @ApiModelProperty("口岸名称")
    private String portName;

    @ApiModelProperty("口岸省级code")
    private String areaProv;

    @ApiModelProperty("口岸省级code-对应的中文")
    private String areaProvName;

    @ApiModelProperty("基地名称")
    private String baseName;

    @ApiModelProperty("国外产地名称")
    private String aroudName;

    @ApiModelProperty("商家名称")
    private String entpName;

    @ApiModelProperty("价格区间")
    private String priceRange;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "店铺id")
    private Long followMerchantId;

    @ApiModelProperty(value = "商品服务")
    private String serTypeExpres;


    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "followComm关注商品id")
    private Long followCommPubId;

    @ApiModelProperty(value = "审核名称(如果个人认证显示姓名,个体和企业显示企业名称)优先级顺序：企业>个体>个人")
    private String authName;

    @ApiModelProperty(value = "审核状态(auth_state_type[2:实名认证中3:审核通过(已认证)]为空为未填写认证信息)")
    private String realPersonAuth;

    @ApiModelProperty(value = "审核状态(auth_state_type[0:待平台审核1:待银盛开户3:审核通过(已认证)4:审核未通过]为空为未填写认证信息)")
    private String indBusiAuth;

    @ApiModelProperty("品牌信息")
    private BrandMageInfoVo brandMage;

    @ApiModelProperty("档口信息")
    private StallsMageInfoVo stallsMageInfoVo;

    @ApiModelProperty("属性列表")
    private List<CommAttriInfoVo> commAttri;

    @ApiModelProperty("图片列表")
    private List<CommPictureInfoVo> commPicture;

    @ApiModelProperty("规格报价")
    private List<LevelSqecQuatePriceVo> commLevelPo;

    public String getBasePicture() {
        return basePicture;
    }

    public void setBasePicture(String basePicture) {
        this.basePicture = basePicture;
    }

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime createDate;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime updateDate;

    @ApiModelProperty(value = "服务支持名称和说明")
    private String[] supportTypeNameContant;

    @ApiModelProperty("服务支持信息对象")
    private List<AgentSerListInfoVo> agentSerListInfoVos;

    @ApiModelProperty("改版后 商品服务信息")
    private List<EntpCommSerInfoVo> entpCommSerInfoVo;

    @ApiModelProperty("发布状态（已下架：false） 、 （销售中：true）")
    private Boolean releaseType;

    @ApiModelProperty("货品类型:0 非标件; 1 标价")
    private String goodsType;

    @ApiModelProperty("一件代发服务标志 : 0 是 ; 1 否")
    private String yjdfFlag;

    public List<EntpCommSerInfoVo> getEntpCommSerInfoVo() {
        return entpCommSerInfoVo;
    }

    public void setEntpCommSerInfoVo(List<EntpCommSerInfoVo> entpCommSerInfoVo) {
        this.entpCommSerInfoVo = entpCommSerInfoVo;
    }

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

    public String getAreaProv() {
        return areaProv;
    }

    public void setAreaProv(String areaProv) {
        this.areaProv = areaProv;
    }

    public String getAreaProvName() {
        return areaProvName;
    }

    public void setAreaProvName(String areaProvName) {
        this.areaProvName = areaProvName;
    }

    public String getCommSaleSetName() {
        return commSaleSetName;
    }

    public void setCommSaleSetName(String commSaleSetName) {
        this.commSaleSetName = commSaleSetName;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getPlantationName() {
        return plantationName;
    }

    public void setPlantationName(String plantationName) {
        this.plantationName = plantationName;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
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

    public List<AgentSerListInfoVo> getAgentSerListInfoVos() {
        return agentSerListInfoVos;
    }

    public void setAgentSerListInfoVos(List<AgentSerListInfoVo> agentSerListInfoVos) {
        this.agentSerListInfoVos = agentSerListInfoVos;
    }

    public Long getFollowCommPubId() {
        return followCommPubId;
    }

    public void setFollowCommPubId(Long followCommPubId) {
        this.followCommPubId = followCommPubId;
    }

    public String getCommVarietName() {
        return commVarietName;
    }

    public void setCommVarietName(String commVarietName) {
        this.commVarietName = commVarietName;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getRealPersonAuth() {
        return realPersonAuth;
    }

    public void setRealPersonAuth(String realPersonAuth) {
        this.realPersonAuth = realPersonAuth;
    }

    public String getIndBusiAuth() {
        return indBusiAuth;
    }

    public void setIndBusiAuth(String indBusiAuth) {
        this.indBusiAuth = indBusiAuth;
    }

    public Long getFollowMerchantId() {
        return followMerchantId;
    }

    public void setFollowMerchantId(Long followMerchantId) {
        this.followMerchantId = followMerchantId;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getAroudName() {
        return aroudName;
    }

    public void setAroudName(String aroudName) {
        this.aroudName = aroudName;
    }

    public String getCommLocalProvName() {
        return commLocalProvName;
    }

    public void setCommLocalProvName(String commLocalProvName) {
        this.commLocalProvName = commLocalProvName;
    }

    public String getCommLocalCityName() {
        return commLocalCityName;
    }

    public void setCommLocalCityName(String commLocalCityName) {
        this.commLocalCityName = commLocalCityName;
    }

    public String getCommLocalCouName() {
        return commLocalCouName;
    }

    public void setCommLocalCouName(String commLocalCouName) {
        this.commLocalCouName = commLocalCouName;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public List<LevelSqecQuatePriceVo> getCommLevelPo() {
        return commLevelPo;
    }

    public void setCommLevelPo(List<LevelSqecQuatePriceVo> commLevelPo) {
        this.commLevelPo = commLevelPo;
    }

    public String getSerSupportType() {
        return serSupportType;
    }

    public void setSerSupportType(String serSupportType) {
        this.serSupportType = serSupportType;
    }

    public List<CommAttriInfoVo> getCommAttri() {
        return commAttri;
    }

    public void setCommAttri(List<CommAttriInfoVo> commAttri) {
        this.commAttri = commAttri;
    }

    public BrandMageInfoVo getBrandMage() {
        return brandMage;
    }

    public void setBrandMage(BrandMageInfoVo brandMage) {
        this.brandMage = brandMage;
    }

    public StallsMageInfoVo getStallsMageInfoVo() {
        return stallsMageInfoVo;
    }

    public void setStallsMageInfoVo(StallsMageInfoVo stallsMageInfoVo) {
        this.stallsMageInfoVo = stallsMageInfoVo;
    }

    public List<CommPictureInfoVo> getCommPicture() {
        return commPicture;
    }

    public void setCommPicture(List<CommPictureInfoVo> commPicture) {
        this.commPicture = commPicture;
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

    public String getStartOrdExpres() {
        return startOrdExpres;
    }

    public void setStartOrdExpres(String startOrdExpres) {
        this.startOrdExpres = startOrdExpres;
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }

    public String[] getSupportTypeNameContant() {
        return supportTypeNameContant;
    }

    public void setSupportTypeNameContant(String[] supportTypeNameContant) {
        this.supportTypeNameContant = supportTypeNameContant;
    }
}
