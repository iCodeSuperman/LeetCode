package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            if(nums[i] > 0) {
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            for (int j = i + 1; j < len - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int left = j + 1, right = len - 1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum < 0){
                        while(left < right && nums[left] == nums[++left]){};
                    }else if(sum > 0){
                        while(left < right && nums[right] == nums[--right]){};
                    }else{
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        while(left < right && nums[left] == nums[++left]){};
                        while(left < right && nums[right] == nums[--right]){};
                    }
                }
            }

        }


        return res;
    }
}
