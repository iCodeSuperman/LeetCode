package se.basicknowledge.reflection;

import com.sun.jdi.Bootstrap;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassDemo {
    @Test
    public void t1(){
        Employee e = new Employee();
        System.out.println(e.getClass().getName());
        System.out.println(e.getName());
    }

    @Test
    public void t2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class ec = Class.forName("se.basicknowledge.reflection.Employee");
        System.out.println(ec);
        Employee o = (Employee)ec.getConstructor().newInstance();
        System.out.println(o.getName());

    }

    /**
     * 四种获取Class对象的方法
     */
    @Test
    public void t3() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 不会初始化
        Class c1 = Employee.class;
        System.out.println(c1);

        // 会初始化
        Class c2 = Class.forName("se.basicknowledge.reflection.Employee");
        Employee eins = (Employee)c2.newInstance();
        System.out.println(eins.getName());

        // 必定初始化，都new了
        Employee e = new Employee();
        Class c3 = e.getClass();

        // 不会初始化
    }

    @Test
    public void t5() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class targetClass = Class.forName("se.basicknowledge.reflection.Employee");
        Employee e = (Employee)targetClass.newInstance();


        System.out.println(" --- 输出类中自定义的所有方法 --- ");
        // getMethods() 会返回所有的，包括来自父类Object中的
        for (Method method : targetClass.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

        System.out.println(" --- 操作公有方法 ---");
        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(e, "我真的很帅！");

        System.out.println(" --- 操作字段 ---");
        Field name = targetClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(e, "刘德华");

        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(e);


    }

}

class Employee {
    static{
        System.out.println("Employee static 代码块 ！");
    }
    private String name;
    private int age;

    public Employee(){
        this("xuyanzu", 18);
    }

    public Employee(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void publicMethod(String s){
        System.out.println("这是一个公有方法，输入的参数为 "+ s);
    }

    private void privateMethod(){
        System.out.println("私有方法 " + name);
    }
}