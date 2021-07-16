package second;

import java.util.HashMap;
import java.util.Map;

/**
 * 1248. 统计「优美子数组」
 */
public class Q1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        // key表示奇数个数preSum
        // value 表示preSum的个数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 != 0){
                preSum++;
            }

            if(map.containsKey(preSum - k)){
                count += map.get(preSum - k);
            }

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}
