package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 平台公告Po
 * @author: wangs
 * @date :2018/6/5
 */
@ApiModel("平台公告Po")
public class PlatfNoticePo {

    /**
     * 公告id
     */
    @ApiModelProperty(value="id")
    @Check(test = "required")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
