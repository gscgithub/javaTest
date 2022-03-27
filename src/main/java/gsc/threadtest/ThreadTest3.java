package gsc.threadtest;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest3 {

    public static void main(String[] args) {
//        test2();
//        test3();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(1626811730781L);
        System.out.println(date);
        System.out.println(simpleDateFormat.format(date));
    }

    @Test
    public static void test5() {
        synchronized (ThreadTest3.class) {

        }
    }

    //处于time_waiting状态的线程能唤醒吗
    @Test
    public static void test4() {
//        Object lock = new Object();
        new ReentrantLock().unlock();
//        LockSupport lockSupport = new LockSupport();
        Thread t1 = new Thread(() -> {
            System.out.println("thread1 wait before");
            try {
                Thread.sleep(10000 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1 wait after");
        });
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        System.out.println("main end");
    }

    //处于time_waiting状态的线程能唤醒吗
    @Test
    public static void test3() {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            System.out.println("thread1 wait before");
            try {
                Thread.sleep(10000 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1 wait after");
        });
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        System.out.println("main end");
    }

    //处于time_waiting状态的线程能唤醒吗
    @Test
    public static void test2() {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            System.out.println("thread1 wait before");
            synchronized (lock) {
                try {
                    lock.wait(10000 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("thread1 wait after");
        });
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock) {
            lock.notifyAll();
        }
//        t1.interrupt();
        System.out.println("main end");
    }

    @Test
    public void test1() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }
    }
}
