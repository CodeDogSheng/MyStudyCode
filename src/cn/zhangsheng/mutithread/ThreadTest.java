package cn.zhangsheng.mutithread;

import java.security.PrivateKey;

/**
 * @author 张胜
 * @date 2021年07月01日17时18分创建
 * @description 多线程测试
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadOne());
        Thread thread2 = new Thread(new ThreadOne());
        Thread thread3 = new Thread(new ThreadOne());
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread3.setName("线程3");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
class ThreadOne implements Runnable {
    private static int number = 1;
    @Override
    public void run() {
        printNumber();
    }
    public synchronized void printNumber(){
        while(ThreadOne.number < 10) {
            System.out.println(Thread.currentThread().getName() + " print " + ThreadOne.number);
            ThreadOne.number++;
        }
    }
}
