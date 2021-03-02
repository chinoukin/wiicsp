package com.wisea.cultivar.common.po.product;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2019/12/24
 */
@ApiModel("shenhe审核信息传入参数")
public class CommPubExamPo {


    @ApiModelProperty("发布商品id")
    @Check(test = "required", requiredMsg = "发布商品id不能为空")
    private Long id;

    @ApiModelProperty("审核 or 驳回 ;审核通过 传0; 驳回(强制下架) 传 4")
    @Check(test = "required", requiredMsg = "商品状态不能为空")
    private String commStateType;

    @ApiModelProperty("审核意见")
    @Check(test = "logic", logic = "'5'.equals(#commStateType)?#isNotEmpty(#examYj):true", logicMsg = "审核意见不能为空")
    private String examYj;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }

    public String getExamYj() {
        return examYj;
    }

    public void setExamYj(String examYj) {
        this.examYj = examYj;
    }
}
