package com.wisea.cultivar.common.po.tp.lta;

import com.wisea.cultivar.common.po.tp.LongIdPo;
import com.wisea.cultivar.common.po.tp.trade.UpdateOrdCommRelaPo;
import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className LtaConfirmOrderPo
 * @date 2019/5/8 17:00
 * @Description 确认订单PO
 */
@ApiModel("确认订单PO")
public class LtaConfirmOrderPo extends LongIdPo {
     @ApiModelProperty("订单商品列表")
     private List<UpdateOrdCommRelaPo> ordCommRelas;
     @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
     @ApiModelProperty("订单运费")
     private Double freight;
     @ApiModelProperty("是否保存，true 保存、 false 计算价格")
     private Boolean saveFlag;

     public List<UpdateOrdCommRelaPo> getOrdCommRelas() {
          return ordCommRelas;
     }

     public void setOrdCommRelas(List<UpdateOrdCommRelaPo> ordCommRelas) {
          this.ordCommRelas = ordCommRelas;
     }

     public Double getFreight() {
          return freight;
     }

     public void setFreight(Double freight) {
          this.freight = freight;
     }

     public Boolean getSaveFlag() {
          return saveFlag;
     }

     public void setSaveFlag(Boolean saveFlag) {
          this.saveFlag = saveFlag;
     }
}
