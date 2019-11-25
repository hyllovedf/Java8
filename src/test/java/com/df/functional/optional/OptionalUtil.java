package com.df.functional.optional;

import java.util.Optional;

/**
 * create by hanyli 2019/11/21
 */
public class OptionalUtil {
    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
