package com.wisea.transac.common.vo.seller;

import com.wisea.transac.common.vo.FileVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className BaseCertMageVo
 * @date 2020/7/1 9:35
 * @Description 基地证书Vo
 */
@ApiModel("基地证书Vo")
public class BaseCertMageVo {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("基地id")
    private Long baseId;
    @ApiModelProperty("证书名称")
    private String certName;
    @ApiModelProperty("基地证书图片列表")
    private List<FileVo> files;

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

    public List<FileVo> getFiles() {
        return files;
    }

    public void setFiles(List<FileVo> files) {
        this.files = files;
    }
}
