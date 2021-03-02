package com.wisea.cultivar.common.po.tp.portal;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.portal.ZxListMageListVo;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 资讯列表管理分页查询操作PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月31日
 * @version 1.0
 */
@ApiModel("资讯列表管理分页查询操作PO")
public class ZxListMagePagePo extends PagePo<ZxListMageListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * 标题或关键词
     */
    @ApiModelProperty(value = "标题或关键词")
    private String searchKey;

    /**
     * 所属分类
     */
    @ApiModelProperty(value = "所属分类(zx_catg_type 0:布依文化1:生态旅游2:糯米蕉产业资讯)")
    private String zxCatgType;

    /**
     * 是否显示
     */
    @ApiModelProperty(value = "是否显示(if_requ 0:是1:否)")
    private String ifRequ;

    /**
     * 发布时间 -开始时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发布时间-开始时间")
    private OffsetDateTime pubDateStart;
    /**
     * 发布时间-结束时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发布时间-结束时间")
    private OffsetDateTime pubDateEnd;

    @ApiModelProperty(value="为空查询所有的信息，不为空查询推荐以外的信息",hidden=true)
    public String notAlreadyTj;
    @ApiModelProperty(value="查询数量",hidden=true)
    private Integer num;

	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getZxCatgType() {
		return zxCatgType;
	}
	public void setZxCatgType(String zxCatgType) {
		this.zxCatgType = zxCatgType;
	}
	public OffsetDateTime getPubDateStart() {
		return pubDateStart;
	}
	public void setPubDateStart(OffsetDateTime pubDateStart) {
		this.pubDateStart = pubDateStart;
	}
	public OffsetDateTime getPubDateEnd() {
		return pubDateEnd;
	}
	public void setPubDateEnd(OffsetDateTime pubDateEnd) {
		this.pubDateEnd = pubDateEnd;
	}
	public String getNotAlreadyTj() {
		return notAlreadyTj;
	}
	public void setNotAlreadyTj(String notAlreadyTj) {
		this.notAlreadyTj = notAlreadyTj;
	}
	public String getIfRequ() {
		return ifRequ;
	}
	public void setIfRequ(String ifRequ) {
		this.ifRequ = ifRequ;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
}
