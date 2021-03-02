package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @Description: 新增农事操作类型字典
 * @author: wangs
 * @date :2018/6/21
 */
@ApiModel("新增农事操作类型字典")
public class FarmWorkDictPo {

    @ApiModelProperty(value="农事操作类型id")
    private Long id;
    /**
     * 分类查询
     */
    @ApiModelProperty(value="分类类型(0:一级分类,1:二级分类)")
    @Check(test = "required", regexMsg = "分类类型不能为空")
    private String farmWorkType;

    /**
     * 名称 /^[\u4e00-\u9fffa-zA-Z]{1,10}$
     *      /^[\u4e00-\u9fa5]{1,10}$/
     *
     * 正则 : 只能1到10个字符 ^[\u0000-\uffff]{0,100} $
     */
    @ApiModelProperty("名称")
    @Check(test="regex", regex= "^.{1,10}$",regexMsg = "名称不能超过10个字符")
    private String name;

    /**
     * 排序    ^[0-9]{1,4}$
     * 正则 : 最多输入四位数
     */
    @ApiModelProperty("排序")
    @Check(test="regex", regex= "^\\d{1,4}$",regexMsg = "排序最多输入四位数")
    private Integer sort;

    /**
     * 是否设为常用
     */
    @ApiModelProperty("是否常用(新增二级分类时使用)")
    private String comUsedFlag;

    /**
     *  父节点id
     */
    @ApiModelProperty("父节点id")
    @Check(test = "logic", logic = "'1'.equals(#farmWorkType)?#isNotEmpty(#parentId):true",regexMsg = "分类类型为二级时,一级品类不能为空")
    private Long parentId;

    /**
     * 排他字段 更新时间
     */
    @ApiModelProperty(value="排他字段")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getComUsedFlag() {
        return comUsedFlag;
    }

    public void setComUsedFlag(String comUsedFlag) {
        this.comUsedFlag = comUsedFlag;
    }

    public String getFarmWorkType() {
        return farmWorkType;
    }

    public void setFarmWorkType(String farmWorkType) {
        this.farmWorkType = farmWorkType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
