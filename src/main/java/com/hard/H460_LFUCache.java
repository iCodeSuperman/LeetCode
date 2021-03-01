package com.hard;

import java.util.*;

public class H460_LFUCache {

}


class LFUCache{
    Map<Integer, Integer> keyToVal;
    Map<Integer, Integer> keyToFreq;
    Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    int cap;
    int minFreq;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 1;
    }

    public int get(int key) {
        if(!keyToVal.containsKey(key)){
            return -1;
        }
        increaseFreq(key); // 增加key对应的频次
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if(this.cap <= 0){
            return;
        }

        if(keyToVal.containsKey(key)){
            keyToVal.put(key, value);
            increaseFreq(key);
            return; // 注意要return
        }

        if(this.cap <= keyToVal.size()){
            removeMinFreqKey();
        }

        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }

    public void increaseFreq(int key){
        // 取出key对应的频次
        int freq = keyToFreq.get(key);
        // 更新所有相关的值
        keyToFreq.put(key, freq + 1);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get((freq + 1)).add(key);
        // 删除旧key对应的频次
        Set<Integer> keyList = freqToKeys.get(freq);
        keyList.remove(key);
        /*
           特别注意，当且仅当，freq对应的key列表为空，要删除空列表。
           同时，此时的最小频次恰好为key对应的旧freq，也同步更新。
         */
        if(keyList.isEmpty()){
            freqToKeys.remove(freq);
            // keyList不为空不能更新
            if(this.minFreq == freq){
                this.minFreq++;
            }
        }
    }

    public void removeMinFreqKey(){
        Set<Integer> keyList = freqToKeys.get(this.minFreq);
        int deleteKey = keyList.iterator().next();

        keyList.remove(deleteKey); // 注意上面无法删除
        if(keyList.isEmpty()){
            freqToKeys.remove(this.minFreq);
            //注意这里不用更新minFreq，因为该函数位于put，下面一定会更新minFreq
        }

        keyToVal.remove(deleteKey);
        keyToFreq.remove(deleteKey);
    }
}