package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * HelpListMageGetTitlePo
 * 2018/10/29 15:34:52
 */
public class HelpListMageGetTitlePo {
    /**
     * title
     */
    @ApiModelProperty(value="标题")
    @Check(test = "required")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
