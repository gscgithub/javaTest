package gsc.javaClassLibraryTest;

import java.util.Arrays;

import org.junit.Test;

public class BitOperateTest {

	@Test
	public void someTest12() {
		// 1. 获得int型最大值
		System.out.println((1 << 31) - 1);
		// 2147483647， 由于优先级关系，括号不可省略
		System.out.println(~(1 << 31));
		// 2147483647
		// 2. 获得int型最小值
		System.out.println(1 << 31);
		System.out.println(1 << -1);
		// 3. 获得long类型的最大值
		System.out.println(((long)1 << 127) - 1);
		// 4. 乘以2运算
		System.out.println(10<<1);
		// 5. 除以2运算(负奇数的运算不可用)
		System.out.println(10>>1);
		// 6. 乘以2的m次方
		System.out.println(10<<2);
		// 7. 除以2的m次方
		System.out.println(16>>2);
		// 8. 判断一个数的奇偶性
		System.out.println((10 & 1) == 1);
		System.out.println((9 & 1) == 1);
		// 9. 不用临时变量交换两个数（面试常考）
		int a = 10,b = 20;
		a ^= b;
		b ^= a;
		a ^= b;
		// 10. 取绝对值（某些机器上，效率比n>0 ? n:-n 高）
		int n = -1;
		System.out.println((n ^ (n >> 31)) - (n >> 31));
		/* n>>31 取得n的符号，若n为正数，n>>31等于0，若n为负数，
		 * n>>31等于-1 若n为正数 n^0-0数不变，若n为负数n^-1 需
		 * 要计算n和-1的补码，异或后再取补码， 结果n变号并且绝对值减1，
		 * 再减去-1就是绝对值 */
		// 11. 取两个数的最大值（某些机器上，效率比a>b ? a:b高）
		System.out.println(b&((a-b)>>31) | a&(~(a-b)>>31));
		// 12. 取两个数的最小值（某些机器上，效率比a>b ? b:a高）
		System.out.println(a&((a-b)>>31) | b&(~(a-b)>>31));
		// 13. 判断符号是否相同(true 表示 x和y有相同的符号， false表示x，y有相反的符号。)
		System.out.println((a ^ b) > 0);
		// 14. 计算2的n次方 n > 0
		System.out.println(2<<(n-1));
		// 15. 判断一个数n是不是2的幂 System.out.println((n & (n - 1)) == 0);
		/*如果是2的幂，n一定是100... n-1就是1111.... 所以做与运算结果为0*/
		// 16. 求两个整数的平均值
		System.out.println((a+b) >> 1);
		// 17. 从低位到高位,取n的第m位
		int m = 2;
		System.out.println((n >> (m-1)) & 1);
		// 18. 从低位到高位.将n的第m位置为1
		System.out.println(n | (1<<(m-1)));
		/*将1左移m-1位找到第m位，得到000...1...000 n在和这个数做或运算*/
		// 19. 从低位到高位,将n的第m位置为0
		System.out.println(Integer.toBinaryString(n) + "," + m);
		System.out.println(Integer.toBinaryString(n & ~(1<<(m-1))));
		/* 将1左移m-1位找到第m位，取反后变成111...0...1111 n再和这个数做与运算*/
	}

	/**
	 * 打印100以内素数： 筛素数法，素数表使用位压缩
	 */
	@Test
	public void someTest11() {
		// 打印100以内素数： 筛素数法
		// （1）对每个素数，它的倍数必定不是素数；
		// （2）有很多重复访问如flag[10]会在访问flag[2]和flag[5]时各访问一次；
		int max = 100;
		// boolean[] flags = new boolean[max];
		int[] flags = new int[max / 8 + 1];
		int[] primes = new int[max / 3 + 1];
		int pi = 0;
		for (int m = 2; m < max; m++) {
			// if (!flags[m]) {
			//获取第m位值
			if ( ((flags[m/32] >> (m%32)) & 1) == 0) {
				primes[pi++] = m;
				for (int n = m; n < max; n += m) {
//					flags[n] = true;
					//第m位置1
					flags[n/32]  |= (1 << (n%32));
				}
			}
		}
		System.out.println(Arrays.toString(primes));
	}

