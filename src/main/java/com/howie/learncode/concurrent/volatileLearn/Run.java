package com.howie.learncode.concurrent.volatileLearn;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2019-01-06
 * @Time 15:35
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        RunThread runThread = new RunThread();
        runThread.start();
        Thread.sleep(4000);
        System.out.println("——————————————更改——————————————");
        runThread.setRunning(false);
    }
}
