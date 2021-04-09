package se.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int k = 0; k < len - 2; k++){
            if(nums[k] > 0) return lists;
            if(k > 0 && nums[k - 1] == nums[k]){
                continue;
            }
            int i = k + 1;
            int j = len - 1;
            int target = 0 - nums[k];
            while(i < j){
                int sum = nums[i] + nums[j];
                if(sum > target){
                    j--;
                    while(i < j && nums[j] == nums[j + 1]) j--;
                }else if(sum < target){
                    i++;
                    while(i < j && nums[i] == nums[i - 1]) i++;
                }else{
                    lists.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    i++;
                    j--;
                    while(i < j && nums[i] == nums[i - 1]) i++;
                    while(i < j && nums[j] == nums[j + 1]) j--;
                }
            }
        }
        return lists;
    }
}
