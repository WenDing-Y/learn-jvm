package com.tech.jvm;

/**
 * @author xxx_xx
 *         使用jconsole监控死锁的情况
 *         实例如下
 *         名称: Thread-31
 *         状态: java.lang.Integer@d45a24e上的BLOCKED, 拥有者: Thread-34
 *         总阻止数: 2, 总等待数: 0
 *         堆栈跟踪:
 *         com.tech.jvm.SynThread.run(TestDeadLock.java:41)
 *         - 已锁定 java.lang.Integer@3a27c398
 *         java.lang.Thread.run(Thread.java:745)
 *         称: Thread-34
 *         状态: java.lang.Integer@3a27c398上的BLOCKED, 拥有者: Thread-31
 *         总阻止数: 1, 总等待数: 0
 *         堆栈跟踪:
 *         com.tech.jvm.SynThread.run(TestDeadLock.java:41)
 *         - 已锁定 java.lang.Integer@d45a24e
 *         java.lang.Thread.run(Thread.java:745)
 *         可以看出31和34线程相互等待
 * @date 2018/6/24
 */
public class TestDeadLock {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SynThread(1, 2)).start();
            new Thread(new SynThread(2, 1)).start();
        }
    }
}

class SynThread implements Runnable {

    int a;
    int b;

    public SynThread(int a, int b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public void run() {
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                System.out.print(a + b);
            }
        }
    }
}