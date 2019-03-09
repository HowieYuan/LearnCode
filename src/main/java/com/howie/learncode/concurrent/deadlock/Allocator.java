package com.howie.learncode.concurrent.deadlock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 避免死锁：破坏占用且等待条件
 * @Date 2019-03-09
 * @Time 16:03
 */
class Allocator {
    private List<Object> als = new ArrayList<>();

    // 一次性申请所有资源
    synchronized boolean apply(Object from, Object to) {
        if (als.contains(from) || als.contains(to)) {
            return false;
        } else {
            als.add(from);
            als.add(to);
        }
        return true;
    }

    // 归还资源
    synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
    }
}

class AccountForAllocator {
    // allocator 应该为单例
    private Allocator allocator;
    private int balance;

    // 转账
    void transfer(AccountForAllocator target, int amt) throws InterruptedException {
        // 一次性申请转出账户和转入账户，直到成功
        while (!allocator.apply(this, target)) {
            Thread.sleep(10);
        }
        try {
            // 锁定转出账户
            synchronized (this) {
                // 锁定转入账户
                synchronized (target) {
                    if (this.balance > amt) {
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        } finally {
            allocator.free(this, target);
        }
    }
}
