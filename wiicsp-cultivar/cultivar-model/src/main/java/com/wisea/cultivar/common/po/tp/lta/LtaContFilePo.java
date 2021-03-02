package com.wisea.cultivar.common.po.tp.lta;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 长协合同附件信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月7日
 * @version 1.0
 */
@ApiModel("长协合同附件信息PO")
public class LtaContFilePo {

	@ApiModelProperty(value="文件名称")
    private String fileName;//文件名称

    @ApiModelProperty(value="合同附件url")
    private String url;//合同附件url

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
