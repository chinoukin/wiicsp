package com.wisea.cultivar.common.entity.tp;

import java.util.List;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2019-06-24 16:51
 * @Description:处理时间定制Po
 */
public class TimeGenPo {

    /**
     * 年份
     */
    private int yearNum;

    /**
     * 第三级中的内容
     */
    private List<ChildTime> childTime;


    /**
     * 向外展示的外包装
     */
    private List<TimeGenPo> timeGenPos;

    public class ChildTime {

        /**
         * 时间名称
         */
        private String timeName;

        /**
         * 开始时间
         */
        private String startTime;

        /**
         * 结束时间
         */
        private String endTime;

        public String getTimeName() {
            return timeName;
        }

        public void setTimeName(String timeName) {
            this.timeName = timeName;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }
    }

    public List<TimeGenPo> getTimeGenPos() {
        return timeGenPos;
    }

    public void setTimeGenPos(List<TimeGenPo> timeGenPos) {
        this.timeGenPos = timeGenPos;
    }

    public int getYearNum() {
        return yearNum;
    }

    public void setYearNum(int yearNum) {
        this.yearNum = yearNum;
    }

    public List<ChildTime> getChildTime() {
        return childTime;
    }

    public void setChildTime(List<ChildTime> childTime) {
        this.childTime = childTime;
    }
}
