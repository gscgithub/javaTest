package gsc.javaClassLibraryTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;



/**
 * 静态文件服务器，使用浏览器可以访问指定文件
 * 参考帖子第一个case：http://tieba.baidu.com/p/5000244109?see_lz=1
 * @author guoshaocheng
 *
 */
public class StaticFileServer {
	
	public static void main(String[] args) {
		
		new StaticFileServer().service();
		
	}
	
	public void service() {
		
		System.out.println("静态文件服务器启动");
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(80);
//			serverSocket.setSoTimeout(15000);
			while(true) {
				Socket accept = serverSocket.accept();
//				new Thread(new MyHttpRequestHandler(accept)).start();
				new Thread(new MyHttpRequestHandler(accept)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("静态服务器结束");
	}
	
	static void printBs(byte[] bs) {
		
		System.out.print("字节数据：");
		for (byte b : bs) {
			System.out.print(b + " ");
		}
	}
}


/**
 * 访问本地文件/目录
 * @author guoshaocheng
 *
 */
class MyHttpRequestHandler implements Runnable{

	private Socket accept;
	
	private final String baseDir = "C:\\Users\\guosc\\Desktop";
	
	public MyHttpRequestHandler(Socket accept) {
		this.accept = accept;
	}
	
	@Override
	public void run() {
		
		System.out.println("接受到请求，开始处理");
		BufferedReader bReader2 = null;
		try {
			
			//读取数据
			System.out.println("接受到请求,IP：" + accept.getRemoteSocketAddress());
			InputStream is = accept.getInputStream();
			InputStreamReader isReader = new InputStreamReader(is);
			BufferedReader bReader = new BufferedReader(isReader);
			StringBuilder sb = new StringBuilder();
			String bufferStr = null;
			System.out.println("------------------开始读取数据--------------------");
			int count = 0;
			while(!( ((bufferStr = bReader.readLine()).equals("")) && count > 0)) {
				count++;
				sb.append(bufferStr);
//				printBs(bufferStr.getBytes());
//				System.out.println("读到的数据：" + bufferStr);
				sb.append("\n");
			}
			bufferStr = sb.toString();
			System.out.println("最终读取数据：\n" + bufferStr);
			
			
			//返回数据
			System.out.println("\n\n\n------------------向浏览器返回数据---------------------");
			String[] split = bufferStr.split("\r");
			String destFile = (split[0].split(" "))[1];
			System.out.println("请求路径为：" + destFile);
			String destFileConvertion = destFile.replace("/", "\\");
			
			//读取文件内容
			String fileStr = "";
			try {
				File file = new File(baseDir + destFileConvertion);
				if(file.isDirectory()) {
					String tempPath = "" + destFile;
					if(!tempPath.endsWith("/")) {
						tempPath += "/";
					}
					String[] list = file.list();
					for (String item : list) {
						fileStr = fileStr + "<a href='" + tempPath +
								item + "'>" + item +"</a><br/>";
					}
				} else {
					FileReader fReader = new FileReader(file);
					bReader2 = new BufferedReader(fReader);
					char[] cs = new char[1024];
					int len = 0;
					while(-1 != (len = bReader2.read(cs))) {
						fileStr = fileStr + new String(cs,0,len);
					}
				}
			} catch (FileNotFoundException e) {
				fileStr = "file not found!";
			}
			
			//返回
			System.out.println("返回内容为:\n" + fileStr);
			OutputStream oStream = accept.getOutputStream();
			oStream.write(fileStr.getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(accept!= null) 
					accept.close();
				if(bReader2 != null) {
					bReader2.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

/**
 * 将url上的参数相加
 * @author guoshaocheng
 *
 */
class MyHttpRequestHandler1 implements Runnable{

	private Socket accept;
	
	public MyHttpRequestHandler1(Socket accept) {
		this.accept = accept;
	}
	
	@Override
	public void run() {
		
		System.out.println("接受到请求，开始处理");
		try {
			
			//读取数据
			System.out.println("接受到请求,IP：" + accept.getRemoteSocketAddress());
			InputStream is = accept.getInputStream();
			InputStreamReader isReader = new InputStreamReader(is);
			BufferedReader bReader = new BufferedReader(isReader);
			StringBuilder sb = new StringBuilder();
			String bufferStr = null;
			System.out.println("------------------开始读取数据--------------------");
			int count = 0;
			while(!( ((bufferStr = bReader.readLine()).equals("")) && count > 0)) {
				count++;
				sb.append(bufferStr);
//				printBs(bufferStr.getBytes());
//				System.out.println("读到的数据：" + bufferStr);
				sb.append("\n");
			}
			bufferStr = sb.toString();
			System.out.println("最终读取数据：\n" + bufferStr);
			
			
			//返回数据
			System.out.println("\n\n\n------------------向浏览器返回数据---------------------");
			String[] split = bufferStr.split("\r");
			String requestUrl = (split[0].split(" "))[1];
			System.out.println("请求路径为：" + requestUrl);
			String[] requestParams = requestUrl.split("\\?")[1].split("&");
			System.out.println("请求参数：" + requestParams);
			
			String responseContent = (Integer.valueOf(requestParams[0]))+
					(Integer.valueOf(requestParams[1])) + "";
			System.out.println("返回内容为:\n" + responseContent);
			OutputStream oStream = accept.getOutputStream();
			oStream.write(responseContent.getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(accept!= null) 
					accept.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}












