package se.basicknowledge.genericity;

import org.junit.Test;

public class GenericityTest {
    @Test
    public void t1(){
        Generic<String> generic = new Generic<>("xuyanzu");
        System.out.println(generic.getKey());
    }


    @Test
    public void t2(){

    }

}
