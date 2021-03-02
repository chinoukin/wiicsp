package com.wisea.cultivar.explorer.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * explain: 下载文件的po
 * </p>
 *
 * @author wangjunming
 * @since 2020/8/5 10:06
 */
public class DownLoadTemplatePo implements Serializable {

    @Check(test = "required")
    @ApiModelProperty(value = "机构类型-templateType--机构/部门:org_type；企业：entp_main_business_type；品牌/品种：tea_oil；")
    private String templateType;

    @Check(test = "required")
    @ApiModelProperty(value = "机构类型-types：(templateType==org_type 值为：)0：机构；1：部门；(templateType==entp_main_business_type 值为：)0:种植主体信息维护；1:种苗企业信息维护；1:种苗企业信息维护；2:农资企业信息维护；3:农机企业信息维护；4:农技企业信息维护；5:精深加工企业维护；机构类型-types：(templateType==tea_oil 值为：)0：品种；1：品牌；")
    private String types;

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }
}
