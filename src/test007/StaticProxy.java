package test007;

/**
 * @author HP
 * @date 2022/3/27
 * 静态代理模式
 * 真实对象和代理对象都要实现同一个接口
 * 代理对象必须代理真实角色
 * 好处:
 *      代理对象可以做很多真实对象做不了的事
 *      真实对象专注做自己的事情
 */
public class StaticProxy {

    public static void main(String[] args) {

        //婚庆公司相当于Thread，结婚的人相当于实现runnable接口的类
        new Thread( () -> System.out.println("我爱你")).start();
        new WeddingCompany(new You()).happyMarry();
        
        //WeddingCompany weddingCompany = new WeddingCompany(new You());
        //weddingCompany.happyMarry();
    }


}

interface Marry{
    
    void happyMarry();
}

/**
 *真实角色
 */
class You implements Marry{
    @Override
    public void happyMarry(){
        System.out.println("正在结婚中");
    }
}


/**
 * 代理角色
 */
class WeddingCompany implements Marry{

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();
        after();
    }

    private void after() {
        System.out.println("收拾现场");
    }

    private void before() {
        System.out.println("布置现场");
    }
}
