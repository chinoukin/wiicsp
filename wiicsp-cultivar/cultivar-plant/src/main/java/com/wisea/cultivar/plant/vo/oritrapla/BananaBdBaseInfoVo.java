package com.wisea.cultivar.plant.vo.oritrapla;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019/8/22 2:13 下午
 */
public class BananaBdBaseInfoVo {

    /**
     * code : 0
     * data : [{"no":1,"plantingArea":513.1,"updateDate":"2018-11-14 22:41:20","basePeasant":"95","code":"nu004","address":"册亨县岩架镇","lng":"","isVideo":"1","baseManager":"4","isNewRecord":false,"env":{"22":"948","99":"","23":"0","rainfall":"0","temp":"24.7","co2":"13","wd":"东风","lux":"100","ph":"6.8","humi":"94","press":943.3,"ws":"0","flow":0},"orgId":9830,"annualOutput":"659.69","videoUrl":"http://hls.open.ys7.com/openlive/a2cb2b84c0be46839f8dc852d264f926.m3u8","plantNum":56441,"id":"4","perMu":"2571.38","baseName":"新寨种植基地","remarks":"","lat":"","createDate":"2018-10-19 14:52:59"},{"no":2,"plantingArea":453.8,"updateDate":"2018-11-14 22:41:00","basePeasant":"72","code":"nu003","address":"册亨县岩架镇","lng":"","isVideo":"0","baseManager":"4","isNewRecord":false,"env":{"22":"959","99":"","23":"0","rainfall":"0","temp":"24.1","co2":"15","wd":"西北","lux":"100","ph":"7.2","humi":"97","press":943.3,"ws":"0","flow":0},"orgId":9820,"annualOutput":"583.47","plantNum":49918,"id":"3","perMu":"2571.48","baseName":"弄应种植基地","remarks":"","lat":"","createDate":"2018-10-19 14:51:25"},{"no":3,"plantingArea":698.6,"updateDate":"2018-11-14 22:40:48","basePeasant":"106","code":"nu002","address":"册亨县岩架镇","lng":"","isVideo":"0","baseManager":"3","isNewRecord":false,"env":{"22":"977","99":"","23":"1","rainfall":"0","temp":"11.0","co2":"225","wd":"北风","lux":"100","ph":"7.0","humi":"85","press":943.3,"ws":"0","flow":0},"orgId":9829,"annualOutput":"898.23","plantNum":76846,"id":"2","perMu":"2571.51","baseName":"洛王种植基地","remarks":"","lat":"","createDate":"2018-10-19 14:50:31"},{"no":4,"plantingArea":501.7,"updateDate":"2018-11-14 22:40:30","basePeasant":"89","code":"nu001","address":"册亨县岩架镇","lng":"","isVideo":"1","baseManager":"3","isNewRecord":false,"env":{"99":"","23":"112","rainfall":"0","temp":"30.9","co2":"280","ph":"--","humi":"63","press":"936.5","ws":"2","wd":"东北","flow":0,"lux":"26750"},"orgId":9821,"annualOutput":"645.07","videoUrl":"http://hls.open.ys7.com/openlive/0718c53c12f64389afdcd1c19a780161.hd.m3u8","plantNum":55187,"id":"1","perMu":"2571.53","baseName":"洛凡种植基地","remarks":"","lat":"","createDate":"2018-10-19 14:48:57"}]
     * message :
     */

    private String code;
    private String message;
    private List<BaseInfo> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<BaseInfo> getData() {
        return data;
    }

    public void setData(List<BaseInfo> data) {
        this.data = data;
    }

    public static class BaseInfo {
        /**
         * no : 1
         * plantingArea : 513.1
         * updateDate : 2018-11-14 22:41:20
         * basePeasant : 95
         * code : nu004
         * address : 册亨县岩架镇
         * lng :
         * isVideo : 1
         * baseManager : 4
         * isNewRecord : false
         * env : {"22":"948","99":"","23":"0","rainfall":"0","temp":"24.7","co2":"13","wd":"东风","lux":"100","ph":"6.8","humi":"94","press":943.3,"ws":"0","flow":0}
         * orgId : 9830
         * annualOutput : 659.69
         * videoUrl : http://hls.open.ys7.com/openlive/a2cb2b84c0be46839f8dc852d264f926.m3u8
         * plantNum : 56441
         * id : 4
         * perMu : 2571.38
         * baseName : 新寨种植基地
         * remarks :
         * lat :
         * createDate : 2018-10-19 14:52:59
         */

        private String no;
        private double plantingArea;
        private String updateDate;
        private String basePeasant;
        private String code;
        private String address;
        private String lng;
        private String isVideo;
        private String baseManager;
        private boolean isNewRecord;
        private Env env;
        private int orgId;
        private String annualOutput;
        private String videoUrl;
        private int plantNum;
        private String id;
        private String perMu;
        private String baseName;
        private String remarks;
        private String lat;
        private String createDate;

