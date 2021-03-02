package com.wisea.cultivar.plant.vo;

import com.wisea.cloud.model.Page;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel("分页查询linkMageVo和StandardRuleMageVo")
public class StandardRuleMageAndLinkVo {
    private Page<StandardRuleMagePageListVo> standardRuleMagePageListVos;
    private List<linkMagePageListVo> linkMagePageListVos;

    public Page<StandardRuleMagePageListVo> getStandardRuleMagePageListVos() {
        return standardRuleMagePageListVos;
    }

    public void setStandardRuleMagePageListVos(Page<StandardRuleMagePageListVo> standardRuleMagePageListVos) {
        this.standardRuleMagePageListVos = standardRuleMagePageListVos;
    }

    public List<linkMagePageListVo> getLinkMagePageListVos() {
        return linkMagePageListVos;
    }

    public void setLinkMagePageListVos(List<linkMagePageListVo> linkMagePageListVos) {
        this.linkMagePageListVos = linkMagePageListVos;
    }
}
