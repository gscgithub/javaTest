package gsc.javaGrammarTest1;

import org.junit.Test;

public class InnerClassTest {

	public InnerClassTest() {
		System.out.println("ClassTest");
		new InnerClass();
	}
	private class InnerClass {
		public InnerClass() {
			System.out.println("InnerClass");
		}
	}

	@Test
	public void test() {
//		new InnerClassTest();
	}
	
}
