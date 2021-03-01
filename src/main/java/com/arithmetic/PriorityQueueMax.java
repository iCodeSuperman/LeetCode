package com.arithmetic;

public class PriorityQueueMax <Key extends Comparable<Key>> {
    // 存储元素的数组
    private Key[] pq;
    // 当前队列中的元素数量
    private int N;
    public PriorityQueueMax(int capacity){
        //索引从1开始，空间多一个
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public int parent(int root){
        return root / 2;
    }
    public int leftChild(int root){
        return root * 2;
    }
    public int rightChild(int root){
        return root * 2 + 1;
    }

    // 返回最大元素
    public Key getMax(){
        return pq[1];
    }

    // 插入元素
    public void insert(Key e){
        N++;
        // 先把元素添加到最后
        pq[N] = e;
        // 最后让元素上浮到合理位置
        swim(N);
    }

    // 删除最大元素
    public Key deleteMax(){
        Key maxKey = pq[1];
        // 将最大值和最后一个交换
        swap(1, N);
        pq[N] = null;
        N--;
        // 将1下沉到合理位置
        sink(1);
        return maxKey;
    }

    // 上浮第k个元素，维护性质
    public void swim(int k){
        /**
         * 1. 索引k > 1(元素从index = 1开始排列)
         * 2. 第k个元素大于其父节点，才上浮
         */
        while(k > 1 && less(parent(k), k)){
            swap(parent(k), k);
            k = parent(k);
        }
    }

    // 下沉第k个元素，维护性质
    public void sink(int k){
        /**
         * 1. 先left和right比，大的才有资格和parent交换
         * 2. left和right都要注意，索引要<=N
         */
        while(leftChild(k) <= N){
            // 先假设left更大
            int olderIndex = leftChild(k);
            if(rightChild(k) <= N && less(olderIndex, rightChild(k))){
                olderIndex = rightChild(k);
            }
            // 如果父节点k比左右孩子都大，则不用下沉
            if(less(olderIndex, k)) break;
            // 否则交换
            swap(olderIndex, k);
            k = olderIndex;
        }
    }

    // 交换两个元素
    public void swap(int i, int j){
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    // 比较pq[i]是否比pq[j]要小
    public boolean less(int i , int j){
        // i < j 返回值<0，整体为true
        return pq[i].compareTo(pq[j]) < 0;
    }
}
