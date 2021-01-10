package gsc.javaClassLibraryTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitTest {
	
	@Before		//在每个测试方法前执行
	public void testBefore() {
		System.out.println("testBefore");
	}
	
	@After		//在每个测试方法后执行
	public void testAfter() {
		System.out.println("testAfter");
	}
	
	@Test
	public void testMethod1() {
		System.out.println("testMethod1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("testMethod2");
	}
	
	@BeforeClass		//在测试方法开始前执行一次
	public static void testBeforeClass() {
		System.out.println("testBeforeClass");
	}
	
	@AfterClass		//在测试方法结束后执行一次
	public static void testAfterClass() {
		System.out.println("testAfterClass");
	}
}
