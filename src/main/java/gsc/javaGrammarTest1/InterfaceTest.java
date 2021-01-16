package gsc.javaGrammarTest1;

import org.junit.Test;

public class InterfaceTest {

    //同时实现多个接口，多个接口可以有同一方法
    @Test
    public void test1() {
        Car car = new Car();
        car.print();
    }

    interface Vehicle {
        void print();
    }

    interface FourWheeler {
        void print();
    }

    class Car implements Vehicle, FourWheeler {

        @Override
        public void print() {
            System.out.println("我是一辆四轮汽车!");
        }
    }
}


