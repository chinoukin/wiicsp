package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * @Author jirg
 * @Date 2019/3/22 15:43
 * @Description 养殖栋图片
 **/
public class OriBreedTungPic extends DataLongEntity<OriBreedTungPic> {
    /**
     * 养殖栋id
     */
    private Long breedTungId;

    /**
     * 图片url
     */
    private String url;

    public Long getBreedTungId() {
        return breedTungId;
    }

    public void setBreedTungId(Long breedTungId) {
        this.breedTungId = breedTungId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
