package com.mercury.basic.collection_framework;

import java.util.*;

public class IterationTest {
    public static void iterateArray() {
        int[] nums = {1, 2, 3, 4};

        // 1. traditional for loop / while
//        for(int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }

        // 2. enhanced for loop (foreach loop)
//        for(int num : nums) {
//            System.out.println(num);
//        }

        // 3. iterator : cannot

        // 4. forEach

        Arrays.stream(nums).forEach(i -> System.out.println(i));

    }

    public static void iterateList() {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // 1. traditional for loop
//        for(int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        // 2. enhanced for loop
//        for(int num : list) {
//            System.out.println(num);
//            list.remove(2);
//        }

        // 3. iterator : use iterator to iterate an iterable

        // fail-fast iterator vs fail-safe iterator
        // fail-over

        // fail-fast iterator:
        // during iteration by using iterator, if the iterable is being structural modified, exception out

        // fail-safe iterator:
        // not exception out
        // CopyOnWriteArrayList

//        Iterator<Integer> iterator = list.iterator();
//
//        while(iterator.hasNext()) {
//            int next = iterator.next();
//            System.out.println(next);
//        }

        // 4. forEach
        list.stream().forEach(i -> System.out.println(i));

        list.forEach(e -> System.out.println(e));

    }

    public static void iterateSet() {
        Set<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(4);

        // 1. cannot use traditional for loop, since no index

        // 2. enhanced for loop - internally use iterator
//        for(int num : hs) {
//            System.out.println(num);
//        }

        // 3. iterator
//        Iterator<Integer> iterator = hs.iterator();
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        // 4. forEach

        hs.forEach(s -> System.out.println(s));
    }

    public static void iterateMap() {
        Map<Integer, String> hm = new HashMap<>();

        hm.put(1, "a");
        hm.put(2, "b");
        hm.put(3, "c");
        hm.put(4, "d");

        // 1. traditional for loop : no, since no index
        // 2. enhanced for loop : no, since not iterable
        // 3. iterator : no, since not iterable
        // 4. forEach

        // convert the map to set, then iterate the set

        // 1. use keySet()
//        Set<Integer> ks = hm.keySet();
//
//        for(Integer key : ks) {
//            System.out.println(key + " -- " + hm.get(key));
//        }

        // 2. use entrySet()
//        Set<Map.Entry<Integer, String>> es = hm.entrySet();
//
//        Iterator<Map.Entry<Integer, String>> iterator = es.iterator();
//
//        while(iterator.hasNext()) {
//            Map.Entry<Integer, String> me = iterator.next();
////            System.out.println(me);
//
//            System.out.println(me.getKey() + " <---> " + me.getValue());
//        }

        hm.forEach((k, v) -> System.out.println(k + " ___ " + v));
    }

    public static void main(String[] args) {
//        iterateList();

        iterateMap();
    }
}
