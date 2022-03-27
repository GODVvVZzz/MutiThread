package test006;

import org.apache.commons.io.FileUtils;
import test002.TestThread2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @author HP
 * @date 2022/3/27
 * 实现Callable接口
 */
public class TestCallable implements Callable<Boolean> {

    private String url;
    private String name;

    public TestCallable(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件："+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String url1 = "http://img.netbian.com/file/2022/0203/002826GbHNc.jpg";
        String url2 = "http://img.netbian.com/file/2022/0129/151926UJ9p7.jpg";
        String url3 = "http://img.netbian.com/file/2022/0129/010038Z1IRN.jpg";

        TestCallable t1 = new TestCallable(url1, "春节灯笼壁纸.jpg");
        TestCallable t2 = new TestCallable(url2, "虎年壁纸.jpg");
        TestCallable t3 = new TestCallable(url3, "除夕壁纸.jpg");

        //创建执行任务：
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行：
        Future<Boolean> result1 = ser.submit(t1);
        Future<Boolean> result2 = ser.submit(t2);
        Future<Boolean> result3 = ser.submit(t3);

        //获取结果：
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        //关闭服务：
        ser.shutdownNow();

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
