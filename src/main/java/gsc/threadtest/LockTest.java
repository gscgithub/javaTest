package gsc.threadtest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	public static void main(String[] args) {
		
		new Thread(new ThreadTest2()).start();
		new Thread(new ThreadTest2()).start();
		new Thread(new ThreadTest2()).start();
	}
}

class ThreadTest2 implements Runnable{

	public volatile static int count = 0;
	public static ReentrantLock lock = new ReentrantLock();
	public static Condition con0 = lock.newCondition();
	public static Condition con1 = lock.newCondition();
	@Override
	public void run() {
		
		int num = count++;
		
		lock.lock();
		
		for(int i = 0;i < 10;i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("num:" + num + " run");
			
			if( num == 0) {
				try {
					con0.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else if( num == 1) {
				try {
					con1.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				con1.signal();
			}
		}
		
		lock.unlock();
		
	}
	
}
