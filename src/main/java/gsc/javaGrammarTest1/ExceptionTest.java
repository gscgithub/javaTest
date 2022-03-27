package gsc.javaGrammarTest1;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTest {

	@Test
	public void test2() {

		try {
			FileInputStream fis = new FileInputStream("abc");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test1() {
		Exception exception = new Exception("get exception message");
		System.out.println(exception.getMessage());
		exception.printStackTrace();

		try {
			throw new Exception("exception...");
		} catch (Exception e) {
			System.out.println("e:" + e);
			System.out.println("getMessage:" + e.getMessage());
			System.out.println("getStackTrace:" + e.getStackTrace());
			System.out.println("getCause:" + e.getCause());
			System.out.println("hashCode:" + e.hashCode());
			System.out.println("toString:" + e.toString());
		}
	}
}