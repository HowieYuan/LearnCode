package com.howie.learncode.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 动态代理调用处理类
 * @Date 2019-02-21
 * @Time 17:32
 */
public class ProxyHandler implements InvocationHandler {

    private Object object;

    /**
     * 控制器类传入的是 Object 类型，因此这个类即可满足众多代理需求一致的类的需求
     * @param object
     */
    public ProxyHandler(Object object) {
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

    /**
     * 返回一个代理对象实例
     */
    public <T> T getProxy() {
        return (T)Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), this);
    }
}
