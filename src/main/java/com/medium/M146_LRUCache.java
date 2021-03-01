package com.medium;

import java.util.HashMap;
import java.util.Map;

public class M146_LRUCache {

    private Map<Integer, DLNode> map;
    private DoubleList cache;
    private int cap;


    public M146_LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new DoubleList();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            makeRecently(key); //不要忘记提升为最近最长使用
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
        //System.out.println(cache.getSize());
        if(cap == cache.getSize()){
            removeLeastRecently();
        }
        addRecently(key, value);
    }

    //1. 将某个key提升为最近最长使用
    public void makeRecently(int key){
        if(map.containsKey(key)){
            DLNode x = map.get(key);
            cache.remove(x);
            cache.addLast(x);
        }
    }

    // 2. 添加最近使用的结点
    public void addRecently(int key, int val){
        DLNode x = new DLNode(key, val);
        cache.addLast(x);
        map.put(key, x);
    }

    // 3. 删除一个key
    public void deleteKey(int key){
        DLNode x = map.get(key);
        cache.remove(x);
        map.remove(x);
    }

    // 4. 删除最久没有使用的元素
    public void removeLeastRecently(){
        DLNode x = cache.removeFirst();
        map.remove(x.key);
    }

}


// 双向链表结点
class DLNode{
    public int key, value;
    public DLNode next, prev;
    public DLNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class DoubleList{
    private DLNode head, tail;
    private int size;
    public DoubleList(){
        head = new DLNode(0, 0);
        tail = new DLNode(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 将结点x插入到链表末尾
    public void addLast(DLNode x){
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size ++;
    }

    // 将结点x删除
    public void remove(DLNode x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size --;
    }

    // 删除链表头结点，并返回值
    public DLNode removeFirst(){
        if(head.next == tail){
            return null;
        }

        DLNode first = head.next;
        remove(first);
        return first;
    }

    public int getSize(){
        return size;
    }

}













