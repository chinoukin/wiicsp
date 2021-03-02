package com.wisea.cultivar.common.po.tp.product;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.product.MrSerChargeMageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2019/5/15
 */
@ApiModel("默认服务费列表搜索参数")
public class MrSerChargeMagePagePo extends PagePo<MrSerChargeMageListVo> {

    /**
     * 交易模式
     */
    @ApiModelProperty("交易模式")
    private String transModeType;
    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id")
    private Long commId;

    public String getTransModeType() {
        return transModeType;
    }

    public void setTransModeType(String transModeType) {
        this.transModeType = transModeType;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }
}
