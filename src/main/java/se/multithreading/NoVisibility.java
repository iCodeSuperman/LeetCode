package se.multithreading;

public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class Reader extends Thread{
        @Override
        public void run(){
            while(!ready){
                Thread.yield();
            }
            System.out.println(number);

        }
    }
    public static void main(String[] args){
        new Reader().start();
        number = 42;
        ready = true;
    }
}
