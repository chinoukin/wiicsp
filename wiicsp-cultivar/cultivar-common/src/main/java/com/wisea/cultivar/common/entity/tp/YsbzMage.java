package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * ysbz_mage 表实体
 * 验收标准管理
 * 2019/09/04 18:27:24
 */
public class YsbzMage extends DataLongEntity<YsbzMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    private Integer sort;

    /**
     * 验收标准
     */
    @Check(test = "required")
    @ApiModelProperty("验收标准信息; 格式:如 1;1-2;2-5;6")
    private String ysbz;

    /**
     * 获取序号
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置序号
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取验收标准
     */
    public String getYsbz() {
        return ysbz;
    }

    /**
     * 设置验收标准
     */
    public void setYsbz(String ysbz) {
        this.ysbz = ysbz == null ? null : ysbz.trim();
    }
}
