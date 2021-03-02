package com.wisea.transac.common.vo.seller;


import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("人脸核身Vo")
public class H5FaceVo extends DataLongEntity<H5FaceVo> {

    @ApiModelProperty("请添加小助手微信 faceid001，进行线下对接获取")
    private String webankAppld;
    @ApiModelProperty("接口版本号，默认参数值：1.0.0")
    private String version;
    @ApiModelProperty("随机数：32位随机串（字母+数字组成的随机数）")
    private String nonce;
    @ApiModelProperty("订单号，由合作方上送，每次唯一，此信息为本次人脸核身上送的信息，不能超过32位")
    private String orderNo;
    @ApiModelProperty("h5/geth5faceid 接口返回的唯一标识")
    private String h5faceld;
    @ApiModelProperty("H5 人脸核身完成后回调的第三方 URL，需要第三方提供完整 URL 且做 URL Encode")
    private String url;
    @ApiModelProperty("是否显示结果页面\n" +
            "参数值为“1”：直接跳转到 url 回调地址\n" +
            "null 或其他值：跳转提供的结果页面")
    private String resultType;
    @ApiModelProperty("用户 ID，用户的唯一标识（不要带有特殊字符")
    private String userld;
    @ApiModelProperty("签名：使用上文 生成的签名")
    private String sign;
    @ApiModelProperty("\t\n" +
            "browser：表示在浏览器启动刷脸\n" +
            "App：表示在 App 里启动刷脸，默认值为 App")
    private String from;
    @ApiModelProperty("跳转模式，参数值为“1”时，刷脸页面使用 replace 方式跳转，不在浏览器 history 中留下记录；不传或其他值则正常跳转")
    private String redirectType;

    @ApiModelProperty("合作伙伴服务端缓存的 tikcet，注意是 NONCE 类型")
    private String ticket;

    @ApiModelProperty("token")
    private String token;

    @ApiModelProperty(value="姓名",hidden = true)
    private String name;

    @ApiModelProperty(value="身份证号",hidden = true)
    private String idNo;

    @ApiModelProperty(value="人脸采集图片",hidden = true)
    private String faceCollection;

    @ApiModelProperty(value="验证是否通过（0：失败 ，1：成功 ,3 认证中）")
    private String byType;

    @ApiModelProperty(value="请求 URL")
    private String jumpUrl;

    @ApiModelProperty(value="license")
    private String license;
    @ApiModelProperty(value="signTicket")
    private String signTicket;

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }


    public String getWebankAppld() {
        return webankAppld;
    }

    public void setWebankAppld(String webankAppld) {
        this.webankAppld = webankAppld;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getH5faceld() {
        return h5faceld;
    }

    public void setH5faceld(String h5faceld) {
        this.h5faceld = h5faceld;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getUserld() {
        return userld;
    }

    public void setUserld(String userld) {
        this.userld = userld;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getRedirectType() {
        return redirectType;
    }

    public void setRedirectType(String redirectType) {
        this.redirectType = redirectType;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getByType() {
        return byType;
    }

    public void setByType(String byType) {
        this.byType = byType;
    }

    public String getFaceCollection() {
        return faceCollection;
    }

    public void setFaceCollection(String faceCollection) {
        this.faceCollection = faceCollection;
    }

    public String getSignTicket() {
        return signTicket;
    }

    public void setSignTicket(String signTicket) {
        this.signTicket = signTicket;
    }
}
