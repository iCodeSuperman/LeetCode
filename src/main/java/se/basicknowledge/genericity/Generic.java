package se.basicknowledge.genericity;

public class Generic <T>{
    private T key;
    public Generic(T key){
        this.key = key;
    }

    public T getKey(){
        return key;
    }
}
