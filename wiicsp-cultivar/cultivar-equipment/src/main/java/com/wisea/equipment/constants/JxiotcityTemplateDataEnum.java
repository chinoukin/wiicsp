package com.wisea.equipment.constants;

/**
 * 精讯模板枚举
 * @author chengq
 * @date 2020/11/24 12:06
 */
public enum JxiotcityTemplateDataEnum {
    TEMPERATURE(1, 0.1, "temperature"),//温度
    HUMIDITY(2, 0.1, "humidity"),//湿度
    LIGHT(21, 1.0, "illumination"),//光照度
    ATMOSPHERIC_PRESSURE(22, 0.01, "pressure"),//大气压
    WIND_DIRECTION(139, 1.0, "wind_direction"),//风向
    WIND_SPEED(28, 0.1, "wind_speed"),//风速
    RAINFALL(30, 0.1, "rainfall"),//降雨量
    TOTAL_SOLAR_RADIATION(39, 1.0, "illumination"),//太阳辐射
    SOIL_MOISTURE(25, 0.1, "temperature"),//土壤温度
    SOIL_TEMPERATURE(26, 0.1, "humidity");//土壤湿度

    /**
     * 模板id
     */
    private final Integer templateId;

    /**
     * 系数
     */
    private final Double coefficient;

    /**
     * 字段名
     */
    private final String fieldName;

    JxiotcityTemplateDataEnum(Integer templateId, Double coefficient, String fieldName) {
        this.templateId = templateId;
        this.coefficient = coefficient;
        this.fieldName = fieldName;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public String getFieldName() {
        return fieldName;
    }

    public static JxiotcityTemplateDataEnum getCoefficient(Integer templateId) {
        for (JxiotcityTemplateDataEnum template : values()) {
            if (template.templateId.equals(templateId)) {
                return template;
            }
        }
        return null;
    }


}
