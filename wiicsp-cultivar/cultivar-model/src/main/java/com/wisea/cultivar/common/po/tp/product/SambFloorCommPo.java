package com.wisea.cultivar.common.po.tp.product;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.product.SambFloorCommListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 根据楼层id查询 品类品种
 * @author: wangs
 * @date :2019/5/29
 */
@ApiModel("根据楼层id查询 品类品种列表")
public class SambFloorCommPo extends PagePo<SambFloorCommListVo> {

    @ApiModelProperty("中小零批的楼层id")
    @Check(test = "required", requiredMsg = "楼层id不能为空")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
