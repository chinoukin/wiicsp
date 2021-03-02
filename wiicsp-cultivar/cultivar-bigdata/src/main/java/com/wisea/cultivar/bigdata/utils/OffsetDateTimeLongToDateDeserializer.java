package com.wisea.cultivar.bigdata.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019/9/19 11:46 上午
 */
public class OffsetDateTimeLongToDateDeserializer extends JsonDeserializer<OffsetDateTime> {

    @Override
    public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return getDeserialized(jsonParser.getText());
    }

    public OffsetDateTime getDeserialized(String time) {
        Date date = new Date(Long.parseLong(time) * 1000L);
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return offsetDateTime;
    }

}
