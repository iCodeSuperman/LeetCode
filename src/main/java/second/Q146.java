package second;

import java.util.LinkedHashMap;

/**
 * 145. LRU缓存机制
 */
public class Q146 {

}

class LRUCache {

    int cap;
    LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new LinkedHashMap<>(cap + 1);
    }

    public int get(int key) {
        // 1. 不存在这个key，返回-1
        if(!cache.containsKey(key)){
            return -1;
        }

        // 2. 存在这个key，返回value，这个key变成最近使用
        int value = cache.get(key);
        makeRecently(key);
        return value;
    }

    public void put(int key, int value) {

        // 1. 存在这个key，直接更新值，变最近使用
        if(cache.containsKey(key)){
            cache.put(key, value);
            makeRecently(key);
            return;
        }

        // 2. 容量满了，删除最近不常使用
        if(cache.size() == cap){
            int oldKey = cache.keySet().iterator().next();
            cache.remove(oldKey);
        }

        // 3. 直接插入
        cache.put(key, value);

    }


    public void makeRecently(int key){
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }

}