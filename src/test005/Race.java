package test005;

/**
 * @author HP
 * @date 2022/3/27
 * 模拟龟兔赛跑
 */
public class Race implements Runnable{


    private static String winner;

    @Override
    public void run(){
        for (int i = 0; i <= 100 ; i++) {

            if (Thread.currentThread().getName() == "兔子" && i%5 == 0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag = gameOver(i);
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"米");
        }
    }

    private boolean gameOver(int steps){
        if(winner != null){
            return true;
        }

        if(steps >= 100){
            winner = Thread.currentThread().getName();
            System.out.println("Winner is "+winner);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }

}
