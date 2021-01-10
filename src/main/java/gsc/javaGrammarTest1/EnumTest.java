package gsc.javaGrammarTest1;

import gsc.common.MyEnum;
import org.junit.Test;

public class EnumTest {

    @Test
    public void test5() {
        MyEnum e1= MyEnum.enumA;
        switch (e1) {
            case enumA:
                System.out.println(e1.getStr());
                break;
            case enumB:
                System.out.println(e1.getStr());
                break;
        }
    }

    @Test
    public void test4() {
        System.out.println(MyEnum.valueOf("enumA"));
    }

    @Test
    public void test3() {
        for(MyEnum myEnum : MyEnum.values()) {
            System.out.println(myEnum);
        }
    }

    @Test
    public void test2() {
//        MyEnum.AbstractMethodEnum aEnum = MyEnum.AbstractMethodEnum.enum1;
//        aEnum.print();
    }

    @Test
    public void test1() {
        MyEnum myEnum = MyEnum.enumA;
        System.out.println(myEnum);
        myEnum.print();
    }
}
