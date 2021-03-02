package com.wisea.cultivar.common.vo.tp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/**
 * @Description: 品类,品种参数封装
 * @author: wangs
 * @date :2019/8/21
 */
@ApiModel("品类,品种返回信息")
public class CommMageVariteResultVo {

    @ApiModelProperty("品类信息")
    private Map<String, Object> commMage;

    @ApiModelProperty("品种信息")
    private Map<String, Object> commVarietMage;

    public Map<String, Object> getCommMage() {
        return commMage;
    }

    public void setCommMage(Map<String, Object> commMage) {
        this.commMage = commMage;
    }

    public Map<String, Object> getCommVarietMage() {
        return commVarietMage;
    }

    public void setCommVarietMage(Map<String, Object> commVarietMage) {
        this.commVarietMage = commVarietMage;
    }
}
