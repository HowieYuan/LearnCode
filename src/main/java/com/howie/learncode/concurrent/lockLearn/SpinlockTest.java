package com.howie.learncode.concurrent.lockLearn;


import com.howie.learncode.concurrent.synchronizedLearn.MethodTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2019-01-08
 * @Time 15:29
 */
public class SpinlockTest implements Runnable {
    //共享资源(临界资源)
    private static int i = 0;
    /**
     * 自旋锁
     *
     * 对于同一个对象，使用的是同一个自旋锁，因此可以达到线程安全
     * 对于不同对象，使用的是不同的自旋锁，因此如果要实现线程安全，需要改为静态变量
     */
    private Spinlock lock = new Spinlock();

    /**
     * synchronized 修饰实例方法
     */
    public void increase() {
        lock.lock();
        try {
            i++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SpinlockTest instance = new SpinlockTest();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
    /**
     * 输出结果:
     * 2000000
     */
}
