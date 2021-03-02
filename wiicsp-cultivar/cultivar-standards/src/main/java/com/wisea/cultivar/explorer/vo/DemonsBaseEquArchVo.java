package com.wisea.cultivar.explorer.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className DemonsBaseEquArchListVo
 * @date 2020/9/3 9:29
 * @Description 示范基地
 */
public class DemonsBaseEquArchVo {
    @ApiModelProperty("设备列表")
    List<EquInfo> equInfos;
    @ApiModelProperty("档案列表")
    List<ArchInfo> archInfos;

    public List<EquInfo> getEquInfos() {
        return equInfos;
    }

    public void setEquInfos(List<EquInfo> equInfos) {
        this.equInfos = equInfos;
    }

    public List<ArchInfo> getArchInfos() {
        return archInfos;
    }

    public void setArchInfos(List<ArchInfo> archInfos) {
        this.archInfos = archInfos;
    }
}
