package gsc.javaClassLibraryTest;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	@Test
	public void test1() throws IOException {
		Properties properties = new Properties();
		properties.load(new FileReader("test.properties"));
		System.out.println(properties.get("t1"));
		System.out.println(properties.get("t2"));
		System.out.println(properties.get("t3"));
	}
}
