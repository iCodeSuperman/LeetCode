package se.basicknowledge;

import org.junit.Test;

public class StringConstantPool {
    /**
     * String.intern() 方法：一个Native方法
     *  1. 如果常量池包含一个等于此String对象内容的字符串，返回常量池中该字符串的引用。
     *  2. 如果不包含： JDK1.7以及之后的处理方式是在常量池中记录此字符串的引用，并返回。 1.7之前是创建并返回创建字符串的引用
     *
     * 直接使用双引号声明的String对象会直接存在常量池中
     */

    @Test
    public void t1(){
        // 创建两个，"1" 直接存在常量池中；s指向new出来，放在堆中的String对象
        String s = new String("1");
        // 返回常量池中"1"的引用，但是没有对象接收
        s.intern();
        // 返回常量池中"1"的引用
        String s2 = "1";
        // false
        System.out.println(s == s2);

        // 创建4个，"2"直接存常量池，含两个不同的String对象"2"，一个s3指向的String对象"22"
        String s3 = new String("2") + new String("2");
        // 将s3创建的String对象"22"的引用，保存到常量池
        s3.intern();
        // 返回常量池中引用，即s3创建的String对象"22"的引用
        String s4 = "22";
        //true
        System.out.println(s3 == s4);
    }

    @Test
    public void t2(){
        // 创建两个，"1" 直接存在常量池中；s指向new出来，放在堆中的String对象
        String s = new String("1");
        // 返回常量池"1"的引用
        String s2 = "1";
        // 返回常量池"1"的引用，但是没有接受
        s.intern();
        // false
        System.out.println(s == s2);

        // 创建4个，"2"直接存常量池，含两个不同的String对象"2"，一个s3指向的String对象"22"
        String s3 = new String("2") + new String("2");
        // 在常量池中创建"22"，并返回引用
        String s4 = "22";
        // 返回常量池中"22"的引用
        s3.intern();
        //false
        System.out.println(s3 == s4);
    }
}
