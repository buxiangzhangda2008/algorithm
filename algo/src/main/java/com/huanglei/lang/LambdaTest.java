package com.huanglei.lang;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ForkJoinPool;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        OptionalInt b = Arrays.stream(arr).findAny();
        int asInt = b.getAsInt();
        int max = Arrays.stream(arr).reduce(Integer.MIN_VALUE, Math::max);

        List<Node> nodes = getNodes();
//        Map<String, List<Node>> collect = nodes.stream().collect(groupingBy(LambdaTest::getKey));
//        collect.forEach((s, nodes1) -> {
//            System.out.println(s);
//            nodes1.forEach(System.out::println);
//        });
//
//        Map<String, List<Node>> maps = nodes.parallelStream().collect(groupingBy(Node::getKey));

        //返回的是Key
//        Map<Level, List<Node>> maps2 = nodes.parallelStream().collect(groupingBy(t -> {
//            if (Integer.parseInt(t.getValue() )<= 50)
//                return Level.LOW;
//            else if (Integer.parseInt(t.getValue()) <= 70)
//                return Level.NORMAL;
//            else
//                return Level.HIGH;
//        }));
//        System.out.println(maps2);
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
//        Map<String, Map<String, String>> collect = nodes.stream().collect(groupingBy(Node::getKey, toMap(Node::getKey, Node::getValue, (s, s2) -> s+s2)));
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
        Map<String, Foo> collect1 = Stream.of(f1, f2, f3, f4, f5, f6, f7)
                .collect(groupingBy(
                        Foo::getName,
//                        Collectors.summingInt(Foo::getM)));
                        reducing(new Foo(null, 0, 0), (o, p) -> {
//                            if (o.getName() == null) {
//                                o.setName(p.getName());
//                            }
                            p.setM(o.getM() + p.getM());
                            p.setN(o.getN() + p.getN());
                            p.setCount(o.getCount() == null ? 1 : o.getCount() + 1);
                            return p;
                        })
                ));
        List<ScoreBean> list= Lists.newArrayList(
                new ScoreBean("张三",1)
                ,new ScoreBean("李四",2)
                ,new ScoreBean("王五",3)
                ,new ScoreBean("小明",4)
                ,new ScoreBean("小红",5));
        Integer total=list.stream()
                .reduce(
                        Integer.valueOf(0)  /*初始值 identity*/
                        ,(integer,scoreBean)->integer+scoreBean.getScore() /*累加计算 accumulator*/
                        ,(integer1,integer2)->integer1+integer2 /*第三个参数 combiner*/
                );
        System.out.println(total);//结果：15

//        Map<Department, Integer> totalByDept = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)));
        List<Foo> retFoo = new ArrayList<>();
        Stream.of(f1, f2, f3, f4, f5, f6, f7)
                .collect(groupingBy(Foo::getName)).forEach((s, foos) -> {
                    Foo f = foos.stream().reduce(new Foo(null, 0, 0), (o, p) -> {
                        if (o.getName() == null) {
                            o.setName(p.getName());
                        }
                        o.setM(o.getM() + p.getM());
                        o.setN(o.getN() + p.getN());
                        o.setCount(o.getCount() == null ? 1 : o.getCount() + 1);
                        return o;
                    });
                    retFoo.add(f);
                });
//        List<Integer> list=Lists.newArrayList(1,2,3,4,5);
//        //将数组进行累加求和
//        //由于返回的是 Optional ，因此需要get()取出值。
//        Integer total=list.stream().reduce((result,item)->result+item).get();

//        Stream.of(f1,f2,f3,f4,f5,f6,f7).collect(Collectors.groupingBy(Foo::getName,Collectors.reducing()))
        List<KlassGroup> groupList = Arrays.asList(
                new KlassGroup(new Klass(1), new Klass(2), new Klass(3)),
                new KlassGroup(new Klass(4), new Klass(5), new Klass(6)),
                new KlassGroup(new Klass(7), new Klass(8), new Klass(9)),
                new KlassGroup(new Klass(10))
        );
        List<List<Klass>> result = groupList.stream()
                .map(it -> it.getKlassList())
                .collect(Collectors.toList());
        List<Klass> result2 = new ArrayList<>();
        for (KlassGroup group : groupList) {
            for (Klass klass : group.getKlassList()) {
                result2.add(klass);
            }
        }
        List<Klass> result3 = groupList.stream()
                .flatMap(it -> it.getKlassList().stream())
                .collect(Collectors.toList());
        List<Stream<Klass>> result4 = groupList.stream()
                .map(it -> it.getKlassList().stream())
                .collect(Collectors.toList());
    }
    @Data
    static class ScoreBean {
        private String name; //学生姓名
        private int score;   //分数，需要汇总该字段
        public ScoreBean(String name, int score) {
            this.name = name;
            this.score = score;
        }
        //get 和 set 方法省略
    }

    public enum Level {LOW, NORMAL, HIGH}

    ;


    public static void add(int a) {

    }

    public void add2(int a) {

    }

    public static String getKey(Node node) {
        return node.key;
    }

    public static List<Node> getNodes() {
        List<Node> nodes = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            nodes.add(new Node((i % 10) + "", i + ""));
        }
        return nodes;
    }

    static class Node {
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
    class Foo {
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

    private static class Klass {
        private int field;

        public Klass(int field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return "field=" + field;
        }
    }

    private static class KlassGroup {
        private List<Klass> group = new ArrayList<>();

        public KlassGroup(Klass... objList) {
            for (Klass item : objList) {
                this.group.add(item);
            }
        }

        public List<Klass> getKlassList() {
            return group;
        }
    }

    public static void main2(String[] args) {
        System.out.println("processors num is: " + Runtime.getRuntime().availableProcessors());
        System.out.println(ForkJoinPool.getCommonPoolParallelism());
        IntStream list = IntStream.range(0, 10);
        Set<Thread> threadSet = new CopyOnWriteArraySet<>();
        //开始并行执行
        list.parallel().forEach(i -> {
            Thread thread = Thread.currentThread();
            System.out.println("integer：" + i + "，" + "currentThread:" + thread.getName());
            threadSet.add(thread);
        });
        System.out.println("all threads：" + threadSet.stream().map(Thread::getName).collect(Collectors.joining(":")));
        List<Integer> values = new ArrayList<>();
        IntStream.range(1, 10000).parallel().forEach(values::add);
        System.out.println(values.size());
    }
}
