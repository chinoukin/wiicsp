package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.transac.common.po.FilePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className BaseCertMagePo
 * @date 2020/7/1 10:04
 * @Description 基地证书PO
 */
@ApiModel("基地证书PO")
public class BaseCertMagePo {
    @ApiModelProperty("数据ID，修改时不能为空")
    private Long id;
    @ApiModelProperty("基地ID")
    @Check(test = {"required"})
    private Long baseId;
    @ApiModelProperty("基地证书名称")
    @Check(test = {"required"})
    private String certName;
    @ApiModelProperty("基地证书图片")
    @Check(test = { "required" }, cascade = true)
    private List<FilePo> files;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public List<FilePo> getFiles() {
        return files;
    }

    public void setFiles(List<FilePo> files) {
        this.files = files;
    }
}
