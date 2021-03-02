package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * @Author jirg
 * @Date 2019/3/22 15:43
 * @Description 养殖栏图片
 **/
public class OriBreedPenPic extends DataLongEntity<OriBreedPenPic> {
    /**
     * 养殖栏id
     */
    private Long breedPenId;

    /**
     * 图片url
     */
    private String url;

    public Long getBreedPenId() {
        return breedPenId;
    }

    public void setBreedPenId(Long breedPenId) {
        this.breedPenId = breedPenId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
