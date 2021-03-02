package com.wisea.transac.common.po.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wisea.cloud.common.annotation.tree.*;

import java.util.List;

/**
 * @author wangs
 */
public class CommTree {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TreeId
    private Long id;

    /**
     * pid
     */
    @TreePid
    private Long parentId;

    /** 编码 */
    @TreeSort
    private String value;

    /** 树状等级 */
    @TreeLevel
    private int level;


    /** 父节点 */
    @TreeParent
    @JsonIgnore
    private CommTree parent;

    /** 子节点 */
    @TreeChildren
    private List<CommTree> children;

    /**
     * pids
     */
    private String pids;

    /**
     * 商品编号
     */
    private String commNum;

    /**
     * 商品分类名称
     */
    private String commCatgName;

    /**
     * 商品标题
     * */
    private String label;

    /**
     * 商品状态（有效、无效）
     */
    private String effeInvalState;

    public String getLabel() {
        return commCatgName;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getValue() {
        return this.id.toString();
    }

    public void setValue(String value) {
        this.value = value;
    }

    public CommTree getParent() {
        return parent;
    }

    public void setParent(CommTree parent) {
        this.parent = parent;
    }

    public List<CommTree> getChildren() {
        return children;
    }

    public void setChildren(List<CommTree> children) {
        this.children = children;
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
}
