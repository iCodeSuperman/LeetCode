package second;

import java.util.HashMap;
import java.util.Map;

public class Q001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.get(target - nums[i]).intValue() == nums[i]){
                return new int[]{target - nums[i], nums[i]};
            }
        }
        return new int[]{-1, -1};
    }
}
