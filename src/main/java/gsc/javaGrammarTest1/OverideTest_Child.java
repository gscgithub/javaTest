package gsc.javaGrammarTest1;

public class OverideTest_Child extends OverrideTest_Parent {

//--------------------------重载测试-----------------------------------

    public Integer method2() {
        return null;
    }

    public Integer method2(Integer i1) {
        return null;
    }

    //报错，返回类型不同，不能构成重载
//    public String method2() {
//        return null;
//    }

    //报错，控制权限不同，不能构成重载
//    private Integer method2() {
//        return null;
//    }


//--------------------------覆盖测试-----------------------------------
    //报错
//    public Object overrideMethod1() throws RuntimeException{
//        return null;
//    }

    //报错
//    public String overrideMethod1() throws RuntimeException{
//        return null;
//    }

//    public Integer overrideMethod1() throws RuntimeException{
//        return null;
//    }

//    public Integer overrideMethod1() throws IndexOutOfBoundsException{
//        return null;
//    }

    //报错
//    public Integer overrideMethod1() throws Exception{
//        return null;
//    }
      //报错
//    private Integer overrideMethod1() throws RuntimeException{
//        return null;
//    }

      //报错
//    Integer overrideMethod1() throws RuntimeException{
//        return null;
//    }
}
