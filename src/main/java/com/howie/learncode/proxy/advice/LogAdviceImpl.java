package com.howie.learncode.proxy.advice;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2019-02-21
 * @Time 21:25
 */
public class LogAdviceImpl implements LogAdvice {
    @Override
    public void before() {
        System.out.println("日志打印：开始工作！！");
    }

    @Override
    public void after() {
        System.out.println("日志打印：结束工作！！");
    }
}
