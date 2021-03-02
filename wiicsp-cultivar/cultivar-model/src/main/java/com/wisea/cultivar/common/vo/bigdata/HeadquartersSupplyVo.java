package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className HeadquartersDomesticAndForeignVo
 * @date 2019/12/5 16:50
 * @Description 总部交易动态国内外Vo
 */
@ApiModel("国内/国外货源各列表查询Vo")
public class HeadquartersSupplyVo {
    @ApiModelProperty("产地锁定货源列表")
    private List<LockSourceInfoListVo> lockSourceInfoVos;
    @ApiModelProperty("产地入库货源列表")
    private List<RkSourceInfoListVo> rkSourceInfoVos;
    @ApiModelProperty("在途运输货源列表")
    private List<ZtSourceInfoListVo> ztSourceInfoVos;

    public List<LockSourceInfoListVo> getLockSourceInfoVos() {
        return lockSourceInfoVos;
    }

    public void setLockSourceInfoVos(List<LockSourceInfoListVo> lockSourceInfoVos) {
        this.lockSourceInfoVos = lockSourceInfoVos;
    }

    public List<RkSourceInfoListVo> getRkSourceInfoVos() {
        return rkSourceInfoVos;
    }

    public void setRkSourceInfoVos(List<RkSourceInfoListVo> rkSourceInfoVos) {
        this.rkSourceInfoVos = rkSourceInfoVos;
    }

    public List<ZtSourceInfoListVo> getZtSourceInfoVos() {
        return ztSourceInfoVos;
    }

    public void setZtSourceInfoVos(List<ZtSourceInfoListVo> ztSourceInfoVos) {
        this.ztSourceInfoVos = ztSourceInfoVos;
    }
}
