package com.wisea.cultivar.plant.vo.oritrapla;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019/8/28 11:33 上午
 */
public class MonitrAndPadVo {

    @ApiModelProperty("病虫害列表")
    private List<PadMageListVo> pads;

//    @ApiModelProperty("图表数据")
//    private List<MonitrLive> monitrLives;

    public List<PadMageListVo> getPads() {
        return pads;
    }

    public void setPads(List<PadMageListVo> pads) {
        this.pads = pads;
    }

    /*public List<MonitrLive> getMonitrLives() {
        return monitrLives;
    }

    public void setMonitrLives(List<MonitrLive> monitrLives) {
        this.monitrLives = monitrLives;
    }*/
}
