package com.medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class M220_ContainsDuplicate3 {
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if(nums.length < 2 || k < 0 || t < 0){
            return false;
        }

        for(int i = 0; i < nums.length; i++){
            for(int j = Math.max(0, i - k); j < i; j++){
                if(Math.abs(nums[i] - nums[j]) <= t){
                    return true;
                }
            }
        }
        return false;
    }

    private long getID(long x, long w) {
        /**
         *  x >= 0, x / w
         *      [0 9] / 10 ==> 0号桶
         *      [10 19] / 10 ==> 1号桶
         *  x < 0, (x + 1) / w - 1
         *      [-9 -1] 只有9个元素，不足10个，所以处理如下：
         *          [-10 -1] + 1 ==> [-9 0]
         *          [-9 0] / 10 ==> 0号桶(key冲突)
         *          0 - 1 ==> -1号桶
         */
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        /**
         * nums 待查找数组
         * k 下标索引差上限 i - j <= k
         * t 数组元素差上限 nums[i] - nums[j] <= t
         *
         * 算法思想：桶排序(特例：每个桶有且仅有一个元素)
         */
        if(nums.length < 2 || k < 0 || t < 0){
            return false;
        }
        Map<Long, Long> set = new HashMap<>();
        long w = (long)t + 1; // 桶容量，+1好处理
        for(int i = 0; i < nums.length; i++){
            long x = (long)nums[i];
            long key = getID(x, w); //key为桶的序号
            if(set.containsKey(key)){
                //情况1：同一个桶内，元素差必然小于等于t，直接返回
                return true;
            }
            //情况2：相邻桶内，元素差可能小于等于t，需要进一步判断
            //      1) 存在相邻桶
            //      2) 相邻桶内元素，与nums[i]的差值小于w(即小于等于t)
            if(set.containsKey(key + 1) && Math.abs(set.get(key + 1) - nums[i]) < w){
                return true;
            }

            if(set.containsKey(key - 1) && Math.abs(set.get(key - 1) - nums[i]) < w){
                return true;
            }

            set.put(key, x);

            // 当i>=k时，需要删除i-k的索引值，此时不满足索引差小于k了
            if(i >= k){
                set.remove(getID((long)nums[i - k], w));
            }
        }

        return false;
    }

    @Test
    public void t(){
        int[] nums = {1, 2, 3, 4};
        int k = 3;
        int t = 0;
        System.out.println(this.containsNearbyAlmostDuplicate2(nums, k , t));
        //System.out.println(15 / 10);
    }

    @Test
    public void t2(){
        System.out.println(getID(0, 10));
        System.out.println(getID(9, 10));
        System.out.println(getID(10, 10));
        System.out.println(getID(-1, 10));
        System.out.println(getID(-9, 10));
        System.out.println(getID(-10, 10));
        System.out.println(getID(-11, 10));



    }


}
