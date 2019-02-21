package com.howie.learncode.proxy.advice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 抽象增强，将日志打印和业务逻辑解耦
 * @Date 2019-02-21
 * @Time 21:27
 */
public class AbstractEnhanceHandler implements InvocationHandler {
    /**
     * 委托对象
     */
    private Object object;
    /**
     * 代理业务处理对象
     */
    private Object advice;

    public AbstractEnhanceHandler(Object object, Object advice) {
        this.object = object;
        this.advice = advice;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //利用反射获得日志方法，并调用
        Class<?> enhanceClass = advice.getClass();
        Method beforeMethod = enhanceClass.getDeclaredMethod("before");
        beforeMethod.invoke(advice);
        Object o = method.invoke(object, args);
        Method afterMethod = enhanceClass.getDeclaredMethod("after");
        afterMethod.invoke(advice);
        return o;
    }

    /**
     * 返回一个代理对象实例
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), this);
    }
}
