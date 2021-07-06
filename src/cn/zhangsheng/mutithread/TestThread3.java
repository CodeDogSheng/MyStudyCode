package cn.zhangsheng.mutithread;

/**
 * @author 张胜
 * @date 2021年07月06日11时14分创建
 * @description 实现Runnable接口创建线程(静态代理模式)
 */
public class TestThread3 implements Runnable{
    @Override
    public void run(){
        for(int i = 0;i < 200;i++){
            System.out.println("thread - myself - " + i);
        }
    }

    public static void main(String[] args) {
        TestThread3 thread3 = new TestThread3();
        //1.
        //Thread thread = new Thread(thread3);
        //thread.start();
        //same as 1 we make them onr sentence
        new Thread(thread3).start();
        for(int i = 0;i < 200;i++){
            System.out.println("thread - main - " + i);
        }
    }
}
