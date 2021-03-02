package com.wisea.cultivar.plant.vo.oritrapla;

import java.util.List;

/**
 * Auth： jirg
 * CreateDate:  2018/6/7
 * projectName:  oritrapla
 * remark:
 */
public class RtspCodeMagePdfVo {
    private String orgName; //农场或公司名称
    private String archNum; //档案编号
    private String batchNum; //批次编号
    private Integer rtspCodeCount; //追溯码数量
    private String massifName; //地块名称
    private String commName; //品种名称-只显示第三级
    private String commVarietName; //品种名称
    private List<RtspCodePdfVo> rtspCodes; //追溯码集合

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getArchNum() {
        return archNum;
    }

    public void setArchNum(String archNum) {
        this.archNum = archNum;
    }

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public Integer getRtspCodeCount() {
        return rtspCodeCount;
    }

    public void setRtspCodeCount(Integer rtspCodeCount) {
        this.rtspCodeCount = rtspCodeCount;
    }

    public String getMassifName() {
        return massifName;
    }

    public void setMassifName(String massifName) {
        this.massifName = massifName;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getCommVarietName() {
        return commVarietName;
    }

    public void setCommVarietName(String commVarietName) {
        this.commVarietName = commVarietName;
    }

    public List<RtspCodePdfVo> getRtspCodes() {
        return rtspCodes;
    }

    public void setRtspCodes(List<RtspCodePdfVo> rtspCodes) {
        this.rtspCodes = rtspCodes;
    }
}
