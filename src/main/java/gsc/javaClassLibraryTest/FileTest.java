package gsc.javaClassLibraryTest;

import org.junit.Test;

import java.io.*;

public class FileTest {

	@Test
	public void test1() {
		String path="F:/wordTest.xml";
		File file = new File(path);
		byte []bs = new byte[(int) file.length()];
		System.out.println(file.exists());
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			is.read(bs);
			for (byte b : bs) {
				System.out.println(b);
			}
			String fileName=new String("wordTest.xml");//为了解决中文名称乱码问题
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			if(is != null) {
				try {
					is.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	@Test
	public void mkdirsTest() {
		File rootFile = new File("D:\\software\\workspace\\eclipse-jee-luna-SR2-win32"
				+ "\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps"
				+ "\\kms_run1\\WEB-INF\\files\\seed\\16-06-30 092917_1467251494538");
//				+ "\\kms_run1\\WEB-INF\\files\\seed\\17_1467251494538");
		boolean isSuccess = false;
		if (!rootFile.exists()) {
			System.out.println("create dirs");
			isSuccess = rootFile.mkdirs();
		}
		System.out.println("mkdirsTest invoke finish,create directory " + isSuccess);
	}
}
