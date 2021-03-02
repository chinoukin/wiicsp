package com.wisea.cultivar.plant.po;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/8/31 17:14
 * @Description:
 */
public class TimePo {

    private String name;
    private String value;
    private String label;

    private List<TimePo> children;
    private Integer year;
    private Integer month;
    private Integer day;

    public String getValue() {
        return name;
    }

    public String getLabel() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TimePo> getChildren() {
        return children;
    }

    public void setChildren(List<TimePo> children) {
        this.children = children;
    }
}
