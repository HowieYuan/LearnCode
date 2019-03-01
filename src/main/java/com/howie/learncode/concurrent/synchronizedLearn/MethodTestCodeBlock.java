package com.howie.learncode.concurrent.synchronizedLearn;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2019-03-01
 * @Time 15:54
 */
public class MethodTestCodeBlock implements Runnable {
    private static int i = 0;
    private static Object object = new Object();

    /**
     * 作用于静态方法,锁是当前class对象,也就是
     * AccountingSyncClass类对应的class对象
     */
    public void increase() {
        synchronized (object) {
            i++;
        }
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //new新实例
        Thread t1 = new Thread(new MethodTestCodeBlock());
        //new心事了
        Thread t2 = new Thread(new MethodTestCodeBlock());
        //启动线程
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(i);
    }
    /*
    20000
     */
}
