package com.wisea.cultivar.common.po.tim;

import com.google.common.collect.Lists;
import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class RemotePortraitSetPo {
    @ApiModelProperty(value = "用户id")
    @Check(test = "required")
    private String fromAccount;

    @ApiModelProperty(value = "待设置的用户的资料对象数组，数组中每一个对象都包含了 Tag 和 Value")
    @Check(test = { "required" }, cascade = true)
    private List<RemoteProfileItem> profileItem = Lists.newArrayList();

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public List<RemoteProfileItem> getProfileItem() {
        return profileItem;
    }

    public void setProfileItem(List<RemoteProfileItem> profileItem) {
        this.profileItem = profileItem;
    }

    public static class RemoteProfileItem {
        @ApiModelProperty(value = "属性名称", notes = "Tag_Profile_IM_Nick:昵称 Tag_Profile_IM_Image:头像URL")

        @Check(test = { "required", "logic" }, logic = "#tag.startsWith('Tag_Profile_IM_') || #tag.startsWith('Tag_Profile_Custom_')", logicMsg = "只支持TIM标准字段和自定义字段")
        private String tag;
        @ApiModelProperty(value = "值")
        @Check(test = { "logic" }, logic = "#tag.equals('Tag_Profile_IM_Nick')?#isNotEmpty(#value):true", logicMsg = "当 tag = Tag_Profile_IM_Nick 时 value不能为空")
        private String value;

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
