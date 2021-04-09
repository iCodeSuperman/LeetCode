package se.arithmetic.chapter3;

public class SequentialSearchST<Key, Value> {
    private Node first; //链表首节点
    private class Node{
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key){
        for(Node i = first; i != null; i = i.next){
            if(key.equals(i.key)){
                return i.val; //命中
            }
        }
        return null; //未命中
    }

    public void put(Key key, Value val){
        for(Node i = first; i != null; i = i.next){
            if(key.equals(i.key)){
                i.val = val; // 命中更新
                return;
            }
        }
        first = new Node(key, val, first);
    }

}
