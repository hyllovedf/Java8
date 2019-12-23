package com.df.functional;

import java.util.*;

/**
 * create by hanyli 2019/11/18
 */
public class FunctionalInterfaceTest {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        Supplier aNew = FunctionalInterfaceTest::new;
//        test(()-> {
//            return "df";
//        });
        List<Data> dataList = Arrays.asList(
                new Data("1", "#"),
                new Data("2", "#"),
                new Data("8", "#"),
                new Data("3", "1"),
                new Data("4", "1"),
                new Data("5", "2"),
                new Data("6", "3")
        );
        t(dataList);
        String s = dataList.get(0).getParent();
        String s1 = dataList.get(1).getParent();
        Map<String, String> map = new HashMap<>();
        map.put("1", s);
        map.put("2", s1);
        System.out.println(map.get("1")==(map.get("2")));

        String path = FunctionalInterfaceTest.class.getResource("/").getPath();
        System.out.println(path);

    }

    public static void test(MyFunctionalInterface myFunctionalInterface) {

        myFunctionalInterface.te();
        String test = myFunctionalInterface.test();
        System.out.println(test);
    }

    public static void t(List<Data> list) {
        Map<String, List<Data>> parentMap = new HashMap<>();
        List<Data> dataList = new ArrayList<>();
        for (Data data : list) {
            if (!parentMap.containsKey(data.getParent())) {
                dataList = new ArrayList<>();
                parentMap.put(data.getParent(), dataList);
            } else {
                dataList = parentMap.get(data.getParent());
            }
            dataList.add(data);
        }
        System.out.println(parentMap);
            /*let childNodes = []
            console.log(childNodes)
            treeData.forEach(data=>{
            if (!this.parentMap.has(data.parent)) {
                childNodes = []
                console.log(childNodes)
                this.parentMap.set(data.parent, childNodes);
            } else {
                childNodes = this.parentMap.get(data.parent)
            }
            childNodes.push(data)*/
    }
}
