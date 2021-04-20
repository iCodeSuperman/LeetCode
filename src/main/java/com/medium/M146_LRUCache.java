package com.medium;

import java.util.HashMap;
import java.util.Map;

public class M146_LRUCache {
}

class LRUCache{
    private Map<Integer, Node> map;
    private DoubleList cache;
    int cap;
    public LRUCache(int cap){
        this.cap = cap;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            makeRecently(key);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if(cache.getSize() == cap){
            removeLeastRecently();
        }
        addRecently(key, value);
    }

    /**
     * 使变最近使用
     */
    public void makeRecently(int key){
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    /**
     * 添加最近使用的元素
     */
    public void addRecently(int key, int value){
        Node x = new Node(key, value);
        cache.addLast(x);
        map.put(key, x);
    }

    /**
     * 删除最早的元素
     */
    public void removeLeastRecently(){
        Node x = cache.removeFirst();
        int key = x.key;
        map.remove(x);
    }

    /**
     * 删除指定key的元素
     */
    public void deleteKey(int key){
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

}

class Node{
    public int key, value;
    public Node prev, next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class DoubleList{
    public Node head, tail;
    public int size;
    public DoubleList(){
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * 删除头结点，即最近都没有用到的结点
     */
    public Node removeFirst(){
        if(head.next == tail){
            return null;
        }
        Node x = head.next;
        remove(x);
        return x;
    }

    /**
     * 添加尾结点x，即最近用过的结点
     */
    public void addLast(Node x){
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    /**
     * 删除一个x结点，但是保证x必须存在
     */
    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    /**
     * 返回链表的长度
     */
    public int getSize(){
        return this.size;
    }

}













