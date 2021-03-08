package com.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class H710_RandomPickWithBlacklist {

}

class Solution {

    int sz; //除去黑名单元素后，最终数组的元素个数

    /**
     * 黑名单元素索引映射转换器
     * 例如N = 6, 即元素[0, 1, 2, 3, 4, 5]; 黑名单[1, 4]
     * sz = N - 2 = 4
     * 将1的索引(1)映射为索引(5)，等同于将元素1和5交换位置
     * 当pick1，通过映射变成pick5
     */
    Map<Integer, Integer> map;

    public Solution(int N, int[] blacklist) {
        map = new HashMap<>();
        sz = N - blacklist.length;
        int last = N - 1; // 最后一个元素坐标

        for(int b : blacklist){
            map.put(b, b);
        }

        for (int b : blacklist) {
            // 1. 如果b已经大于sz，不用操作。 例如[1, 2, 3, 4, (5, 6)]，b是在()内的不用管
            if(b >= sz) continue;
            // 2. 若last本身就属于黑名单，则要跳过
            while(map.containsKey(last)){
                last--;
            }
            map.put(b, last);
            last--;
        }
    }

    public int pick() {
        Random random = new Random();
        int index = random.nextInt(sz);
        if(map.containsKey(index)){
            return map.get(index);
        }
        return index;
    }
}