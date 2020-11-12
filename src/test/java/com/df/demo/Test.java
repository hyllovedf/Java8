package com.df.demo;

import com.alibaba.excel.EasyExcelFactory;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.BuiltinFormats;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * @author hanyli
 * @date 2020/4/19
 */
public class Test {
    public int minDeletionSize(String[] A) {

        List<Integer> list = new ArrayList<>();
        char temp = 'a';

        for(int i =0;i<A[0].length();i++){
            for(String s:A){
                if(s.charAt(i)<temp){
                    list.add(i);
                    break;
                }
                temp=s.charAt(i);
            }
            temp='a';
        }
        return list.size();
    }

    public static void main(String[] args) throws Exception {
        BigDecimal bigDecimal = new BigDecimal(10.011);
        BigDecimal bigDecimal1 = bigDecimal.setScale(3,ROUND_HALF_UP);
        System.out.println(bigDecimal.toString());
        System.out.println(bigDecimal1.toString());
        BigDecimal bigDecimal2 = new BigDecimal("10.010999999999999232613845379091799259185791015625");
        String s = "(\\w+)";
        Pattern pattern = Pattern.compile(s);
        String str = "GDDLX_JE * GDDLX_SZ";
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            System.out.println(group);
            str = str.replace(group, "90");
        }
        System.out.println(str);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 2);
        HashSet<Integer> integers = new HashSet<>(map.values());
        System.out.println(integers.size());
        map.put(1, map.getOrDefault(1, 0) + 1);
    }

    private static Record getRecord(String s) {
        return null;
    }

    private static int getN(int k) {
        try {
            return 1;

        }finally {
            System.out.println("finally");
        }
    }

    public static void save(String fileId) {
        fileId = "dfdf";
    }
    static class MyThread implements Runnable {

        private int value;
        private Semaphore semaphore;

        public MyThread(int value, Semaphore semaphore) {
            this.value = value;
            this.semaphore = semaphore;
        }

        @SneakyThrows
        @Override
        public void run() {
            semaphore.acquire();
            System.out.println(String.format("当前线程%d,还有%d个资源,还有%d个线程等待",value,semaphore.availablePermits(),semaphore.getQueueLength()));
            Random random = new Random();
            Thread.sleep(random.nextInt(1000));
            semaphore.release();
            System.out.println(String.format("线程%d释放了资源",value));
        }
    }
}
