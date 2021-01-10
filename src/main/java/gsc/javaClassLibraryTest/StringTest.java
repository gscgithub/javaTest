package gsc.javaClassLibraryTest;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
	
	@Test
	public void splitTest() {

	}

	@Test
	public void matchingTest2() {
		String str = " a哈";
		System.out.println(str.matches("^[\\x20-\\x7e]*$"));

		String str1 = "a";
		System.out.println(str1.matches("a"));

		System.out.println("--------------------");
		Pattern pattern = Pattern.compile("a+");
		Matcher matcher = pattern.matcher("abca");
		while(matcher.find()) {
			System.out.println("groupCount:" + matcher.groupCount());//?为什么是0
			System.out.println("group:" + matcher.group());
		}
		System.out.println("find end:" + matcher.find());

		Pattern pattern2 = Pattern.compile("\\\\");
		Matcher matcher2 = pattern2.matcher("\\");
		System.out.println(matcher2.find());
	}

	@Test
	public void matchingTest1() {
		System.out.println("begin");
		Pattern compile = Pattern.compile("\\d+");
		Matcher matcher = compile.matcher("呵呵125呵呵哈0阿道夫586");
		while(matcher.find()) {
			System.out.println("group:" + matcher.group());
			System.out.println("start:" + matcher.start());
			System.out.println("end:" + matcher.end());
		}
		System.out.println(matcher.group());
	}

	@Test
	public void strTest4() {
		String str = "tab4_dd_aa";
		//从0开始，包括左边不包括右边
		String tabName = str.substring(0, str.indexOf('_'));
		System.out.println(tabName);
	}

	@Test
	public void strTest3() {
		String str1 = "abc";
		String str2 = "def";
		System.out.println(str1.concat(str2));
		System.out.println(str1.equals(str2));
		
	}

	@Test
	public void strTest2() {
		String str1 = "java";
		String str2 = "ja";
		String str3 = "va";
		String str4 = str2 + str3;
		String str5 = "ja" + "va";
		System.out.println(str1 == (str2 +str3));
		System.out.println(str1 == str4);
		System.out.println(str1 == str5);
		
	}

	@Test
	public void strTest1() {
		String str1 = "java";
		String str2 = "ja";
		String str3 = "va";
		String str4 = new String("java");
		String str5 = str2+str3;
		String str6 = "java";
		System.out.println("java:" + str1);
		System.out.println("ja+va:" + str2+str3);
		System.out.println(str1 == str2+str3);//false
		System.out.println(str1 == (str2+str3).intern());//true
		System.out.println(str1 == str4);//false
		System.out.println(str1 == str5);//false
		System.out.println(str1 == str1.intern());//true
		System.out.println(str1 == str6);//true
		System.out.println(str1 == str2+str3);//false
		System.out.println(str1 == "ja" + "va");//!!!true
	}
}
