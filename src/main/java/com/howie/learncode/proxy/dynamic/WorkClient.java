package com.howie.learncode.proxy.dynamic;

import java.lang.reflect.Proxy;

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
        //给代理控制器传入一个委托对象
        ProxyHandler handler = new ProxyHandler(new Developer());
        //创建一个代理对象
        Object o = Proxy.newProxyInstance(Person.class.getClassLoader(),
                new Class<?>[]{Person.class}, handler);
        //通过动态代理对象调用
        Person subject = (Person) o;
        //输出委托类的结果
        subject.work();
    }
}