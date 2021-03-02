package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * cont_temp_mage 表实体
 * 合同模板管理
 * 2019/05/23 15:28:19
 */
public class ContTempMage extends DataLongEntity<ContTempMage> {
    private static final long serialVersionUID = 1L;

    private String tempName;

    private String contContent;

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName == null ? null : tempName.trim();
    }

    public String getContContent() {
        return contContent;
    }

    public void setContContent(String contContent) {
        this.contContent = contContent == null ? null : contContent.trim();
    }
}
