package com.wisea.cultivar.common.vo.tp.origin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className StatisticByYakVo
 * @date 2019/3/25 9:43
 * @Description 根据牦牛统计VO
 */
@ApiModel("根据牦牛统计VO")
public class StatisticByYakVo {
    @ApiModelProperty("在栏数量")
    private Integer zlCount;
    @ApiModelProperty("小于五岁的牦牛数量")
    private Integer beforeFiveAgeCount;
    @ApiModelProperty("五岁以上的牦牛数量")
    private Integer afterFiveAgeCount;
    @ApiModelProperty("公牛数量")
    private Integer bullCount;
    @ApiModelProperty("母牛数量")
    private Integer cowCount;

    public Integer getZlCount() {
        return zlCount;
    }

    public void setZlCount(Integer zlCount) {
        this.zlCount = zlCount;
    }

    public Integer getBeforeFiveAgeCount() {
        return beforeFiveAgeCount;
    }

    public void setBeforeFiveAgeCount(Integer beforeFiveAgeCount) {
        this.beforeFiveAgeCount = beforeFiveAgeCount;
    }

    public Integer getAfterFiveAgeCount() {
        return afterFiveAgeCount;
    }

    public void setAfterFiveAgeCount(Integer afterFiveAgeCount) {
        this.afterFiveAgeCount = afterFiveAgeCount;
    }

    public Integer getBullCount() {
        return bullCount;
    }

    public void setBullCount(Integer bullCount) {
        this.bullCount = bullCount;
    }

    public Integer getCowCount() {
        return cowCount;
    }

    public void setCowCount(Integer cowCount) {
        this.cowCount = cowCount;
    }
}
