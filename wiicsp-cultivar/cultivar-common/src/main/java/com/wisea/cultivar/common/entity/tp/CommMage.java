package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * comm_mage 表实体
 * 商品管理
 * 2018/09/18 14:36:47
 */
public class CommMage extends DataLongEntity<CommMage> {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("父id")
    private Long pid; //pid
    private String pids; //pids
    @ApiModelProperty("商品编号")
    private String commNum; //商品编号
    @ApiModelProperty("商品分类名称")
    private String commCatgName; //商品分类名称
    @ApiModelProperty("商品状态")
    private String effeInvalState; //商品状态（有效、无效）
    @ApiModelProperty("排序")
    private Integer sort; //排序
    @ApiModelProperty("分类图标")
    private String catgIconUrl; //分类图标
    @ApiModelProperty("关键词")
    private String keyWord; //关键词
    @ApiModelProperty("分类描述")
    private String catgRemarks; //分类描述


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public String getCommCatgName() {
        return commCatgName;
    }

    public void setCommCatgName(String commCatgName) {
        this.commCatgName = commCatgName;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCatgIconUrl() {
        return catgIconUrl;
    }

    public void setCatgIconUrl(String catgIconUrl) {
        this.catgIconUrl = catgIconUrl;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getCatgRemarks() {
        return catgRemarks;
    }

    public void setCatgRemarks(String catgRemarks) {
        this.catgRemarks = catgRemarks;
    }
}
