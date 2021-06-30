package second;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * 460 LFU
 */
public class Q460 {
}
class LFUCache {
    // 容量
    int cap;
    // 当前最小的访问频率
    int minFreq;
    Map<Integer, Integer> keyToValue;
    Map<Integer, Integer> keyToFreq;
    Map<Integer, LinkedHashSet> freqToKeys;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.minFreq = 0;
        keyToValue = new HashMap<>(cap + 1);
        keyToFreq = new HashMap<>(cap + 1);
        freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if(!keyToValue.containsKey(key)){
            return -1;
        }
        int value = keyToValue.get(key);
        increaseFreq(key);
        return value;
    }

    public void put(int key, int value) {
        if(this.cap <= 0){
            return;
        }

        if(keyToValue.containsKey(key)){
            keyToValue.put(key, value);
            increaseFreq(key);
            return;
        }

        if(keyToValue.size() == cap){
            removeMinFreq();
        }

        keyToValue.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }

    public void increaseFreq(int key){
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet());
        freqToKeys.get(freq + 1).add(key);

        LinkedHashSet linkedHashSet = freqToKeys.get(freq);
        linkedHashSet.remove(key);
        if(freqToKeys.get(freq).isEmpty()){
            freqToKeys.remove(freq);
            // 假如要移除的frep恰好为最小值，因为前面刚刚加1，所以最小值加1即可
            if(freq == this.minFreq){
                this.minFreq++;
            }
        }
    }

    public void removeMinFreq(){
        LinkedHashSet<Integer> linkedHashSet = freqToKeys.get(this.minFreq);
        int deleteKey  = linkedHashSet.iterator().next();

        keyToValue.remove(deleteKey);
        keyToFreq.remove(deleteKey);
        linkedHashSet.remove(deleteKey);
        if(freqToKeys.get(this.minFreq).isEmpty()){
            freqToKeys.remove(this.minFreq);
        }

    }
}

