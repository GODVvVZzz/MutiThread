package test002;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author HP
 * @date 2022/3/27
 * 实现多线程同步下载图片
 */
public class TestThread2 extends Thread{

    private String url;
    private String name;

    public TestThread2(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run(){

        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件："+name);
    }

    public static void main(String[] args) {
        String url1 = "http://img.netbian.com/file/2022/0203/002826GbHNc.jpg";
        String url2 = "http://img.netbian.com/file/2022/0129/151926UJ9p7.jpg";
        String url3 = "http://img.netbian.com/file/2022/0129/010038Z1IRN.jpg";

        TestThread2 t1 = new TestThread2(url1, "春节灯笼壁纸.jpg");
        TestThread2 t2 = new TestThread2(url2, "虎年壁纸.jpg");
        TestThread2 t3 = new TestThread2(url3, "除夕壁纸.jpg");

        t1.start();
        t2.start();
        t3.start();

    }


    class WebDownloader{
        public void downloader(String url, String name){
            try {
                FileUtils.copyURLToFile(new URL(url),new File(name));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IO异常，downloader方法出现问题");
            }
        }
    }

}
