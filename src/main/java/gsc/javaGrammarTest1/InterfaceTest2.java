package gsc.javaGrammarTest1;

public interface InterfaceTest2 {

    public static final String abc = null;
    //接口变量为public static final
//    String abc = "InterfaceTest2 abc";

    public void method1();
    void method2();
    //报错
//    protected void method3();

}

class InterFaceTest2Class implements InterfaceTest2 {

    public static void main(String[] args) {
        InterFaceTest2Class aClass = new InterFaceTest2Class();
//        aClass.abc = "abcc";
        System.out.println(aClass.abc);
        System.out.println(InterFaceTest2Class.abc);
    }

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }
}
