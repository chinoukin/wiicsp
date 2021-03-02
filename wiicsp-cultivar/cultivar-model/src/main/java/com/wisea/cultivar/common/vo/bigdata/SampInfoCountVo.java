package com.wisea.cultivar.common.vo.bigdata;

/**
 * @ClassNameSampInfoCountVo
 * @Description
 * @Author zhangbo
 * @Date2020/9/7 11:14
 **/
public class SampInfoCountVo {
    //总抽检数
    private double totalStatistics;
    //合格数
    private double qualifiedQuantity;
    //不合格数
    private double unqualifiedQuantity;
    //合格率
    private String passRate;
    //不合格率
    private String unqualifiedRate;

    public double getTotalStatistics() {
        return totalStatistics;
    }

    public void setTotalStatistics(double totalStatistics) {
        this.totalStatistics = totalStatistics;
    }

    public double getQualifiedQuantity() {
        return qualifiedQuantity;
    }

    public void setQualifiedQuantity(double qualifiedQuantity) {
        this.qualifiedQuantity = qualifiedQuantity;
    }

    public double getUnqualifiedQuantity() {
        return unqualifiedQuantity;
    }

    public void setUnqualifiedQuantity(double unqualifiedQuantity) {
        this.unqualifiedQuantity = unqualifiedQuantity;
    }

    public String getPassRate() {
        return passRate;
    }

    public void setPassRate(String passRate) {
        this.passRate = passRate;
    }

    public String getUnqualifiedRate() {
        return unqualifiedRate;
    }

    public void setUnqualifiedRate(String unqualifiedRate) {
        this.unqualifiedRate = unqualifiedRate;
    }
}
