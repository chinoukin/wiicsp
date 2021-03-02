package com.wisea.cultivar.seedlings.vo;


import com.wisea.cultivar.common.vo.trade.EntpAuthInfoVo;
import com.wisea.cultivar.explorer.vo.OilTeaVarietMageGetVo;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * SproutCatalogMageGetVo
 * 2020/08/06 14:19:24
 */
public class SproutMageGetVo {

    @ApiModelProperty(value = "种苗信息")
    private OilTeaVarietMageGetVo oilTeaVarietMageGetVos;

    @ApiModelProperty(value = "采购企业")
    private List<EntpAuthInfoVo> entpAuthInfoVos;

    @ApiModelProperty(value = "种植户")
    private List<BuySproutIndividualInfoListVo> individuals;


    public OilTeaVarietMageGetVo getOilTeaVarietMageGetVos() {
        return oilTeaVarietMageGetVos;
    }

    public void setOilTeaVarietMageGetVos(OilTeaVarietMageGetVo oilTeaVarietMageGetVos) {
        this.oilTeaVarietMageGetVos = oilTeaVarietMageGetVos;
    }

    public List<EntpAuthInfoVo> getEntpAuthInfoVos() {
        return entpAuthInfoVos;
    }

    public void setEntpAuthInfoVos(List<EntpAuthInfoVo> entpAuthInfoVos) {
        this.entpAuthInfoVos = entpAuthInfoVos;
    }

    public List<BuySproutIndividualInfoListVo> getIndividuals() {
        return individuals;
    }

    public void setIndividuals(List<BuySproutIndividualInfoListVo> individuals) {
        this.individuals = individuals;
    }
}
