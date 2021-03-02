package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.oritrapla.RtspCodeMageInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * Auth： jirg
 * CreateDate:  2018/6/5
 * projectName:  oritrapla
 * remark:  分页查询追溯码列表PO
 */
@ApiModel("分页查询追溯码列表PO")
public class RtspCodeMageListPo extends PagePo<RtspCodeMageInfoVo> {
    /***共同参数***/
    @ApiModelProperty("【共同】查询端标记(0 app 、 1 web)必填")
    @Check(test = {"liveable"}, liveable = { "0", "1" },  liveableMsg = "查询端标记不正确")
    private String queryFlag;
    @ApiModelProperty("【共同】查询条件")
    private String query;
    /***App端参数***/
    @ApiModelProperty(value = "【共同】用户IDs", hidden = true)
    private Long userId; //当前登录用户ID

    /***WEB端参数***/
    @ApiModelProperty(value="【WEB端】(0:批次编号1:档案编号2:主体名称)")
    private String queryKey;
    @ApiModelProperty("【WEB端】品类Id")
    private String commId;
    @ApiModelProperty("【WEB端】品种Id")
    private String commVarietId;
    @ApiModelProperty("【WEB端】申请开始时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime creataDateStart;
    @ApiModelProperty("【WEB端】申请结束时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime creataDateEnd;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQueryFlag() {
        return queryFlag;
    }

    public void setQueryFlag(String queryFlag) {
        this.queryFlag = queryFlag;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getQueryKey() {
        return queryKey;
    }

    public void setQueryKey(String queryKey) {
        this.queryKey = queryKey;
    }

    public String getCommId() {
        return commId;
    }

    public void setCommId(String commId) {
        this.commId = commId;
    }

    public String getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(String commVarietId) {
        this.commVarietId = commVarietId;
    }

    public OffsetDateTime getCreataDateStart() {
        return creataDateStart;
    }

    public void setCreataDateStart(OffsetDateTime creataDateStart) {
        this.creataDateStart = creataDateStart;
    }

    public OffsetDateTime getCreataDateEnd() {
        return creataDateEnd;
    }

    public void setCreataDateEnd(OffsetDateTime creataDateEnd) {
        this.creataDateEnd = creataDateEnd;
    }
}
