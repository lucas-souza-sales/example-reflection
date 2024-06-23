package com.sales.example_reflection.refl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Transformator {

    public <I, O> O transform(I input) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> source = input.getClass();
        Class<?> target = Class.forName(source.getName() + "DTO");

        O targetClass = (O) target.getDeclaredConstructor().newInstance();

        Field[] sourceFields = source.getDeclaredFields();
        Field[] targetFields = target.getDeclaredFields();

        Arrays.stream(sourceFields).forEach(sourceField ->
            Arrays.stream(targetFields).forEach(targetField -> {
                if (validateField(sourceField, targetField)) {
                    sourceField.setAccessible(true);
                    targetField.setAccessible(true);
                    try {
                        targetField.set(targetClass, sourceField.get(input));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            })
        );

        return targetClass;
    }

    private boolean validateField(Field sourceField, Field targetField) {
        return (sourceField.getType().equals(targetField.getType())
                && sourceField.getName().equals(targetField.getName()));
    }
}
