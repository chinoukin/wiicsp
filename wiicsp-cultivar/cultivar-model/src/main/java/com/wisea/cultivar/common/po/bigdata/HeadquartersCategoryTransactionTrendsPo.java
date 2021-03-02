package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className HeadquartersCategoryTransactionTrendsPo
 * @date 2019/12/6 14:32
 * @Description 国内/国外品类交易走势分析
 */
@ApiModel(value = "国内/国外品类交易走势分析Po")
public class HeadquartersCategoryTransactionTrendsPo {
    @Check(test = {"required"})
    @ApiModelProperty("品类ID")
    private Long categoryId;
    @ApiModelProperty("国内外类型：0 国内、1 国外")
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "国内外类型有效值为：0、1")
    private String homeAbroadType;
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "显示类型有效值为：0、1")
    @ApiModelProperty("显示类型：0 按年显示、1 按月显示")
    private String showType;
    @ApiModelProperty("年份")
    @Check(test = {"required"})
    private String year;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getHomeAbroadType() {
        return homeAbroadType;
    }

    public void setHomeAbroadType(String homeAbroadType) {
        this.homeAbroadType = homeAbroadType;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
