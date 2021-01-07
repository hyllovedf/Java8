package com.df.dataStructure;

import java.util.*;


/**
 * LRU算法模拟
 * @author hanyli
 * @date 2020/12/7
 */
public class LRUCache {
    private Node head;
    private Node end;
    private Map<String,Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public String get(String key) {
        Node node = map.get(key);
        if (node == null) {
            return null;
        }
        refresh(node);
        return node.value;
    }

    public void put(String key, String value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            refresh(node);
        } else {
            Node node = new Node(key, value);
            if (map.size() >= capacity) {
                String remove = remove(head);
                map.remove(remove);
            }
            map.put(key, node);
            add(node);
        }
    }

    private void refresh(Node node) {
        if (node == end) {
            return;
        }
        remove(node);
        add(node);
    }

    private String remove(Node node) {
        if (node == head && node == end) {
            head = null;
            end = null;
        } else if (node == end) {
            end = end.pre;
            end.next = null;
        } else if (node == head) {
            head = head.next;
            head.pre = null;
        } else {
            node.pre.next = node.next;
            node.next.pre=node.pre;
        }
        return node.key;
    }

    private void add(Node node) {
        if (end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null) {
            head = node;
        }
    }

    static class Node {
        private Node next;
        private Node pre;
        private String key;
        private String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put("1","11111");
        lruCache.put("2","22222");
        lruCache.put("3","33333");
        lruCache.get("1");
        lruCache.put("4","44444");
        System.out.println(lruCache.get("1"));
    }
}
