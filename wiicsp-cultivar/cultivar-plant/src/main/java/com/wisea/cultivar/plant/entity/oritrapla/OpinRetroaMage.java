package com.wisea.cultivar.plant.entity.oritrapla;


import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * 意见反馈管理
 */
public class OpinRetroaMage extends DataLongEntity<OpinRetroaMage> {
    /**
     * id
     */
    private Long id;

    /**
     * 会员id
     */
    private Long membId;

    /**
     * 反馈内容
     */
    private String retroaCont;

    /**
     * 处理状态
     */
    private String handleStatus;

    /**
     * 处理结果
     */
    private String handleResult;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getRetroaCont() {
        return retroaCont;
    }

    public void setRetroaCont(String retroaCont) {
        this.retroaCont = retroaCont;
    }

    public String getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(String handleStatus) {
        this.handleStatus = handleStatus;
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
    }

}
