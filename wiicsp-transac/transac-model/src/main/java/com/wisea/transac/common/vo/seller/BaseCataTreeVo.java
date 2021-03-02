package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * @author wangjiahao
 * @since 2020/7/2 2:14 下午
 */
@ApiModel("基地品种树VO")
public class BaseCataTreeVo {

    /**
     * catgId : 1
     * catgName : aasd
     * children : [{"supName":"asd","supId":123,"count":123}]
     */

    private Long catgId;
    private String catgName;
    private List<BaseCataListVo> children;

    public Long getCatgId() {
        return catgId;
    }

    public void setCatgId(Long catgId) {
        this.catgId = catgId;
    }

    public String getCatgName() {
        return catgName;
    }

    public void setCatgName(String catgName) {
        this.catgName = catgName;
    }

    public List<BaseCataListVo> getChildren() {
        return children;
    }

    public void setChildren(List<BaseCataListVo> children) {
        this.children = children;
    }
}
