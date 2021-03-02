package com.wisea.cultivar.plant.utils;

import com.google.gson.*;
import com.wisea.cloud.common.util.ConverterUtil;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GsonHelper {


    public static Gson buildGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(OffsetDateTime.class, new GsonOffsetDateTimeAdapter())
                .create();
    }

    public static class GsonOffsetDateTimeAdapter implements JsonDeserializer<OffsetDateTime> {
        @Override
        public OffsetDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            String value = jsonElement.getAsString();
            if (ConverterUtil.isNotEmpty(value)) {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(Long.valueOf(value) * 1000);
                LocalDateTime loc = LocalDateTime.parse(df.format(date), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                return OffsetDateTime.of(loc, ZoneOffset.of("+08:00"));
            }
            return null;
        }
    }
}
