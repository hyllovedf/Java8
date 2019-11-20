package com.df.functional.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * create by hanyli 2019/11/19
 */
public class Practice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        //(1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
        List<Transaction> one = transactions.stream()
                .filter(tr -> tr.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(one);
        //(2) 交易员都在哪些不同的城市工作过？
        List<String> two = transactions.stream()
                .map(tr -> tr.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(two);
        //(3) 查找所有来自于剑桥的交易员，并按姓名排序。
        List<Trader> three = transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(t -> "Cambridge".equals(t.getCity()))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(three);
        //(4) 返回所有交易员的姓名字符串，按字母顺序排序。
        List<String> four = transactions.stream()
                .map(tr -> tr.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(four);
        //(5) 有没有交易员是在米兰工作的？
        boolean five = transactions.stream()
                .anyMatch(tr -> "Milan".equals(tr.getTrader().getCity()));
        System.out.println(five);
        //(6) 打印生活在剑桥的交易员的所有交易额。
        List<Integer> six = transactions.stream()
                .filter(tr -> "Cambridge".equals(tr.getTrader().getCity()))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
        System.out.println(six);
        //(7) 所有交易中，最高的交易额是多少？
        Optional<Integer> reduce = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(reduce.get());
        Optional<Integer> max = transactions.stream().map(Transaction::getValue).max(Comparator.comparingInt(a -> a));
        System.out.println(max.get());
        int asInt = transactions.stream().mapToInt(Transaction::getValue).max().getAsInt();
        System.out.println(asInt);


        //(8) 找到交易额最小的交易。
        Optional<Integer> min = transactions.stream().map(Transaction::getValue).reduce(Integer::min);
        System.out.println(min.get());
    }
}
