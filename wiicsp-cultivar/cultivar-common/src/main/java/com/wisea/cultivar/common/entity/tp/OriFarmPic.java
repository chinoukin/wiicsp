package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * @Author jirg
 * @Date 2019/3/22 15:40
 * @Description 养殖场图片
 **/
public class OriFarmPic extends DataLongEntity<OriFarmPic> {
    /**
     * 养殖场id
     */
    private Long farmId;

    /**
     * 图片url
     */
    private String url;

    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