	// 在数字指定位上置1
	@Test
	public void someTest10() {
		int[] bits = new int[40];
		for (int m = 0; m < 40; m += 3) {
			bits[m / 32] |= (1 << (m % 32));
		}
		// 输出整个bits
		for (int m = 0; m < 40; m++) {
			if (((bits[m / 32] >> (m % 32)) & 1) != 0)
				System.out.print('1');
			else
				System.out.print('0');
		}
	}

	@Test
	public void someTest9() {
		int[] is = new int[10];
		System.out.println(Arrays.toString(is));
		boolean[] flags = new boolean[20];
		System.out.println(Arrays.toString(flags));
		System.out.println(3 % 32);
	}

	/**
	 * 打印100以内素数： 筛素数法
	 */
	@Test
	public void someTest8() {
		// 打印100以内素数： 筛素数法
		// （1）对每个素数，它的倍数必定不是素数；
		// （2）有很多重复访问如flag[10]会在访问flag[2]和flag[5]时各访问一次；
		int max = 100;
		boolean[] flags = new boolean[max];
		int[] primes = new int[max / 3 + 1];
		int pi = 0;
		for (int m = 2; m < max; m++) {
			if (!flags[m]) {
				primes[pi++] = m;
				for (int n = m; n < max; n += m) {
					flags[n] = true;
				}
			}
		}
		System.out.println(Arrays.toString(primes));
	}

	/**
	 * 求绝对值2 ★★★ a >> 31 : a为正得0，a为负得-1 a ^ 0 = a ; a ^ -1 得a取反
	 */
	@Test
	public void someTest7() {
		System.out
				.println("======================caculate abs(method2)=======================");
		int a = -333;
		System.out.println("求绝对值前：a = " + a);
		int i = a >> 31;
		int result = (a ^ i) - i;
		System.out.println("求绝对值后：a = " + result);
	}

	// 求绝对值1
	// 00000000 00000000 00000000 00000000 = 0
	// 10000000 00000000 00000000 00000000 = -1
	@Test
	public void someTest6() {
		System.out
				.println("======================caculate abs(method1)=======================");
		int a = 333;
		System.out.println("求绝对值前：a = " + a);
		if (a >> 31 == -1) {
			a = ~a;
			a += 1;
		}
		System.out.println("求绝对值后：a = " + a);
	}

	// 变换符号
	@Test
	public void someTest5() {

		System.out.println("====================变换符号======================");
		int a = 333;
		System.out.println("变换符号前：a = " + a);
		a = ~a;
		a += 1;
		System.out.println("变换符号后：a = " + a);
	}

	@Test
	public void someTest4() {
		int a = 5;
		int b = 7;
		// System.out.println(a^b^b);
		// System.out.println(Integer.toBinaryString(-1 >> 31) );
		System.out.println(0x000000);
		// System.out.println(0x1000000000000000000000000000000);
	}

	// 交换两数 原理 a^b^a = a
	@Test
	public void someTest3() {
		int a = 11;
		int b = -221;
		System.out.println("====================swap number==================");
		System.out.println("before swap : \ta = " + a + "\t\t,b = " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("after swap : \ta = " + a + "\t,b = " + b);
	}

	// 判断奇偶
	@Test
	public void someTest2() {

		int a = -322;
		if ((a & 1) == 0) {
			System.out.println(a + " is even(偶数)");
		} else {
			System.out.println(a + " is odd(奇数)");
		}
	}

	@Test
	public void someTest1() {

		// System.out.println(1 << 1 + 1);
		// System.out.println((1 << 1) + 1);

		int a = -15, b = 15;
		// -4：-15 = 1111 0001(二进制)，右移二位，最高位由符号位填充将得到1111 1100即-4
		System.out.println(a >> 2);

		// 3：15=0000 1111(二进制)，右移二位，最高位由符号位填充将得到0000 0011即3
		System.out.println(b >> 2);

		// : -15 = 11111111 11111111 11111111 11110001
		// 无符号右移 00111111 11111111 11111111 11111100
		System.out.println(a >>> 2);
	}
}
