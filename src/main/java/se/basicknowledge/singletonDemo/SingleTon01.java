package se.basicknowledge.singletonDemo;

/**
 * 饿汉式
 */
public class SingleTon01 {
    /**
     * 类加载的时候就初始化
     */
    private static final SingleTon01 singleTon01 = new SingleTon01();

    private SingleTon01(){}

    public static SingleTon01 getSingleTon01(){
        return singleTon01;
    }

}
