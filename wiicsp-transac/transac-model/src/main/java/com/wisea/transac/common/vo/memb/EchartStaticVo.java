package com.wisea.transac.common.vo.memb;

import io.swagger.annotations.ApiModel;

/**
 * Echart统计用VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月3日
 * @version 1.0
 */
@ApiModel("Echart统计用VO")
public class EchartStaticVo {

	private String index;
	private int num;
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
