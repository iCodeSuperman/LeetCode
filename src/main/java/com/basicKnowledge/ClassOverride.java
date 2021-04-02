package com.basicKnowledge;

import org.junit.Test;

/**
 * 重载和重写
 */
public class ClassOverride {
    @Test
    public void test(){
        ClassOverride2 c2 = new ClassOverride2();
        c2.method(2);

    }
}
class ClassOverride1 {
    public void method(int num) {
    }
}

class ClassOverride2 extends ClassOverride1 {
    @Override
    public void method(int num) {
        System.out.println(num);
    }

}

