package gsc.javaClassLibraryTest;

import java.util.BitSet;

import org.junit.Test;

public class BitSetTest {

	@Test
	public void test3() {
		BitSet bm1 = new BitSet(7);
		System.out.println(bm1.isEmpty() + "--" + bm1.size());
		BitSet bm2 = new BitSet(63);
		System.out.println(bm2.isEmpty() + "--" + bm2.size());
		BitSet bm3 = new BitSet(65);
		System.out.println(bm3.isEmpty() + "--" + bm3.size());
		BitSet bm4 = new BitSet(111);
		System.out.println(bm4.isEmpty() + "--" + bm4.size());
	}
	
	/**
	 * BitSet初始长度64
	 * get(i)未置位的位置返回false，并且不会引起BitSet扩容
	 * set(65)会让BitSet扩容
	 */
	@Test
	public void test2() {
		BitSet bm = new BitSet();     
		System.out.println(bm.get(113) + " " + bm.isEmpty() + "--" + bm.size());
		System.out.println(bm.isEmpty() + "--" + bm.size());         
		bm.set(0);         
		System.out.println(bm.isEmpty() + "--" + bm.size());         
		bm.set(1);         
		System.out.println(bm.isEmpty() + "--" + bm.size());  
		
		System.out.println(bm.get(65));         
		System.out.println(bm.isEmpty() + "--" + bm.size());         
		bm.set(65);         
		System.out.println(bm.isEmpty() + "--" + bm.size());
	}
	
	/**
	 * 表明字符串使用到了那些字符
	 */
	@Test
	public void test1() {
		BitSet bitSet = new BitSet();
		String str = "hello world!";
		for( int i = 0 ; i < str.length() ; i++) {
			bitSet.set(str.charAt(i));
		}
		for( int i = 0 ; i < bitSet.size() ; i ++) {
			if(bitSet.get(i))
				System.out.print((char)i);
		}
	}
}
