package lambda;

/**
 * @author HP
 * @date 2022/3/27
 * 推导lambda表达式
 */
public class TestLambda {

    //静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("我是静态内部类，我喜欢Lambda");
        }
    }

    public static void main(String[] args) {

        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        //局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("我是局部内部类，我喜欢Lambda");
            }
        }
        like = new Like3();
        like.lambda();

        //匿名内部类，没有类的名称，必须借助接口或者父类
        new ILike(){
            @Override
            public void lambda(){
                System.out.println("我是匿名内部类，我喜欢Lambda");
            }
        }.lambda();

        like =() -> {
            System.out.println("我是lambda表达式");
        };
        like.lambda();



    }
}

//定义一个函数式接口
interface ILike{
    void lambda();
}

class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("我是正常实现类，I like Lambda.");
    }
}




