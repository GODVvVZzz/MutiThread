package test008;

/**
 * @author HP
 * @date 2022/3/28
 *测试生产者消费者模型 -->利用缓冲区解决：管程法
 *
 * 生产者，消费者，产品，缓冲区
 */
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }

}

//生产者
class Productor extends Thread{

    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    //生产
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}

//消费者
class Consumer extends Thread{

    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    //消费
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了-->"+container.pop().id+"只鸡");
        }
    }
}

//产品
class Chicken{

    int id;

    public Chicken(int id){
        this.id = id;
    }
}

//缓冲区
class SynContainer{

    //容器
    Chicken[] chickens = new Chicken[10];
    //容器计数器
    int count = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken){
        //如果容器满了，生产者需要等待消费者消费
        if (count==chickens.length){
            //通知消费者消费,生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果没有满，产品放入容器
        chickens[count] = chicken;
        count++;
        //可以通知消费者消费
        this.notifyAll();

    }

    //消费者消费
    public synchronized Chicken pop(){
        //判断是否能消费
        if(count==0){
            //等待生产者
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //消费
        count--;
        //拿出一个鸡
        Chicken chicken = chickens[count];

        //吃了一只，可以通知消费者生存了
        this.notifyAll();
        return chicken;
    }
}
