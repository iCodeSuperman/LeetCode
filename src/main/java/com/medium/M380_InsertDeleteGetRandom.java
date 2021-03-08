package com.medium;

import java.util.*;

public class M380_InsertDeleteGetRandom {

}
class RandomizedSet {
    Map<Integer, Integer> map; // 值-arr索引
    List<Integer> arr; // 数组

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        arr = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        //数组中存在val，返回false；
        if(map.containsKey(val)){
            return false;
        }
        // 添加元素
        arr.add(val);
        // 更新元素-索引映射关系
        map.put(val, arr.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        //数组中不存在val，返回false
        if(!map.containsKey(val)){
            return false;
        }
        // 取得要删除元素的下标
        int index = map.get(val);
        // 取得最后一个元素
        int lastVal = arr.get(arr.size() - 1);
        // 更新元素-索引映射关系
        map.put(lastVal, index);
        // 交换元素
        arr.set(index, lastVal);
        // 删除最后一个元素
        arr.remove(arr.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int randNum = random.nextInt(arr.size());
        return arr.get(randNum);
    }
}

