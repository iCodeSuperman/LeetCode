package se.basicknowledge.singletonDemo;

import org.junit.Test;

/**
 * 静态静态内部类
 */
public class SingleTon03 {
    private static class SingleTon03Hodler{
        private static final SingleTon03 singleTon03 = new SingleTon03();
    }

    private SingleTon03(){

    }

    public static SingleTon03 getSingleTon03(){
        return SingleTon03Hodler.singleTon03;
    }


}
