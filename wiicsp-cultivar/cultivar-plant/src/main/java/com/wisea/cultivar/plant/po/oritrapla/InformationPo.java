package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 系统消息传入Po
 * @author: wangs
 * @date :2018/6/6
 */
@ApiModel("系统消息传入Po")
public class InformationPo {

    /**
     * 消息id
     */
    @ApiModelProperty("消息id")
    @Check(test = "required", requiredMsg = "消息id不能为空")
    private Long informationId;

    /**
     * 档案id
     */
    @ApiModelProperty("档案id")
    @Check(test = "required", requiredMsg = "我的档案id不能为空")
    private Long mineArchId;


    public Long getMineArchId() {
        return mineArchId;
    }

    public void setMineArchId(Long mineArchId) {
        this.mineArchId = mineArchId;
    }

    public Long getInformationId() {
        return informationId;
    }

    public void setInformationId(Long informationId) {
        this.informationId = informationId;
    }
}