        @Override
        public String toString() {
            return "BaseInfo{" +
                    "no=" + no +
                    ", plantingArea=" + plantingArea +
                    ", updateDate='" + updateDate + '\'' +
                    ", basePeasant='" + basePeasant + '\'' +
                    ", code='" + code + '\'' +
                    ", address='" + address + '\'' +
                    ", lng='" + lng + '\'' +
                    ", isVideo='" + isVideo + '\'' +
                    ", baseManager='" + baseManager + '\'' +
                    ", isNewRecord=" + isNewRecord +
                    ", env=" + env +
                    ", orgId=" + orgId +
                    ", annualOutput='" + annualOutput + '\'' +
                    ", videoUrl='" + videoUrl + '\'' +
                    ", plantNum=" + plantNum +
                    ", id='" + id + '\'' +
                    ", perMu='" + perMu + '\'' +
                    ", baseName='" + baseName + '\'' +
                    ", remarks='" + remarks + '\'' +
                    ", lat='" + lat + '\'' +
                    ", createDate='" + createDate + '\'' +
                    '}';
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public double getPlantingArea() {
            return plantingArea;
        }

        public void setPlantingArea(double plantingArea) {
            this.plantingArea = plantingArea;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public String getBasePeasant() {
            return basePeasant;
        }

        public void setBasePeasant(String basePeasant) {
            this.basePeasant = basePeasant;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getIsVideo() {
            return isVideo;
        }

        public void setIsVideo(String isVideo) {
            this.isVideo = isVideo;
        }

        public String getBaseManager() {
            return baseManager;
        }

        public void setBaseManager(String baseManager) {
            this.baseManager = baseManager;
        }

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public Env getEnv() {
            return env;
        }

        public void setEnv(Env env) {
            this.env = env;
        }

        public int getOrgId() {
            return orgId;
        }

        public void setOrgId(int orgId) {
            this.orgId = orgId;
        }

        public String getAnnualOutput() {
            return annualOutput;
        }

        public void setAnnualOutput(String annualOutput) {
            this.annualOutput = annualOutput;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public int getPlantNum() {
            return plantNum;
        }

        public void setPlantNum(int plantNum) {
            this.plantNum = plantNum;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPerMu() {
            return perMu;
        }

        public void setPerMu(String perMu) {
            this.perMu = perMu;
        }

        public String getBaseName() {
            return baseName;
        }

        public void setBaseName(String baseName) {
            this.baseName = baseName;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public static class Env {
            /**
             * 22 : 948
             * 99 :
             * 23 : 0
             * rainfall : 0
             * temp : 24.7
             * co2 : 13
             * wd : 东风
             * lux : 100
             * ph : 6.8
             * humi : 94
             * press : 943.3
             * ws : 0
             * flow : 0
             */

            @SerializedName("22")
            private String _$22;
            @SerializedName("99")
            private String _$99;
            @SerializedName("23")
            private String _$23;
            private String rainfall;
            private String temp;
            private String co2;
            private String wd;
            private String lux;
            private String ph;
            private String humi;
            private String press;
            private String ws;
            private String flow;

            @Override
            public String toString() {
                return "Env{" +
                        "_$22='" + _$22 + '\'' +
                        ", _$99='" + _$99 + '\'' +
                        ", _$23='" + _$23 + '\'' +
                        ", rainfall='" + rainfall + '\'' +
                        ", temp='" + temp + '\'' +
                        ", co2='" + co2 + '\'' +
                        ", wd='" + wd + '\'' +
                        ", lux='" + lux + '\'' +
                        ", ph='" + ph + '\'' +
                        ", humi='" + humi + '\'' +
                        ", press=" + press +
                        ", ws='" + ws + '\'' +
                        ", flow=" + flow +
                        '}';
            }

            public String get_$22() {
                return _$22;
            }

            public void set_$22(String _$22) {
                this._$22 = _$22;
            }

            public String get_$99() {
                return _$99;
            }

            public void set_$99(String _$99) {
                this._$99 = _$99;
            }

            public String get_$23() {
                return _$23;
            }

            public void set_$23(String _$23) {
                this._$23 = _$23;
            }

            public String getRainfall() {
                return rainfall;
            }

            public void setRainfall(String rainfall) {
                this.rainfall = rainfall;
            }

            public String getTemp() {
                return temp;
            }

            public void setTemp(String temp) {
                this.temp = temp;
            }

            public String getCo2() {
                return co2;
            }

            public void setCo2(String co2) {
                this.co2 = co2;
            }

            public String getWd() {
                return wd;
            }

            public void setWd(String wd) {
                this.wd = wd;
            }

            public String getLux() {
                return lux;
            }

            public void setLux(String lux) {
                this.lux = lux;
            }

            public String getPh() {
                return ph;
            }

            public void setPh(String ph) {
                this.ph = ph;
            }

            public String getHumi() {
                return humi;
            }

            public void setHumi(String humi) {
                this.humi = humi;
            }

            public String getPress() {
                return press;
            }

            public void setPress(String press) {
                this.press = press;
            }

            public String getWs() {
                return ws;
            }

            public void setWs(String ws) {
                this.ws = ws;
            }

            public String getFlow() {
                return flow;
            }

            public void setFlow(String flow) {
                this.flow = flow;
            }
        }
    }
}
