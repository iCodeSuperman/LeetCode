package com.tempfiles;

import org.junit.Test;

import java.lang.ref.SoftReference;

public class CiteTest {
    @Test
    public void test01(){
        Object a = new Object();
        Object b = a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        a = null;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    @Test
    public void test02(){
        Object a = new Object();
        //软引用
        SoftReference<Object> softReference = new SoftReference<>(a);
        //a和软引用指向同一个对象
        System.out.println(a);
        //java.lang.Object@4554617c
        System.out.println(softReference.get());
        //java.lang.Object@4554617c 10
        //内存够用，软引用不会被回收
        a = null;
        System.gc();//内存够用不会自动gc，手动唤醒gc
        System.out.println(a);
        //null
        System.out.println(softReference.get());
        //java.lang.Object@4554617c 16
        //内存不够用时
        try{
            //配置Xms和Xmx为5MB
            byte[] bytes = new byte[1024*1024*1024*1024*1024];
            //设置30MB超内存
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println(a);
            //null
        }
        System.out.println(softReference.get());
        //null
    }
}
