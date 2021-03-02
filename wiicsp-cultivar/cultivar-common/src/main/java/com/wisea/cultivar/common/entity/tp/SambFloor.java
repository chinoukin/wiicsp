package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * samb_floor 表实体
 * 中小零批页楼层
 * 2019/05/28 16:20:20
 */
public class SambFloor extends DataLongEntity<SambFloor> {
    private static final long serialVersionUID = 1L;

    /**
     * 楼层名称
     */
    private String floorName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 楼层副标题
     */
    private String sambFloorTitle;

    /**
     * 状态（启用、停用）
     */
    private String enableFlag;

    /**
     * 获取楼层名称
     */
    public String getFloorName() {
        return floorName;
    }

    /**
     * 设置楼层名称
     */
    public void setFloorName(String floorName) {
        this.floorName = floorName == null ? null : floorName.trim();
    }

    /**
     * 获取排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取状态（启用、停用）
     */
    public String getEnableFlag() {
        return enableFlag;
    }

    /**
     * 设置状态（启用、停用）
     */
    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag == null ? null : enableFlag.trim();
    }

	public String getSambFloorTitle() {
		return sambFloorTitle;
	}

	public void setSambFloorTitle(String sambFloorTitle) {
		this.sambFloorTitle = sambFloorTitle;
	}
}
