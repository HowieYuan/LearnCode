package com.howie.learncode.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 动态代理调用处理类
 * @Date 2019-02-21
 * @Time 17:32
 */
public class PersonHandler implements InvocationHandler {

    private Object object;

    public PersonHandler(Object object) {
        this.object = object;
    }

    /**
     * 在代理实例调用方法时，方法调用被编码分派到调用处理程序的 invoke 方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("工作前代理帮我做的事情");
        //代理实例调用委托对象的方法
        Object o = method.invoke(object, args);
        System.out.println("工作后代理帮我做的事情");
        return o;
    }
}
