package com.howie.learncode.proxy.advice;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 日志操作接口（将日志打印和业务代码分离出来）
 * @Date 2019-02-21
 * @Time 21:24
 */
public interface LogAdvice {
    void before();

    void after();
}
