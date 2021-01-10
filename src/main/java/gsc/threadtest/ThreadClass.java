package gsc.threadtest;

public class ThreadClass {
	
	public static final long sleepTime = 1;
	public static final long threadNum = 10;
	public static boolean isError = false;

	public static void main(String[] args) {
		
//		Thread1 thread1 = new Thread1();
//		thread1.start();
//		try {
//			thread1.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("end main");
//		for (int i = 0; i < 10000; i++) {
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		Thread2 thread2 = new Thread2();
//		thread2.start();
////		while (!ThreadClass.isError) {
////			
////		}
//		try {
//			Thread.sleep(50);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		thread2.stop();
//		System.out.println("stop");
//		Thread thread = new Thread4();
//		thread.start();
//		try {
//			thread.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		thread = new Thread4();
//		thread.start();
//		try {
//			thread.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		long startTime = System.currentTimeMillis();
//		for(int i = 0 ; i < 1000 ; i++) {
//			Thread thread = new Thread4();
//			thread.start();
//		}
//		long endTime = System.currentTimeMillis();
//		System.out.println(endTime - startTime);
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
//                new ArrayBlockingQueue<Runnable>(5));
//		Thread4 thread4 = new Thread4();
//		for(int i =0 ;i<5;i++) {
//			executor.execute(thread4);
//			System.out.println("i:" + i);
//		}
//		System.out.println("end");
//		executor.shutdown();
//		Thread4 thread4 = new Thread4();
//		try {
//			thread4.wait();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		thread4.notify();
//		thread4.interrupt();
//		Thread5 thread5 = new Thread5();
//		Thread thread1 = new Thread(thread5);
//		Thread thread2 = new Thread(thread5);
//		thread1.start();
//		thread2.start();
//		UniqueThreadIdGenerator.getCurrentThreadId();
		Thread thread = new Thread(new Thread5());
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.stop();
		System.out.println("----------------------------------stop----------------------");
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}

class Thread1 extends Thread {
	public void run() {
		System.out.println("start");
		try {
			System.out.println("try");
			int i = 1;
			if(i == 1) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("exception");
			return;
		}
		System.out.println("end");
	}
}
class Thread2 extends Thread {
	public void run() {
		Thread3 [] ts = new Thread3[(int) ThreadClass.threadNum];
		for (int i = 0; i < ThreadClass.threadNum; i++) {
			Thread3 thread3 = new Thread3();
			thread3.setDaemon(true);
			thread3.start();
			ts[i] = thread3;
		}
		System.out.println("create thread finished,unm:" + ThreadClass.threadNum);
		for (int i = 0; i < ts.length; i++) {
			try {
				ts[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("all finished");
	}
}
class Thread3 extends Thread {
	public void run() {
		for (int i = 0; i < 10000; i++) {
			try {
				if (i==5000) {
					ThreadClass.isError = true;
					throw new Exception();
				}
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(Thread.currentThread().getName() + " exception");
				return;
			}
		}
		System.out.println(Thread.currentThread().getName() + " finished");
	}
}

class Thread4 extends Thread {
	
	private volatile int i = 0;
	ThreadLocal<String> t = null;
//	synchronized{
//		System.out.println();
//	}
	public synchronized void synmethod() {
		System.out.println();
	}
	public void run() {
		t.get();
//		t.set(arg0);
		i++;
		System.out.println(i);
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notify();
	}
}
class Thread5 implements Runnable {

	@Override
	public void run() {
		System.out.println("thread5");
		Thread[] ts = new Thread[5];
		for(int i =0;i<5;i++) {
			Thread thread = new Thread(new Thread6());
			thread.setDaemon(true);
			thread.start();
			ts[i] = thread;
		}
		for(int i =0;i<5;i++) {
			try {
				ts[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("end");
	}
	
}
class Thread6 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
		
	}
}



