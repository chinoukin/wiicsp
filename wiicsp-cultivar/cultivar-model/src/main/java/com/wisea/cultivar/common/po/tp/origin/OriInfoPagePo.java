package com.wisea.cultivar.common.po.tp.origin;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.origin.OriInfoPageVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className OriYakInfoPagePo
 * @date 2019/3/22 18:05
 * @Description 分页查询牦牛档案列表PO
 */
@ApiModel("分页查询牦牛档案列表PO")
public class OriInfoPagePo extends PagePo<OriInfoPageVo> {
    @ApiModelProperty("查询框输入内容")
    private String query;
    @ApiModelProperty("查询类型：0 按牦牛显示、1 按养殖批次显示、2 按养殖场显示")
    @Check(test = {"required", "liveable"}, liveable = {"0", "1", "2"}, liveableMsg = "查询类型只能是0、1、2")
    private String queryFlag;
    @ApiModelProperty("批次ID，queryFlag=1时非空")
    @Check(test = "logic", logic = "'1'.equals(#queryFlag)?#isNotEmpty(#batchId):true", logicMsg = "批次ID【batchId】不能为空")
    private Long batchId;
    @ApiModelProperty("养殖场ID，queryFlag=2时非空")
    @Check(test = "logic", logic = "'2'.equals(#queryFlag)?#isNotEmpty(#farmId):true", logicMsg = "养殖场ID【farmId】不能为空")
    private Long farmId;

    @ApiModelProperty(value = "当前登录会员ID", hidden = true)
    private Long memberId;
    @ApiModelProperty(value = "牦牛状态，后台使用", hidden = true)
    private String yakType;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQueryFlag() {
        return queryFlag;
    }

    public void setQueryFlag(String queryFlag) {
        this.queryFlag = queryFlag;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getYakType() {
        return yakType;
    }

    public void setYakType(String yakType) {
        this.yakType = yakType;
    }
}
