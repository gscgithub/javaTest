package gsc.threadtest;

import gsc.threadtest.PublicClass.InnerClass;
import gsc.threadtest.PublicClass.StaticClass;

public class ThreadTest1 {

	
	public static void main(String[] args) {
		
//		test1();
//		test2();
//		test3();
//		test4();
//		test5();
		test6();
	}
	
	//测试内部类特性
	public static void test6() {
		PublicClass publicClass = new PublicClass();
		PublicClass.InnerClass iClass = publicClass.new InnerClass();
		iClass.print();
		PublicClass.StaticClass staticClass = new PublicClass.StaticClass();
		
	}
	//产生死锁，练习jps和jstack命令
	public static void test5() {
		try {
			DealThread t1 = new DealThread();
			t1.setFlag("a");
			Thread thread1 = new Thread(t1);
			thread1.start();
			Thread.sleep(100);
			t1.setFlag("b");
			Thread thread2 = new Thread(t1);
			thread2.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//验证 synchronize方法使用的对象监视器是this对象
	public static void test4() {
		
//		MyTask task = new MyTask();
//		new MyThread1(task).start();
//		new MyThread2(task).start();
	}
	//验证，在线程sleep时，调用interrupt方法抛中断异常
	//先interrupt后sleep，结果一样
	public static void test3() {
		Thread t1 = new ThreadTest1_1();
		t1.start();
		t1.interrupt();
//		try {
//			Thread.sleep(200);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		t1.interrupt();
	}
	
	//验证结果：线程sleep时，isAlive仍然返回true;
	public static void test2() {
		
		Thread t1 = new ThreadTest1_1();
		System.out.println("before run:"  + t1.isAlive());
		t1.start();
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("after invoke run:"   + t1.isAlive());
		}
	}

	public static void test1() {
		new ThreadTest1_1().testGetName();
	}
	
}

class ThreadTest1_1 extends Thread{
	
	public void testGetName() {
		System.out.println(this.getName());
	}
	
	@Override
	public void run() {
		try {
			System.out.println("run bgein");
			System.out.println(this.getPriority());
			for(int i=0;i<100000;i++){
				System.out.println(i);
			}
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			System.out.println("run catch");
			e.printStackTrace();
		}
		System.out.println("sleep over");
	}
}

/*class MyTask {
	public synchronized void synMethod() {
		for(int i = 0;i < 10000; i++)
		System.out.println("synMethod");
	}
	public void innerSynMethod() {
		synchronized (this) {
			for(int i = 0;i < 10000; i++)
			System.out.println("innerSynMethod");
		}
		
	}
}*/

class MyThread1 extends Thread{
	private MyTask task;

	public MyThread1(MyTask task) {
		super();
		this.task = task;
	}

	public void setTask(MyTask task) {
		this.task = task;
	}
	
	@Override
	public void run() {
		super.run();
//		task.synMethod();
	}
}

class MyThread2 extends Thread{
	private MyTask task;

	public MyThread2(MyTask task) {
		super();
		this.task = task;
	}

	public void setTask(MyTask task) {
		this.task = task;
	}
	
	@Override
	public void run() {
		super.run();
//		task.innerSynMethod();
	}
}

class DealThread implements Runnable {
	public String username;
	public Object lock1 = new Object();
	public Object lock2 = new Object();
	public void setFlag(String username) {
		this.username = username;
	}

	public void run() {
		if(username.equals("a")) {
			synchronized (lock1) {
				try {
					System.out.println("username = " + username);
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("按lock1-》lock2代码顺序执行了");
				}
			}
		}
		if(username.equals("b")) {
			synchronized (lock2) {
				try {
					System.out.println("username = " + username);
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock1) {
					System.out.println("按lock2-》lock1代码顺序执行了");
				}
			}
		}
	}
	
}

class PublicClass {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	class InnerClass {
		private String age;

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}
		public void print(){
			System.out.println("username = " + username);
		}
	}
	static class StaticClass {
		
	}
}

