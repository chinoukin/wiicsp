package com.wisea.cultivar.common.po.tp.product;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.product.GpPjResultVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 评价结果列表查询传入参数
 * @author: wangs
 * @date :2019/6/6
 */
@ApiModel("评价结果列表查询传入参数")
public class GpPjResultMagePo extends PagePo<GpPjResultVo> {

    /**
     * 商品id
     */
    @ApiModelProperty("品类id")
    private Long commId;

    /**
     * 商品品种id
     */
    @ApiModelProperty("品种id")
    private Long commVarietId;

    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    private String StratTime;

    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    private String endTime;

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    public String getStratTime() {
        return StratTime;
    }

    public void setStratTime(String stratTime) {
        StratTime = stratTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
