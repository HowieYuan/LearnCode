package com.howie.learncode.proxy.status;

import com.howie.learncode.proxy.dynamic.Developer;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2019-02-21
 * @Time 17:55
 */
public class Client {
    public static void main(String[] args) {
        StatusProxy proxy = new StatusProxy(new Developer());
        proxy.excute();
    }
}
