package se.jvm.demo07;

/**
 * title: 非法前向引用变量
 * content: 静态语句块中，只能访问到定义在静态语句块之前的变量；
 *          定义在它之后的变量，可以在静态语句块中赋值，但是不能访问。
 * @author icodeboy
 */
public class Test0705 {
    static {
        // 给变量赋值可以正常通过编译
        i = 0;
        // 这句编译器会提示："非法前向引用变量"
        // System.out.println(i);
    }
    static int i = 1;

    public static void main(String[] args) {
        System.out.println(i);
    }
}
