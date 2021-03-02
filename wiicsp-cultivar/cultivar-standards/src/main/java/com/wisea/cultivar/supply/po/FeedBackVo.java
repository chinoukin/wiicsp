package com.wisea.cultivar.supply.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * 意见反馈
 * @author chengq
 * @date 2020/8/28 13:57
 */
public class FeedBackVo {

    /**
     * 反馈内容
     */
    @Check(test = "required", requiredMsg = "反馈内容不能为空")
    @ApiModelProperty("反馈内容")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
