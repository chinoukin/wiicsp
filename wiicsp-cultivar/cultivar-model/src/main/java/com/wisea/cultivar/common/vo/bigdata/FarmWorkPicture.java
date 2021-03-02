package com.wisea.cultivar.common.vo.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * 农事图片
 */
public class FarmWorkPicture extends DataLongEntity<FarmWorkPicture> {
    private Long farmWorkRecdId; //农事记录id
    private String url; //图片url

    public Long getFarmWorkRecdId() {
        return farmWorkRecdId;
    }

    public void setFarmWorkRecdId(Long farmWorkRecdId) {
        this.farmWorkRecdId = farmWorkRecdId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
