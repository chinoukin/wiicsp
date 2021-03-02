package com.wisea.cultivar.common.vo.tp.lta;

import com.wisea.cloud.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页查询卖家长期协议列表VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月7日
 * @version 1.0
 */
@ApiModel("分页查询卖家长期协议列表VO")
public class LtaContInfoPageVo {

	@ApiModelProperty(value="全部合同")
	private int allCount;

	@ApiModelProperty(value="待确认")
	private int toBeConCount;

	@ApiModelProperty(value="合同生效")
	private int effecCount;

	@ApiModelProperty(value="合同到期")
	private int matureCount;

	@ApiModelProperty(value="合同终止")
	private int endCount;

	@ApiModelProperty(value="已取消")
	private int cancelCount;

	@ApiModelProperty(value="强制解除")
	private int removeCount;

	@ApiModelProperty(value="分页列表数据")
	private Page<LtaContInfoListVo> pageList;

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	public int getToBeConCount() {
		return toBeConCount;
	}

	public void setToBeConCount(int toBeConCount) {
		this.toBeConCount = toBeConCount;
	}

	public int getEffecCount() {
		return effecCount;
	}

	public void setEffecCount(int effecCount) {
		this.effecCount = effecCount;
	}

	public int getMatureCount() {
		return matureCount;
	}

	public void setMatureCount(int matureCount) {
		this.matureCount = matureCount;
	}

	public int getEndCount() {
		return endCount;
	}

	public void setEndCount(int endCount) {
		this.endCount = endCount;
	}

	public int getCancelCount() {
		return cancelCount;
	}

	public void setCancelCount(int cancelCount) {
		this.cancelCount = cancelCount;
	}

	public int getRemoveCount() {
		return removeCount;
	}

	public void setRemoveCount(int removeCount) {
		this.removeCount = removeCount;
	}

	public Page<LtaContInfoListVo> getPageList() {
		return pageList;
	}

	public void setPageList(Page<LtaContInfoListVo> pageList) {
		this.pageList = pageList;
	}
}
