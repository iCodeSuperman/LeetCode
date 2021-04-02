package com.basicKnowledge;

/**
 * 类加载顺序：
 *  1. 单个类
 *      静态初始化块
 *      静态成员初始化（直接赋值，或者只能调用静态方法）
 *      非静态初始化块
 *      类成员变量
 *      构造方法
 *
 *  2. 父子类继承
 *      父类静态初始化块，静态成员初始化
 *      子类静态初始化块，静态成员初始化
 *      父类非静态初始化块
 *      父类成员变量
 *      父类构造方法
 *      子类非静态初始化块
 *      子类成员变量
 *      子类构造方法
 *
 *  3. 特别注意
 *     [1]永远是main方法所在类先加载，即静态初始化块，静态成员初始化，静态方法
 *        例如main()方法中，先打印，再去实例化class类
 *     [2]但是，由于ClassInit没被实例化，所以非静态初始化块和构造方法不执行
 */

public class ClassInit {
    static {
        System.out.println("Static initialization of Main");
    }

    {
        System.out.println("Instance initialization of Main");
    }

    public ClassInit() {
        System.out.println("Constructor of Main");
    }

    public static void main(String[] args) {
        System.out.println("hello, this main() from ClassInit");
        new Class3();
    }
}

class Class1 {
    static {
        System.out.println("Static initialization of Class1");
    }

    {
        System.out.println("Instance initialization of Class1");
    }

    int i = 10;
    int j;
    static int k = printMessage("hello, I'm Class1");

    static public int printMessage(String  s){
        System.out.println(s);
        return 20;
    }

    Class1() {
        System.out.println("Constructor of Class1");
        System.out.println("i = " + i + ", j = " + j);
        j = 30;
    }
}

class Class2 extends Class1 {
    static {
        System.out.println("Static initialization of Class2");
    }

    {
        System.out.println("Instance initialization of Class2");
    }

    static int m = printMessage("hello, I'm Class2");

    Class2() {
        System.out.println("Constructor of Class2");
        System.out.println("m = " + m + ", j = " + j);
    }
}

class Class3 extends Class2 {
    static {
        System.out.println("Static initialization of Class3");
    }

    {
        System.out.println("Instance initialization of Class3");
    }

    Class3() {
        System.out.println("Constructor of Class3");
    }
}

