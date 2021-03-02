package com.wisea.transac.common.vo.memb;

import io.swagger.annotations.ApiModelProperty;

/**
 * 批发市场全部列表
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月27日
 * @version 1.0
 */
public class MaketInfoListVo {

	@ApiModelProperty(value="市场ID")
	private Long id;
	@ApiModelProperty(value="市场名称")
	private String marketName;
	@ApiModelProperty(value="市场图片")
	private String marketPic;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarketName() {
		return marketName;
	}
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	public String getMarketPic() {
		return marketPic;
	}
	public void setMarketPic(String marketPic) {
		this.marketPic = marketPic;
	}
}
