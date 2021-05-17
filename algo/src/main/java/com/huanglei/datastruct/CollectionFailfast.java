package com.huanglei.datastruct;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 背景：
 * hashmap由于非线程安全，所以多线程操作的过程中会有其他线程对map进程增删改的情况，
 * 这种情况本身无法避免，但为了降低影响，可以引入fail-fast机制，通过快速失败来降低影响。
 *
 * 基本原理：
 * modCount递增修改次数，使用iterator迭代遍历时，记录modCount视图，读取每个元素的时候都会检查modCount与记录的视图是否一致，不一致则认为其他线程或其他操作
 * 已经对collection有了修改操作，则抛出异常；
 *
 * 存在问题：
 * 因为可见性的问题，存在可能其他线程修改了modCount但是当前线程仍然不可见的情况；
 * 考虑使用volatile修饰，使得线程间对变化立即可见。但是因为modCount++操作非原子指令，仍然存在A线程+1与B线程++操作后小于最终会增加的操作数，导致iterator中的
 * 判断失效。
 * 总结：所以不能完全依赖fail-fast来作为是否有竞争操作的判断条件，即存在已经出现竞争实施但fail-fast未能感知的情况。
 */
public class CollectionFailfast {

    public void deleteHashMapElement() {
        Map<String, String> map = new HashMap<>();
        map.put("11", "2");
        map.put("12", "2");
        map.put("13", "2");
        map.put("14", null);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            //            map.remove("11");
            String key = entry.getKey();
            String val = entry.getValue();
            System.out.println("key is :" + key + " || value is :" + val);
        }
        System.out.println("================");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key is :" + entry.getKey() + " || value is :" + entry.getValue());
        }
        map.keySet().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
//                map.keySet().remove("11");
                System.out.println("key is :" + s);
            }
        });
        map.values().forEach(s -> System.out.println("value is :" + s));
//        map.computeIfAbsent("14", new Function<String, String>() {
//            @Override
//            public String apply(String s) {
////                map.put("222",s);
//                return s;
//            }
//        });
        map.computeIfPresent("14", new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
//                map.remove(s);
                return "OK";
            }
        });
        map.forEach((key, value) -> System.out.println("key is :" + key + " || value is :" + value));
    }


    public void deleteTest() {
        List<String> list = new ArrayList<>();
        list.add("aaaaaa");
        list.add("bbbbbb");
        list.add("cccccc");
        list.add("dddddd");
        list.add("eeeeee");

        int i = 0;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (i == 2) {
                // 如果用list.remove(it.next());会报异常
                it.remove();
            }
//            list.remove(s);
            System.out.println("第" + i + "个元素" + it.next());
            i++;
        }
        System.out.println("----------------");
        for (String value : list) {
            System.out.println(value);
        }
    }

    public static void main(String args[]) {
//            new CollectionFailfast().deleteTest();
        new CollectionFailfast().deleteHashMapElement();
    }
}
