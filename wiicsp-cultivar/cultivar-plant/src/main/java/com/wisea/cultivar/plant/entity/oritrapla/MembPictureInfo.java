package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * 会员照片信息
 */
public class MembPictureInfo extends DataLongEntity<MembPictureInfo> {
    private static final long serialVersionUID = 174066133776482548L;
	private Long membId; //会员id
    private String url; //图片url

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
