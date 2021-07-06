package com.remmy.simplepaas.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 对象深拷贝
 * @author yejiaxin
 */
public class CopyUtil {
    public static Object deepCopy(Object ori, Class<?> type) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(objectMapper.writeValueAsString(ori), type);
    }
}
