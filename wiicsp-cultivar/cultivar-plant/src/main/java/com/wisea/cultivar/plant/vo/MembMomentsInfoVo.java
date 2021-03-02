package com.wisea.cultivar.plant.vo;

import com.wisea.cultivar.plant.entity.MembMomentsPicture;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.List;

@ApiModel("MembMoments详细信息Vo")
public class MembMomentsInfoVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="内容")
    private String content;

    @ApiModelProperty(value="发布时间")
    private OffsetDateTime pubDate;

    @ApiModelProperty(value="位置名称")
    private String positionName;

    @ApiModelProperty(value="经度")
    private Double jd;

    @ApiModelProperty(value="纬度")
    private Double wd;

    @ApiModelProperty(value="种植服务会员信息")
    private ZhfwMembInfoInfoVo zhfwMembInfoInfoVo;

    @ApiModelProperty(value="圈子图片")
    private List<MembMomentsPicture> membMomentsPictureList;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public OffsetDateTime getPubDate() {
        return pubDate;
    }

    public void setPubDate(OffsetDateTime pubDate) {
        this.pubDate = pubDate;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Double getJd() {
        return jd;
    }

    public void setJd(Double jd) {
        this.jd = jd;
    }

    public Double getWd() {
        return wd;
    }

    public void setWd(Double wd) {
        this.wd = wd;
    }

    public ZhfwMembInfoInfoVo getZhfwMembInfoInfoVo() {
        return zhfwMembInfoInfoVo;
    }

    public void setZhfwMembInfoInfoVo(ZhfwMembInfoInfoVo zhfwMembInfoInfoVo) {
        this.zhfwMembInfoInfoVo = zhfwMembInfoInfoVo;
    }

    public List<MembMomentsPicture> getMembMomentsPictureList() {
        return membMomentsPictureList;
    }

    public void setMembMomentsPictureList(List<MembMomentsPicture> membMomentsPictureList) {
        this.membMomentsPictureList = membMomentsPictureList;
    }
}
