package test004;

/**
 * @author HP
 * @date 2022/3/27
 * 多线程同时操作同一个对象
 * 买火车票例子
 */
public class TestThread4 implements Runnable{

    int tickNumbers = 10;

    @Override
    public void run(){
        while (true){

            if(tickNumbers <= 0){
                break;
            }
            // 模拟延时,但是线程就不安全了
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"-->买到了第"+tickNumbers--+"张票");
        }
    }

    public static void main(String[] args) {
        TestThread4 ticket = new TestThread4();

        new Thread(ticket,"呆呆").start();
        new Thread(ticket,"冰冰").start();
        new Thread(ticket,"旦旦").start();
    }

}
