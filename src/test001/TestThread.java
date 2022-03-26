package test001;

/**
 * @author HP
 * @date 2022/3/26
 */
public class TestThread extends Thread{

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello Thread." + i);
        }
    }

    public static void main(String[] args) {
        TestThread testThread1 = new TestThread();
        testThread1.start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("Hello World." + i);
        }
    }

}
