package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className HeadquartersTransactionRankingPo
 * @date 2019/12/6 10:39
 * @Description 总部国内/国外单品交易排行Po
 */
@ApiModel(value = "总部国内/国外单品交易排行Po")
public class HeadquartersTransactionRankingPo {
    @ApiModelProperty("国内外类型：0 国内、1 国外")
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "国内外类型有效值为：0、1")
    private String homeAbroadType;
    @ApiModelProperty("年份")
    @Check(test = "required")
    private String year;

    public String getHomeAbroadType() {
        return homeAbroadType;
    }

    public void setHomeAbroadType(String homeAbroadType) {
        this.homeAbroadType = homeAbroadType;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
