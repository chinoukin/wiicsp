package com.wisea.cultivar.common.vo.tp;


import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2019-03-25 17:15
 * @Description:养殖日志时间轴Vo
 */
public class BreedLogTimeBaseVo {

    /**
     * 养殖日志Id
     * */
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    private Long id;

    /**
     * 按照批次查询
     * 批次名称
     */
    private String batchName;

    /**
     * 按照牦牛的id
     * 耳标号
     */
    private String earLabel;

    /**
     * 操作类型
     */
    private String oriOperateType;

    /**
     * 内容
     */
    private String content;

    /**
     * 距离开始日期多少天
     */
    private String dayNum;

    /**
     * 操作时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime operateDate;

    /**
     * 操作人
     */
    private String operatePeople;

    /**
     * 操作图片
     */
    private List<String> operateUrlList;

    /**
     * 批次/单头开始时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime beginDate;

    public OffsetDateTime getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(OffsetDateTime beginDate) {
        this.beginDate = beginDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getEarLabel() {
        return earLabel;
    }

    public void setEarLabel(String earLabel) {
        this.earLabel = earLabel;
    }

    public String getOriOperateType() {
        return oriOperateType;
    }

    public void setOriOperateType(String oriOperateType) {
        this.oriOperateType = oriOperateType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDayNum() {
        return dayNum;
    }

    public void setDayNum(String dayNum) {
        this.dayNum = dayNum;
    }

    public OffsetDateTime getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(OffsetDateTime operateDate) {
        this.operateDate = operateDate;
    }

    public String getOperatePeople() {
        return operatePeople;
    }

    public void setOperatePeople(String operatePeople) {
        this.operatePeople = operatePeople;
    }

    public List<String> getOperateUrlList() {
        return operateUrlList;
    }

    public void setOperateUrlList(List<String> operateUrlList) {
        this.operateUrlList = operateUrlList;
    }
}
