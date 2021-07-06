package cn.zhangsheng.mutithread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 张胜
 * @date 2021年07月06日10时33分创建
 * @description 练习Thread，实现多线程同步下载图片
 */
public class TestThread2 extends Thread{
    private String url;
    private String name;
    public TestThread2(String url,String name){
        this.url = url;
        this.name = name;
    }
    @Override
    public void run(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println(name + "已下载");
    }

    public static void main(String[] args) {
        TestThread2 thread1 = new TestThread2("https://dss2.bdstatic.com/kfoZeXSm1A5BphGlnYG/skin/241.jpg","name1.jpg");
        TestThread2 thread2 = new TestThread2("https://dss2.bdstatic.com/kfoZeXSm1A5BphGlnYG/skin/241.jpg","name2.jpg");
        TestThread2 thread3 = new TestThread2("https://dss2.bdstatic.com/kfoZeXSm1A5BphGlnYG/skin/241.jpg","name3.jpg");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class WebDownloader {

    public void downloader(String url, String name) {
        try{
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("IO异常，Downloader方法出现问题");
        }

    }
}