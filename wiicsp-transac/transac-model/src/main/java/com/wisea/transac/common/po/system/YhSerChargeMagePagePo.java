package com.wisea.transac.common.po.system;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.system.YhSerChargeMageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 优惠服务费类表传入参数
 * @author: wangs
 * @date :2019/5/17
 */
@ApiModel("优惠服务费类表传入参数")
public class YhSerChargeMagePagePo extends PagePo<YhSerChargeMageListVo> {

	private static final long serialVersionUID = -3603498413900955635L;

	@ApiModelProperty("商品id")
    private Long commId;

    @ApiModelProperty("交易模式,字典值;0:大宗交易;1,中小零批;2,长期合同;多个以逗号分隔")
    private String transModeType;

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getTransModeType() {
        return transModeType;
    }

    public void setTransModeType(String transModeType) {
        this.transModeType = transModeType;
    }
}
