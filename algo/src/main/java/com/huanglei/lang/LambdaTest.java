package com.huanglei.lang;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class LambdaTest {
    public static void main(String[] args) {
        NoReturnNoParam method = () -> System.out.println("NoReturnNoParam");
        method.method();

        NoReturnOneParam oneParam = a -> System.out.println("" + a);

        ReturnNoParam returnNoParam = () -> {
            System.out.println("no param");
            return 0;
        };
        oneParam = LambdaTest::add;
        oneParam = new LambdaTest()::add2;
        int num = 10;
        Consumer<String> consumer = o -> System.out.println(num);
//        num = 20;

        int [] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        OptionalInt b = Arrays.stream(arr).findAny();
        int asInt = b.getAsInt();
        int max = Arrays.stream(arr).reduce(Integer.MIN_VALUE, Math::max);

        List<Node> nodes = getNodes();
//        Map<String, List<Node>> collect = nodes.stream().collect(groupingBy(LambdaTest::getKey));
//        collect.forEach((s, nodes1) -> {
//            System.out.println(s);
//            nodes1.forEach(System.out::println);
//        });
//        nodes.stream().flatMap(new Function<Node, Stream<?>>() {
//            @Override
//            public Stream<?> apply(Node node) {
//                return null;
//            }
//        });
//        Map<String, List<Node>> maps = nodes.parallelStream().collect(groupingBy(Node::getKey));
//
//        //返回的是Key
//        Map<Level, List<Node>> maps2 = nodes.parallelStream().collect(groupingBy(t -> {
//            if (Integer.parseInt(t.getValue() )<= 50)
//                return Level.LOW;
//            else if (Integer.parseInt(t.getValue()) <= 70)
//                return Level.NORMAL;
//            else
//                return Level.HIGH;
//        }));
//        maps2.forEach((s, nodes12) -> {
//            System.out.println(s);
//            nodes12.forEach(node -> System.out.println(node));
//        });
//        Map<String, Optional<Node>> maps4 = nodes.stream().collect(groupingBy(Node::getKey,
//                maxBy(Comparator.comparing(Node::getValue))));
//        maps4.forEach((s, nodes12) -> {
//            System.out.println(s);
//            System.out.println(nodes12);
//        });
        //groupby之后是Map结构，downstream下游处理的是Map的value
//        Map<String, List<Node>> collect = nodes.stream().collect(groupingBy(Node::getKey));
//        collect.forEach(new BiConsumer<String, List<Node>>() {
//            @Override
//            public void accept(String s, List<Node> nodes) {
//                System.out.println(s +"=>");
//                nodes.forEach(new Consumer<Node>() {
//                    @Override
//                    public void accept(Node node) {
//                        System.out.println(node);
//                    }
//                });
//            }
//        });
//        Map<String, Map<String, String>> collect = nodes.stream().collect(groupingBy(Node::getKey, toMap(Node::getKey, Node::getValue, (s, s2) -> s)));
//        collect.forEach(new BiConsumer<String, Map<String, String>>() {
//            @Override
//            public void accept(String s, Map<String, String> stringStringMap) {
//                System.out.println(s);
//                stringStringMap.forEach(new BiConsumer<String, String>() {
//                    @Override
//                    public void accept(String s, String s2) {
//                        System.out.println(s+"==>"+s2);
//                    }
//                });
//            }
//        });
//        List<String> list2 = Arrays.asList("a", "b", "c");
//        // Collectors.joining(",")的结果是：a,b,c  然后再将结果 x + "d"操作, 最终返回a,b,cd
//        String str= Stream.of("a", "b", "c").collect(Collectors.collectingAndThen(Collectors.joining(","), x -> x + "d"));
//        System.out.println(str);


        //根据Stream<Foo>对这个流先按照name分组收集，再每组统计m，n属性的平均值
        Foo f1 = new Foo("l", 1, 2),
                f2 = new Foo("l", 1, 2),
                f3 = new Foo("l", 1, 2),
                f4 = new Foo("c", 1, 2),
                f5 = new Foo("c", 1, 2),
                f6 = new Foo("q", 1, 2),
                f7 = new Foo("q", 1, 2);
        System.out.println(Stream.of(f1, f2, f3, f4, f5, f6, f7)
                .collect(Collectors.groupingBy(
                        Foo::getName,
                        Collectors.reducing(new Foo(null, 0, 0), (o, p) -> {
                            if (o.getName() == null) {
                                o.setName(p.getName());
                            }
                            o.setM(o.getM() + p.getM());
                            o.setN(o.getN() + p.getN());
                            o.setCount(o.getCount() == null ? 1 : o.getCount() + 1);
                            return o;
                        })
                ))
        );

    }
    public enum Level { LOW, NORMAL, HIGH };


    public static void add(int a){

    }
    public void add2(int a){

    }
    public static String getKey(Node node){
        return node.key;
    }
    public static List<Node> getNodes(){
        List<Node> nodes = Lists.newArrayList();
        for(int i=0;i<100;i++){
            nodes.add(new Node((i%10)+"",i+""));
        }
        return nodes;
    }
    static class Node{
        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
    @Data
    static
    class Foo{
        // 分组属性
        private String name;
        // 需求：分组平均值
        private Integer m;
        // 需求：分组平均值
        private Integer n;
        // 非业务属性，计算平均值时使用
        private Integer count;

        public Foo(String name, Integer m, Integer n) {
            this.name = name;
            this.m = m;
            this.n = n;
        }
    }

}
