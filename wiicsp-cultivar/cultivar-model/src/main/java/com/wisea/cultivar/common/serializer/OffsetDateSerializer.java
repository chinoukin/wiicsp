package com.wisea.cultivar.common.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassNameOffsetDateSerializer
 * @Description
 * @Author zhangbo
 * @Date2020/8/14 17:36
 **/
public class OffsetDateSerializer extends JsonSerializer<OffsetDateTime> {
    public static final OffsetDateTimeSerializer INSTANCE = new OffsetDateTimeSerializer();

    public OffsetDateSerializer() {
    }

    public void serialize(OffsetDateTime dateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(this.getSerializeStr(dateTime));
    }

    public String getSerializeStr(OffsetDateTime dateTime) {
        return null == dateTime ? null : dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
