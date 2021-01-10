package gsc.javaClassLibraryTest;

import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalTest {

	@Test
	public void test2() {
		BigDecimal b1 = new BigDecimal("1");
		BigDecimal b2 = new BigDecimal("0.3");
		
		BigDecimal r1 = b1.add(b2);
		BigDecimal r2 = b1.subtract(b2);
		BigDecimal r3 = b1.multiply(b2);
		BigDecimal r4 = b1.divide(b2,10,BigDecimal.ROUND_HALF_EVEN);
		System.out.println(r1.doubleValue());
		System.out.println(r2.doubleValue());
		System.out.println(r3.doubleValue());
		System.out.println(r4.doubleValue());

	}
	
	//尽量不要使用参数类型为double、float的数据来构建BigDecimal,用string
	@Test
	public void test1() {
		BigDecimal bigDecimal = new BigDecimal(0.1);
		System.out.println(new Double(0.1).toString());
		System.out.println(bigDecimal);
	}
}
