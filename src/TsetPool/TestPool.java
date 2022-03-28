package TsetPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author HP
 * @date 2022/3/28
 */
public class TestPool {

    public static void main(String[] args) {
        //创建服务，创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        service.shutdownNow();
    }
}

class MyThread implements Runnable{
    @Override
    public void run(){

        System.out.println(Thread.currentThread().getName());

    }
}
