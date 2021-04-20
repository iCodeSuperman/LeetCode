package com.tempfiles;

import org.junit.Test;

public class StringTest {
    @Test
    public void test01(){
        String s1 = "1";
        String s2 = new String("1");
        System.out.println("s1 == s2 " + (s1 == s2));
        s2 = s2.intern();
        System.out.println("s1 == s2 " + (s1 == s2));
    }

    @Test
    public void test02(){
        String s1 = "古时的风筝";
        String s2 = "古时的风筝";
        String a = "古时的";

        String s3 = new String(a + "风筝");
        String s4 = new String(a + "风筝");
        System.out.println(s1 == s2); // 【1】 true
        System.out.println(s2 == s3); // 【2】 false
        System.out.println(s3 == s4); // 【3】 false
        s3.intern();
        System.out.println(s2 == s3); // 【4】 false
        s3 = s3.intern();
        System.out.println(s2 == s3); // 【5】 true
        s4 = s4.intern();
        System.out.println(s3 == s4); // 【6】 true
    }
}
