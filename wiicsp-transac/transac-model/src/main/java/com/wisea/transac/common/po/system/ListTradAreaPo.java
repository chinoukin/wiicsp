package com.wisea.transac.common.po.system;

import com.wisea.transac.common.po.TradAreaMagePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author wangjiahao
 * @since 2020/5/8 10:13 上午
 */
@ApiModel("交易区集合Po")
public class ListTradAreaPo {
    @ApiModelProperty("交易区集合")
    List<TradAreaMagePo> tradAreaMagePos;

    public List<TradAreaMagePo> getTradAreaMagePos() {
        return tradAreaMagePos;
    }

    public void setTradAreaMagePos(List<TradAreaMagePo> tradAreaMagePos) {
        this.tradAreaMagePos = tradAreaMagePos;
    }
}
