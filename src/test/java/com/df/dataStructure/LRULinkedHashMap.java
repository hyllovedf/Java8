package com.df.dataStructure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author hanyli
 * @date 2021/2/24
 */
public class LRULinkedHashMap<K,V> extends LinkedHashMap<K,V> {
    private int capacity;

    LRULinkedHashMap(int capacity) {
        super(16, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
    public synchronized void get() {

    }

    public static void main(String[] args) {
        LRULinkedHashMap<Integer, String> map = new LRULinkedHashMap<>(2);
        map.put(1, "df");
        map.put(2, "dfdf");
        map.put(3, "dfdfdf");
        map.get(2);
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

    }
}
