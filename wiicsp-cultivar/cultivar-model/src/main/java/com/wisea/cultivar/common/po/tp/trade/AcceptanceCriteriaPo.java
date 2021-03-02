package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cultivar.common.po.tp.LongIdPo;
import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className AcceptanceCriteriaPo
 * @date 2019/8/26 14:53
 * @Description 修改验收标准PO
 */
@ApiModel("修改验收标准PO")
public class AcceptanceCriteriaPo extends LongIdPo {
    @ApiModelProperty("验收标准表达式")
    @Check(test = "required")
    private String acceptanceCriteria;

    public String getAcceptanceCriteria() {
        return acceptanceCriteria;
    }

    public void setAcceptanceCriteria(String acceptanceCriteria) {
        this.acceptanceCriteria = acceptanceCriteria;
    }
}
