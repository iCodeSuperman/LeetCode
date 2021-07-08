package se.jvm.demo07;

/**
 * title: <clinit>()方法的执行顺序
 * content: Java虚拟机会保证父类的<clinit>()方法已经执行完毕，采取执行子类的<clinit>()方法。
 *          （JVM中java.lang.Object第一个被执行）
 *          也意味着父类中定义的静态语句块要优于子类的变量赋值操作。
 * @author icodeboy
 */
public class Test0706 {
    public static int A = 1;
    static class Parent0706{
        static {
            A = 2;
        }
    }

    static class Sub0706 extends Parent0706{
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub0706.B);
    }

}


