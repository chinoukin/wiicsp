package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.po.LongIdPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className BaseVrPo
 * @date 2020/6/30 17:54
 * @Description 设置基地720VR PO
 */
@ApiModel("设置基地720VR")
public class BaseVrPo extends LongIdPo {
    @ApiModelProperty("720VR地址")
    private String vrUrl;
    @ApiModelProperty("VR视频地址")
    private String vrVideoUrl;

    public String getVrUrl() {
        return vrUrl;
    }

    public void setVrUrl(String vrUrl) {
        this.vrUrl = vrUrl;
    }

    public String getVrVideoUrl() {
        return vrVideoUrl;
    }

    public void setVrVideoUrl(String vrVideoUrl) {
        this.vrVideoUrl = vrVideoUrl;
    }
}
