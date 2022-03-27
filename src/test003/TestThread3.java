package test003;

import test001.TestThread;

/**
 * @author HP
 * @date 2022/3/27
 * 实现Runnable接口
 */
public class TestThread3 implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello Thread." + i);
        }
    }

    public static void main(String[] args) {

        // 接口实现类
        TestThread3 testThread3 = new TestThread3();
        new Thread(testThread3).start();


        for (int i = 0; i < 2000; i++) {
            System.out.println("Hello World." + i);
        }
    }
}
