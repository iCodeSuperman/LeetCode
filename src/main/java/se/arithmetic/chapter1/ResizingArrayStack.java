package se.arithmetic.chapter1;

import org.junit.Test;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1]; //栈元素
    private int N = 0;  //元素数量

    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < N; i++){
            temp[i] = a[i];
        }
        a = temp;
    }
    public void push(Item item){
        //将元素添加到栈顶
        if(N == a.length){
            resize(2 * N);
        }
        a[N++] = item;
    }
    public Item pop(){
        Item item = a[--N];
        a[N] = null;
        if(N > 0 && N == a.length / 4){
            resize(a.length / 2);
        }
        return item;
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        // 支持后进先出的迭代
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    @Test
    public void t(){
        int[] a = {1, 2, 3, 4, 5};
        ResizingArrayStack<Integer> rs = new ResizingArrayStack<>();
        for (int i : a) {
           rs.push(i);
        }

        Iterator<Integer> it = rs.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();

        rs.pop();

        it = rs.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}
