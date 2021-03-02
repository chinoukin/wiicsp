package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * @Author jirg
 * @Date 2019/3/22 15:42
 * @Description 养殖基地图片
 **/
public class OriBreedBasePic extends DataLongEntity<OriBreedBasePic> {

    /**
     * 养殖基地id
     */
    private Long oriBreedBaseId;

    /**
     * 图片url
     */
    private String url;

    public Long getOriBreedBaseId() {
        return oriBreedBaseId;
    }

    public void setOriBreedBaseId(Long oriBreedBaseId) {
        this.oriBreedBaseId = oriBreedBaseId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
