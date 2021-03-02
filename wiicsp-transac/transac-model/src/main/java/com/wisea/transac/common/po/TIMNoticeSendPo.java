package com.wisea.transac.common.po;

import java.util.List;

import com.google.common.collect.Lists;
import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TIM发送通知PO
 *
 * @author XuDL(Wisea)
 *
 *         2020年5月6日 上午11:06:41
 */
@ApiModel("TIM发送通知PO")
public class TIMNoticeSendPo {

    @ApiModelProperty(value = "通知类型")
    @Check(test = "required")
    private String type;
    @ApiModelProperty(value = "模板键值 type != sys必填")
    @Check(test = "logic", logic = "'sys'.equals(#type)?#isNotEmpty(#tplKey):true")
    private String tplKey;
    @ApiModelProperty(value = "标题")
    @Check(test = "required")
    private String title;
    @ApiModelProperty(value = "摘要或描述")
    private String desc;
    @Check(test = "required")
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "接收者列表")
    @Check(test = "required")
    private List<String> recList = Lists.newArrayList();
    @ApiModelProperty(value = "下发数据 下发数据会作为穿透的属性 完整的设置到ext中")
    private Object payload;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTplKey() {
        return tplKey;
    }

    public void setTplKey(String tplKey) {
        this.tplKey = tplKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getRecList() {
        return recList;
    }

    public void setRecList(List<String> recList) {
        this.recList = recList;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

}
