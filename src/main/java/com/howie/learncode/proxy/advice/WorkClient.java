package com.howie.learncode.proxy.advice;

import com.howie.learncode.proxy.dynamic.Developer;
import com.howie.learncode.proxy.dynamic.Person;
import com.howie.learncode.proxy.dynamic.ProxyHandler;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2019-02-21
 * @Time 15:07
 */
public class WorkClient {
    public static void main(String[] args) throws Exception {
        //给代理控制器传入一个委托对象，创建一个代理对象
        Person person = new AbstractEnhanceHandler(new Developer(), new LogAdviceImpl()).getProxy();
        //输出委托类的结果
        person.work();
    }
}