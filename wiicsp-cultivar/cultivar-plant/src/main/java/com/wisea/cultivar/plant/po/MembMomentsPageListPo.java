package com.wisea.cultivar.plant.po;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.MembMomentsPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

@ApiModel("分页查询MembMomentsPo")
public class MembMomentsPageListPo extends PagePo<MembMomentsPageListVo> {
    @ApiModelProperty(value="会员id")
    @Check(test = "required")
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

    @ApiModelProperty(value="搜索条件-会员类型;所有(NULL) ，服务商(0)，种植户(1)，采购商(2)，我关注的圈子(3)")
    private String membType;

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

    public String getMembType() {
        return membType;
    }

    public void setMembType(String membType) {
        this.membType = membType;
    }
}
