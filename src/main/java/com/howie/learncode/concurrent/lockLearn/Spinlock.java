package com.howie.learncode.concurrent.lockLearn;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 自旋锁
 * @Date 2019-01-08
 * @Time 21:26
 */
public class Spinlock {
    private AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        /*
         CAS 思想：
         当 AtomicReference 里面的值为 null，将当前线程设置为 AtomicReference 的值
         如果当前不为 null，则不断自旋循环
         */
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        /*
        CAS 思想：
        解锁操作，当 AtomicReference 里面的值为当前线程，则可以无误地改为 null，释放自旋锁
         */
        atomicReference.compareAndSet(thread, null);
    }
}
