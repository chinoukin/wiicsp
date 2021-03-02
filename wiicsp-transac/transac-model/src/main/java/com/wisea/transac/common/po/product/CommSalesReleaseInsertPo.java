package com.wisea.transac.common.po.product;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.transac.common.po.CommMagePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description: 关联基础品类 - 添加操作
 * @author: wangs
 * @date :2020/5/6
 */
@ApiModel("关联基础品类 - 添加操作")
public class CommSalesReleaseInsertPo {

    /**
     * 销售分类id
     */
    @Check(test = "required", requiredMsg = "销售分类ID不能为空")
    @ApiModelProperty("销售分类ID")
    private Long commSalesCatgId;

    /**
     * 基础品类的集合
     */
    @ApiModelProperty("勾选基础品类的集合包括(名称,id,顺序)")
    @Check(test = "required", requiredMsg = "勾选基础品类的集合不能为空")
    private List<CommMagePo> commMagePoList;

    public Long getCommSalesCatgId() {
        return commSalesCatgId;
    }

    public void setCommSalesCatgId(Long commSalesCatgId) {
        this.commSalesCatgId = commSalesCatgId;
    }

    public List<CommMagePo> getCommMagePoList() {
        return commMagePoList;
    }

    public void setCommMagePoList(List<CommMagePo> commMagePoList) {
        this.commMagePoList = commMagePoList;
    }
}
