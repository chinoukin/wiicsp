package com.wisea.cultivar.common.vo.tp.origin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className StatisticByFarmVo
 * @date 2019/3/25 11:20
 * @Description 按养殖场统计Vo
 */
@ApiModel("按养殖场统计Vo")
public class StatisticByFarmVo {
    @ApiModelProperty("养殖场ID")
    private Long farmId;
    @ApiModelProperty("养殖场名称")
    private String farmName;
    @ApiModelProperty("在栏总数量")
    private Integer zlCount;
    @ApiModelProperty("小于五岁的牦牛数量")
    private Integer beforeFiveAgeCount;
    @ApiModelProperty("五岁以上的牦牛数量")
    private Integer afterFiveAgeCount;
    @ApiModelProperty("公牛数量")
    private Integer bullCount;
    @ApiModelProperty("母牛数量")
    private Integer cowCount;
    @ApiModelProperty("养殖场各养殖栏统计")
    private List<StatisticByBreedPenVo> breedPenVos;

    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

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

    public List<StatisticByBreedPenVo> getBreedPenVos() {
        return breedPenVos;
    }

    public void setBreedPenVos(List<StatisticByBreedPenVo> breedPenVos) {
        this.breedPenVos = breedPenVos;
    }
}
