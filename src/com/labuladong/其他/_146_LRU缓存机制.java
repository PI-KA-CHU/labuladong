package com.labuladong.其他;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class _146_LRU缓存机制 {

    int maxCapacity = 0;
    Map<Integer, Integer> cache = new LinkedHashMap<>();
    LinkedList<Integer> list = new LinkedList<>();

    public _146_LRU缓存机制(int cache) {
        maxCapacity = cache;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }

        if (cache.size() >= maxCapacity) {
            Integer oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key, value);
    }

    public void makeRecently(int key) {
        if (!cache.containsKey(key)) {
            return;
        }

        Integer value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }


    Map<Integer, Integer> cache1 = new LinkedHashMap<>();
    int capacity = 10;

    public int get1(int key) {
        if (!cache1.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache1.get(key);
    }

    public void put1(int key, int value) {
        if (cache1.containsKey(key)) {
            cache1.put(key, value);
            makeRecently(key);
            return;
        }

        if (cache1.size() >= capacity) {
            cache1.remove(cache1.keySet().iterator().next());
        }
        cache1.put(key, value);
    }

    public void makeRecently1(int key) {
        if (!cache1.containsKey(key)) {
            return;
        }
        Integer val = cache1.get(key);
        cache1.remove(key);
        cache1.put(key, val);
    }
}
