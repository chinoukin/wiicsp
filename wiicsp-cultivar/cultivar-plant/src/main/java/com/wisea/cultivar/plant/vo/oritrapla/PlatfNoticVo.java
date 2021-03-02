package com.wisea.cultivar.plant.vo.oritrapla;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2018/6/5
 */
public class PlatfNoticVo {

    /**
     * 标题
     */
    @ApiModelProperty(value="标题")
    private String title;
    /**
     * 摘要
     */
    @ApiModelProperty(value="摘要")
    private String tabloid;
    /**
     * 内容
     */
    @ApiModelProperty(value="内容")
    private String content;
}
