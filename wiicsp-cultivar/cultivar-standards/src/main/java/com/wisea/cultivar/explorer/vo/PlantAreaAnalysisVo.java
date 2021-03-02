package com.wisea.cultivar.explorer.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className PlantAreaAnalysisVo
 * @date 2020/9/3 17:14
 * @Description
 */
public class PlantAreaAnalysisVo {
    @ApiModelProperty("100亩一下")
    private Integer level0;
    @ApiModelProperty("100-150亩")
    private Integer level1;
    @ApiModelProperty("150-200亩")
    private Integer level2;
    @ApiModelProperty("200-250亩")
    private Integer level3;
    @ApiModelProperty("250-300亩")
    private Integer level4;
    @ApiModelProperty("300-500亩")
    private Integer level5;
    @ApiModelProperty("500亩以上")
    private Integer level6;

    public Integer getLevel0() {
        return level0;
    }

    public void setLevel0(Integer level0) {
        this.level0 = level0;
    }

    public Integer getLevel1() {
        return level1;
    }

    public void setLevel1(Integer level1) {
        this.level1 = level1;
    }

    public Integer getLevel2() {
        return level2;
    }

    public void setLevel2(Integer level2) {
        this.level2 = level2;
    }

    public Integer getLevel3() {
        return level3;
    }

    public void setLevel3(Integer level3) {
        this.level3 = level3;
    }

    public Integer getLevel4() {
        return level4;
    }

    public void setLevel4(Integer level4) {
        this.level4 = level4;
    }

    public Integer getLevel5() {
        return level5;
    }

    public void setLevel5(Integer level5) {
        this.level5 = level5;
    }

    public Integer getLevel6() {
        return level6;
    }

    public void setLevel6(Integer level6) {
        this.level6 = level6;
    }
}
