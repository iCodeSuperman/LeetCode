package se.basicknowledge;

import org.junit.Test;

public class ThisPointKey {
    @Test
    public void test(){
        ThisClass obj = new ThisClass();
        obj.print();
    }
}

class ThisClass{
    private String name;
    private Integer age;

    public ThisClass(){
        this("徐彦祖");
    }

    public ThisClass(String name){
        this(name, 18);
    }

    public ThisClass(String name, int age){
       this.name = name;
       this.age = age;
    }

    public void print(){
        System.out.println("hello, I'm "+ name +", my age is " + age);
    }
}