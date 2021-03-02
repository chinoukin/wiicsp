package com.wisea.cultivar.common.po.tp.portal;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 首页查询资讯信息的处理PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月29日
 * @version 1.0
 */
@ApiModel("首页查询资讯信息的处理PO")
public class InfomaMagNotAuthPo {

	@ApiModelProperty(value="查询的条数")
	private Integer count;

	@ApiModelProperty(value="所属分类(0:平台公告1:行业资讯2:果链动态3:价格行情)")
	private List<String> informationTypes;

	@ApiModelProperty(value="0:门户网站首页1:交易系统首页(其他情况必须为空,如果传1或者2首先会去缓存中的内容，有可能与所属分类不符合,请慎重传值)")
	private String localType;

	@ApiModelProperty(value="不包含的Id")
	private Long removeId;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<String> getInformationTypes() {
		return informationTypes;
	}

	public void setInformationTypes(List<String> informationTypes) {
		this.informationTypes = informationTypes;
	}

	public Long getRemoveId() {
		return removeId;
	}

	public void setRemoveId(Long removeId) {
		this.removeId = removeId;
	}

	public String getLocalType() {
		return localType;
	}

	public void setLocalType(String localType) {
		this.localType = localType;
	}
}
