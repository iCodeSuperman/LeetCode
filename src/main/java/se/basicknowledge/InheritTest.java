package se.basicknowledge;

import org.junit.Test;

import java.sql.SQLOutput;

public class InheritTest {
    public void t1(){
        System.out.println("t1");
    }
    public void t2(){
        System.out.println("t2");
    }

    @Test
    public void t(){
        InheritTest2 i2 = new InheritTest2();
        i2.t1();
    }
}

class InheritTest2 extends InheritTest{

}
