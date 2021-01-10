package gsc.javaGrammarTest1;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

public class ClassGrammerTest {

    @Test
    public void test1() {
        new Child();
    }
}


class Father {

    static {
        System.out.println("father static code block");
    }

    {
        System.out.println("father constructor block");
    }
    public Father() {
        System.out.println("father constructor");
    }
}

class Child extends Father {
    static {
        System.out.println("Child static code block");
    }

    {
        System.out.println("Child constructor block");
    }
    public Child() {
        System.out.println("Child constructor");
    }
}