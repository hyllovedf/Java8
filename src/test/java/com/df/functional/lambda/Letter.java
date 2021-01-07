package com.df.functional.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;

/**
 * create by hanyli 2019/11/18
 */
public class Letter {
    public static String addHeader(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }

    public static String addFooter(String text) {
        return text + " Kind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }

    public static void main(String[] args) {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> function = addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);
        Function<String, String> compose = addHeader.compose(Letter::checkSpelling).compose(Letter::addFooter);
        String df = function.apply("labda");
        System.out.println(df);
        String df1 = compose.apply("df");
        System.out.println(df1);

        Function<Integer,Integer> f = x -> x + 1;
        Function<Integer,Integer> g = x -> x * 2;
        Function<Integer,Integer> h = x -> x + 2;
        Function<Integer, Integer> compose1 = f.compose(g).compose(h);
        Integer apply = compose1.apply(2);
        System.out.println(apply);
        largeGroupPositions("abbxxxxzzz");
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ret;
    }
}
