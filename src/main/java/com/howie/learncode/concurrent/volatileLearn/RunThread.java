package com.howie.learncode.concurrent.volatileLearn;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2019-01-06
 * @Time 15:33
 */
public class RunThread extends Thread {
    private volatile boolean isRunning = true;

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        int i = 1;
        while (isRunning) {
            i++;
            System.out.println(i);
        }
        System.out.println(i);
    }
}
