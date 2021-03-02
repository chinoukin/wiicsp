package com.wisea.cultivar.plant.po.oritrapla;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 检测记录关系Po
 */
@ApiModel("检测记录关系Po查询列表")
public class ExamRecdRelaKeyVo {

	@ApiModelProperty("检测记录id")
    private Long id;
    @ApiModelProperty("我的档案id")
    private Long mineArchId;
    @ApiModelProperty("会员id")
    private Long membId;
    @ApiModelProperty("查询标识（0，查询列表时传入，1查询关系id的时候传）")
    private String flag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMineArchId() {
        return mineArchId;
    }

    public void setMineArchId(Long mineArchId) {
        this.mineArchId = mineArchId;
    }

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
