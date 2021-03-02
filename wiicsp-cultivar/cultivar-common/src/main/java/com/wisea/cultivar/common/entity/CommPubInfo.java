package com.wisea.cultivar.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModelProperty;

public class CommPubInfo extends DataLongEntity<CommPubInfo> {
    /**
     * 商品编号
     */
    private String commNum;

    /**
     * 会员id（商家）
     */
    private Long membId;

    /**
     * 销售员工id
     */
    private Long saleStaffId;

    /**
     * 档口id
     */
    private Long stallsMageId;

    /**
     * 品类id
     */
    private Long commId;

    /**
     * 商品标题
     */
    private String commTitle;

    /**
     * 商品品种id
     */
    private Long commVarietId;

    /**
     * 商品品牌id
     */
    private Long brandMageId;

    /**
     * 产地类型
     */
    private String originPlaceType;

    /**
     * 国外产地id
     */
    private Long abroadId;

    /**
     * 商品产地省
     */
    private String commLocalProv;

    /**
     * 商品产地市
     */
    private String commLocalCity;

    /**
     * 商品产地区县
     */
    private String commLocalCou;

    /**
     * 商品描述
     */
    private String commSignature;

    /**
     * 推荐语
     */
    private String recommend;

    /**
     * 购买须知
     */
    private String notesToBuy;

    /**
     * 主商品价格表达式
     */
    private String startOrdExpres;

    /**
     * 商品发布状态
     */
    private String commStateType;

    /**
     * 驳回原因（审核意见）
     */
    private String rejectReason;

    /**
     * 审核人id(后台管理员id)
     */
    private Long examId;

    /**
     * 商品销售分类配置id
     */
    private Long commSaleSetId;

    /**
     * 版本号
     */
    private String versionNum;

    /**
     * 服务支持
     */
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

    public Long getCommSaleSetId() {
        return commSaleSetId;
    }

    public void setCommSaleSetId(Long commSaleSetId) {
        this.commSaleSetId = commSaleSetId;
    }

    public String getSerSupportType() {
        return serSupportType;
    }

    public void setSerSupportType(String serSupportType) {
        this.serSupportType = serSupportType;
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

    public String getStartOrdExpres() {
        return startOrdExpres;
    }

    public void setStartOrdExpres(String startOrdExpres) {
        this.startOrdExpres = startOrdExpres;
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

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }
}
