package com.wisea.transac.common.vo.product;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description:
 * @author: wangs
 * @date :2020/6/10
 */
public class CommListStaffVo {

    @ApiModelProperty("商品信息")
    private List<CommPubInfoListVo> commPubInfoListVos;
    @ApiModelProperty("分类设置列表")
    private List<CommSalesSetVo> commSalesSetVos;

    public List<CommPubInfoListVo> getCommPubInfoListVos() {
        return commPubInfoListVos;
    }

    public void setCommPubInfoListVos(List<CommPubInfoListVo> commPubInfoListVos) {
        this.commPubInfoListVos = commPubInfoListVos;
    }

    public List<CommSalesSetVo> getCommSalesSetVos() {
        return commSalesSetVos;
    }

    public void setCommSalesSetVos(List<CommSalesSetVo> commSalesSetVos) {
        this.commSalesSetVos = commSalesSetVos;
    }
}
