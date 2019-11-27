package com.df.functional.parallel;

import com.df.functional.stream.Dish;
import com.df.functional.stream.StreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * create by hanyli 2019/11/20
 */
public class ParallelStreamTest {
    public static void main(String[] args) {
//        long classicalSum = test(ParallelStreams::classicalSum, 10000);
//        System.out.println(classicalSum);//55600
//        long sequentialSum = test(ParallelStreams::sequentialSum, 10000);
//        System.out.println(sequentialSum);//606700
//        long parallelSum = test(ParallelStreams::parallelSum, 10000);
//        System.out.println(parallelSum);//1482000
        long parallelSum = test(ParallelStreams::parallelRangeSum, 10000);
        System.out.println(parallelSum);//393200
//         long parallelSum = test(ParallelStreams::sequentialRangeSum, 10000);
//        System.out.println(parallelSum);//148000
        List<Dish> menu = StreamApi.menu;

//        list.forEach(li -> li.setName("df"));
        System.out.println(menu);
//        menu = menu.stream().filter(li -> li.getCalories() > 300).peek(li -> li.setName("df")).collect(Collectors.toList());
        menu.stream().filter(li -> li.getCalories() > 300).forEach(li -> li.setName("df"));
        System.out.println(menu);
    }

    private static long test(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            Long apply = adder.apply(n);
            long result = System.nanoTime() - start;
            if (result < fastest) {
                fastest = result;
            }
        }
        return fastest;
    }
}
