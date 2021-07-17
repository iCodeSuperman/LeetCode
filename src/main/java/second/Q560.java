package second;

import org.junit.Test;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 */
public class Q560{

    /**
     * 前缀和+HashMap
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        //key:前缀和preSum
        //value:前缀和preSum的个数
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        //初始值，前缀和为0的个数为1
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            // key = preSum - k ==> preSum - key = k
            if(map.containsKey(preSum - k)){
                count += map.get(preSum - k);
            }

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    /**
     * 暴力求解
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum3(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum+=nums[j];
                if(sum == k){
                    res++;
                    break;
                }
            }
        }
        return res;
    }


    @Test
    public void t(){
        System.out.println(Integer.MAX_VALUE - 1e7);
    }
}
