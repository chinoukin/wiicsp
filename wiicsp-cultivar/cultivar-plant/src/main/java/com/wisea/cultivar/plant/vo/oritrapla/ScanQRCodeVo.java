package com.wisea.cultivar.plant.vo.oritrapla;

import com.wisea.cultivar.plant.entity.oritrapla.ArchSetup;
import io.swagger.annotations.ApiModelProperty;

/**
 * Auth： jirg
 * CreateDate:  2018/6/11
 * projectName:  oritrapla
 * remark:  扫描追溯二维码查询档案PO
 */
public class ScanQRCodeVo {
    @ApiModelProperty("档案设置信息")
    private ArchSetup archSetup;
    @ApiModelProperty("档案信息")
    private RtspMineArchInfoVo rtspMineArchInfoVo;

    public ArchSetup getArchSetup() {
        return archSetup;
    }

    public void setArchSetup(ArchSetup archSetup) {
        this.archSetup = archSetup;
    }

    public RtspMineArchInfoVo getRtspMineArchInfoVo() {
        return rtspMineArchInfoVo;
    }

    public void setRtspMineArchInfoVo(RtspMineArchInfoVo rtspMineArchInfoVo) {
        this.rtspMineArchInfoVo = rtspMineArchInfoVo;
    }
}
