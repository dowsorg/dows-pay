package org.dows.pay.api.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JsonUtils {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static final ObjectMapper OBJECT_MAPPER_BY_SNAKE_CASE;

    public JsonUtils() {
    }

    public static <T> T parseObject(Object obj, Class<T> clazz) {
        return obj != null ? parseObject(obj2String(obj), clazz) : null;
    }

    public static <T> T parseObject(String s, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(s, clazz);
        } catch (IOException var3) {
            logger.error("object mapper parse object error ", var3);
            throw new RuntimeException("反序列化异常", var3);
        }
    }

    public static <T> T parseObject(Object o, TypeReference<T> type) {
        try {
            return o != null ? OBJECT_MAPPER.readValue(obj2String(o), type) : null;
        } catch (IOException var3) {
            logger.error("object parse type error", var3);
            throw new RuntimeException("反序列化异常", var3);
        }
    }

    public static <T> T parseObject(String s, TypeReference<T> type) {
        try {
            return OBJECT_MAPPER.readValue(s, type);
        } catch (IOException var3) {
            logger.error("string parse object error ", var3);
            throw new RuntimeException("反序列化异常", var3);
        }
    }

    public static String obj2String(Object obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException var2) {
            logger.error("object parse string error ", var2);
            throw new RuntimeException("反序列化异常", var2);
        }
    }

    static {
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        OBJECT_MAPPER.configure(MapperFeature.AUTO_DETECT_FIELDS, true);
        OBJECT_MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        /**SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        OBJECT_MAPPER.setDateFormat(dateFormat);**/
        OBJECT_MAPPER_BY_SNAKE_CASE = OBJECT_MAPPER.copy();
        OBJECT_MAPPER_BY_SNAKE_CASE.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }
}
