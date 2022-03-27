package gsc.javaGrammarTest1;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Jdk18Test {

    @Test
    public void streamTest4() {
        String [] ss = {"abc","aaa"};
        List<Integer> collect = Arrays.stream(ss).map(s -> {
            return s.length();
        }).collect(Collectors.toList());
    }

    @Test
    public void streamTest3() {
        // 并行流 多个线程执行
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream()
                .forEach(System.out::print);

        //
        System.out.println("=========================");
        numbers.stream()
                .sequential()
                .forEach(System.out::print);
    }

    @Test
    public void streamTest2() {
        List<String> list = Arrays.asList("ab","333","dd");
        String joiningStr = list.stream().collect(Collectors.joining(",,"));
        System.out.println("joiningStr:" + joiningStr);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        System.out.println("numbers:" + numbers);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }


    @Test
    public void streamTest() {
        List<Integer> list = Arrays.asList(17,10, 3, 7,20,28);
        System.out.println("list:" + list);

        List<Integer> list1 = list.stream().filter(x -> x > 10).collect(Collectors.toList());
        System.out.println("list:" + list1);

        list.stream().limit(3).forEach(x-> System.out.print(x + " "));
        System.out.println();

        List<Integer> list2 = list.stream().map(x-> x-10).collect(Collectors.toList());
        System.out.println("list:" + list2);

        List<Integer> list3 = list.stream().sorted((x,y)-> {return y-x;}).collect(Collectors.toList());
        System.out.println("list:" + list3);

//        System.out.println("list:" + list);
//
//        Collections.sort(list3, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//        System.out.println(list3);
    }

    @Test
    public void defaultMethodTest2() {
        new Car().print();
        System.out.println("-----------------");
        new Car2().print();
    }

    @Test
    public void defaultMethodTest() {
        DefaultMethodImpl1 defaultMethodImpl1 = new DefaultMethodImpl1();
        defaultMethodImpl1.method1();
        System.out.println("-----------------");

        DefaultMethodImpl2 defaultMethodImpl2 = new DefaultMethodImpl2();
        defaultMethodImpl2.method1();
    }

    @Test
    public void functionRefer() {
        ArrayList<Object> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.forEach(Jdk18Test::function1);
        System.out.println("--------------");
        list.forEach(new Jdk18Test()::function2);
    }

    @Test
    public void lambdaVariableTest() {

        //要不定义成final，要不定义非final，但是后边不能修改值（隐式final）
//        Integer i = 0;
        final Integer i = 0;
        LambdaInterface3<Integer> lambdaInterface = (x) -> {return x+i;};
        System.out.println(lambdaInterface.method1(10));
//        i = 10;
//        System.out.println(i);
    }

    //只有一个参数可省略括号，实现语句只有一句话可省略{}
    @Test
    public void lambdaInterfaceTest() {
        LambdaInterface<Integer> lambdaInterface = (x,y) -> x>y;
        System.out.println(lambdaInterface.method1(10, 13));
        System.out.println("==============================");

        LambdaInterface<Integer> lambdaInterface2 = (x,y) -> {
            System.out.println(x);System.out.println(y);return  x>y;};
        System.out.println(lambdaInterface2.method1(1000, 13));
        System.out.println("==============================");


        LambdaInterface2<Integer> lambdaInterface3 = x -> System.out.println(x);
        lambdaInterface3.method1(10);
        System.out.println("==============================");
    }

    //lambda表达式本质上是一段匿名内部类，也可以是一段可以传递的代码
    @Test
    public void testLambda() {
        //匿名内部类
        Comparator<Integer> cpt = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        TreeSet<Integer> set = new TreeSet<>(cpt);
        set.add(1);
        set.add(7);
        set.add(-68);
        for (Integer integer : set) {
            System.out.println(integer);
        }

        System.out.println("=========================");

        //使用lambda表达式
        Comparator<Integer> cpt2 = (x,y) -> Integer.compare(x,y);
        TreeSet<Integer> set2 = new TreeSet<>(cpt2);
        set2.add(1);
        set2.add(7);
        set2.add(-68);
        for (Integer integer : set2) {
            System.out.println(integer);
        }

    }

    public void function2(Object o) {
        System.out.println("object:" + o);
    }

    public static void function1(Object o) {
        System.out.println("object:" + o);
    }
}

interface InterfaceStaticMethod {
    static void blowHorn() {
        System.out.println("按喇叭!!!");
    }
}

//以下是默认方法测试
interface Vehicle {
    default void print() {
        System.out.println("我是一辆Vehicle!");
    }
}

interface FourWheeler {
    default void print() {
        System.out.println("我是一辆FourWheeler!");
    }
}

//实现的多个接口有同一方法，可以选择用自己的方法覆盖
class Car implements Vehicle, FourWheeler {

    @Override
    public void print() {
        System.out.println("我是一辆车!");
    }
}

//实现的多个接口有同一方法，可以选择其中的一个默认方法
class Car2 implements Vehicle, FourWheeler {

    @Override
    public void print() {
        Vehicle.super.print();
    }
}

//默认方法测试
class  DefaultMethodImpl2 implements   DefaultMethod {
    public void method1() {
        System.out.println("overide method1 default impl");
    }
}

class  DefaultMethodImpl1 implements   DefaultMethod {

}


//方法引用测试
interface  DefaultMethod {
    default  void method1() {
        System.out.println("default method1");
    }
}

//一些为lambda表达式测试

interface LambdaInterface3<T> {
    public T method1(T t1);
}

interface LambdaInterface2<T> {
    public void method1(T t1);
}

interface LambdaInterface<T> {
    public boolean method1(T t1,T t2);
}