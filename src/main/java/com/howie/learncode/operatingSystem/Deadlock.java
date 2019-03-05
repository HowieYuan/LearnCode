package com.howie.learncode.operatingSystem;


import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 死锁演示
 * @Date 2019-02-17
 * @Time 16:03
 */
public class Deadlock {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();

        Thread threadA = new Thread(() -> {
            System.out.println("线程 A 开始");
            synchronized (a) {
                System.out.println("获得锁 a");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println("获得锁 b");
                }
            }
        });

        Thread threadB = new Thread(() -> {
            System.out.println("线程 B 开始");
            synchronized (b) {
                System.out.println("获得锁 b");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println("获得锁 a");
                }
            }
        });
        threadA.start();
        threadB.start();

    }
}
