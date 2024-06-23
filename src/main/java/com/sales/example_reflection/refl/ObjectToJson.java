package com.sales.example_reflection.refl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ObjectToJson {

    public String transform(Object input) throws JsonProcessingException {

        var objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Map<String, Object> mapper = new HashMap<>();
        Class<?> classToBeTransform = input.getClass();
        Arrays.stream(classToBeTransform.getDeclaredFields()).toList()
            .forEach(field -> {
                field.setAccessible(true);
                try {
                    mapper.put(field.getName(), field.get(input));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            });

        return objectMapper.writeValueAsString(mapper);
    }

}
