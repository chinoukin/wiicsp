package com.wisea.cultivar.common.vo.tp.origin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className StatisticByBreedPenVo
 * @date 2019/3/25 11:26
 * @Description 养殖场各养殖栏统计
 */
@ApiModel("养殖场各养殖栏统计")
public class StatisticByBreedPenVo {
    @ApiModelProperty("栏号")
    private String breedPenName;
    @ApiModelProperty("在栏牦牛数量")
    private Integer breedPenYakCount;

    public String getBreedPenName() {
        return breedPenName;
    }

    public void setBreedPenName(String breedPenName) {
        this.breedPenName = breedPenName;
    }

    public Integer getBreedPenYakCount() {
        return breedPenYakCount;
    }

    public void setBreedPenYakCount(Integer breedPenYakCount) {
        this.breedPenYakCount = breedPenYakCount;
    }
}
