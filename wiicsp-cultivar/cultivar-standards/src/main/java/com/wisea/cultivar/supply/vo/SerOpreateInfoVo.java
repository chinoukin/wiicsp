package com.wisea.cultivar.supply.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author chengq
 * @date 2020/8/16 18:22
 */
public class SerOpreateInfoVo {

    @ApiModelProperty("服务单编号")
    private String serListNo;

    private List<SerOpreateListVo> opreates;

    public String getSerListNo() {
        return serListNo;
    }

    public void setSerListNo(String serListNo) {
        this.serListNo = serListNo;
    }

    public List<SerOpreateListVo> getOpreates() {
        return opreates;
    }

    public void setOpreates(List<SerOpreateListVo> opreates) {
        this.opreates = opreates;
    }
}
