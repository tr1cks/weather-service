package com.github.tr1cks.weather.core.util;

import javax.annotation.Nullable;

public class Asserts {

    /**
     * For situations, when we are definitely know that nullable value can't be null in current app state and context.
     */
    public static <T> T notNull(@Nullable T obj) {
        if(obj == null) {
            throw new IllegalStateException();
        }

        return obj;
    }
}
