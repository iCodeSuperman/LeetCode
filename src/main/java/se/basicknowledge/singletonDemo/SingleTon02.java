package se.basicknowledge.singletonDemo;

/**
 * 带双重检查的懒汉式
 */
public class SingleTon02 {
    private static volatile SingleTon02 singleTon02 = null;

    private SingleTon02(){

    }

    public static SingleTon02 getSingleTon02(){
        if(singleTon02 == null){
            synchronized (SingleTon02.class){
                if(singleTon02 == null){
                    singleTon02 = new SingleTon02();
                }
            }
        }
        return singleTon02;
    }

}
