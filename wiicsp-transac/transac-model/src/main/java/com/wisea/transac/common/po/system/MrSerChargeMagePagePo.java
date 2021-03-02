package com.wisea.transac.common.po.system;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.system.MrSerChargeMageListVo;
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
     * 商品id
     */
    @ApiModelProperty(value = "商品id")
    private Long commId;

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }
}
