package com.howie.learncode.proxy.status;

import com.howie.learncode.proxy.dynamic.Person;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 静态代理类
 * @Date 2019-02-21
 * @Time 17:47
 */
public class StatusProxy {
    private Person person;

    /**
     * 静态代理一个类只能满足一种类型的需要（Person），所以需要创建许多个代理类
     * @param person
     */
    public StatusProxy(Person person) {
        this.person = person;
    }

    public void excute() {
        System.out.println("工作前代理帮我做的事情");
        person.work();
        System.out.println("工作后代理帮我做的事情");
    }
}
