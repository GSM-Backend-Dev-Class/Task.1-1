package com.gsm._8th.class4.backed.task._1._1.util;

import java.util.List;
import java.util.Optional;

public class ExceptionHandlerUtil {

    public static <T> T handleException(Throwable ex, T defaultValue) {
        return defaultValue;
    }

    public static <T> Optional<T> handleOptionalException(Throwable ex) {
        return Optional.empty();
    }

    public static <T> List<T> handleListException(Throwable ex) {
        return List.of();
    }

    public static Boolean handleBooleanException(Throwable ex) {
        return false;
    }
} 