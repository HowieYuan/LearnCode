package com.howie.learncode.concurrent.deadlock;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 避免死锁：破坏循环等待条件
 * @Date 2019-03-09
 * @Time 16:03
 */
class Account {
    private int id;
    private int balance;

    // 转账
    void transfer(Account target, int amt) {
        //按账户的id决定顺序
        Account left = this;
        Account right = target;

        if (this.id > target.id) {
            left = target;
            right = this;
        }

        // 锁定序号小的账户
        synchronized (left) {
            // 锁定序号大的账户
            synchronized (right) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
}
