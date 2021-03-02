package com.wisea.cultivar.plant.vo;

import com.wisea.cloud.model.Page;

import java.util.List;

public class SproutCatalogMageAndEntpVo {
    private Page<OilTeaVarietMagePageListVo> oilTeaVarietMagePageListVoPage;
    private SproutCatalogMageInfoVo catalogMagePageListVoPage;
    private List<ZhfwMembInfoInfoVo> entpPageListVoPage;

    public SproutCatalogMageInfoVo getCatalogMagePageListVoPage() {
        return catalogMagePageListVoPage;
    }

    public void setCatalogMagePageListVoPage(SproutCatalogMageInfoVo catalogMagePageListVoPage) {
        this.catalogMagePageListVoPage = catalogMagePageListVoPage;
    }

    public List<ZhfwMembInfoInfoVo> getEntpPageListVoPage() {
        return entpPageListVoPage;
    }

    public Page<OilTeaVarietMagePageListVo> getOilTeaVarietMagePageListVoPage() {
        return oilTeaVarietMagePageListVoPage;
    }

    public void setOilTeaVarietMagePageListVoPage(Page<OilTeaVarietMagePageListVo> oilTeaVarietMagePageListVoPage) {
        this.oilTeaVarietMagePageListVoPage = oilTeaVarietMagePageListVoPage;
    }

    public void setEntpPageListVoPage(List<ZhfwMembInfoInfoVo> entpPageListVoPage) {
        this.entpPageListVoPage = entpPageListVoPage;
    }
}
