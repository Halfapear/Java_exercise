package 1920;

public class Q3c {
    //接口 那还不容易
    public interface Animal {
        //接口不是方法 不需要括号
        //类也是是吧 为什么
        //—— 因为括号 () 通常表示“调用”或“参数列表”
        void animalSound();
        void sleep();
    }

    public class Pig implements Animal{
        //怎么实现？—— 就是一个override就行
        // 类声明，实现Animal接口 就一句话 不要写多了
        @Override 
        //!正确的拼写是 @Override（O大写）。这个注解告诉编译器，被注解的方法意图是重写超类或实现接口中的方法。如果拼写错误，它就不会起作用，如果方法签名不匹配，编译器可能不会给出期望的错误提示
        public void animalSound(){
            //public又忘了
            //!在 Pig 类中，animalSound() 和 sleep() 方法必须被声明为 public。如果你不写访问修饰符，它们在类中默认是包私有 (package-private) 的，这比 public 的权限低
            System.out.print("Wee Wee");
        }

        @Override
        public void sleep() {
            System.out.println("Zzz");
        }
    }

    //懒得新开了
    //==================================================================  
    public class TestingInterface {  
        public static void main(String[] args){
            Pig pig = new Pig();
            //嘶 为什么这里是Pig() 有括号 —— 原因在于 new Pig() 这一部分是在调用 Pig 类的构造函数 (Constructor) 来创建一个新的 Pig 对象实例
            //这里其实相当于初始化 怎么初始化呢 得用构造函数初始化
            //如果你的类中没有显式地编写任何构造函数——通常会为你自动提供一个默认的、无参数的构造函数
            pig.animalSound();


        }
    }   
}
