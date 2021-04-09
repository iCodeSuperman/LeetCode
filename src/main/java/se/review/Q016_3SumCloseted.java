package se.review;

import org.junit.Test;

import java.util.Arrays;

public class Q016_3SumCloseted {
    public int threeSumClosest(int[] nums, int target) {
        int rtValue = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);

        for(int k = 0; k < len - 1; k++){
            if(k > 0 && nums[k - 1] == nums[k]){
                continue;
            }
            int i = k + 1;
            int j = len - 1;

            while(i < j){
                int sum = nums[i] + nums[j] + nums[k];
                if(target == sum){
                    return sum;
                }
                if(Math.abs(sum - target) < Math.abs(rtValue - target)){
                    rtValue = sum;
                }

                if(sum > target){
                    j--;
                    while(i < j && nums[j] == nums[j+1]) j--;
                }else{
                    i++;
                    while(i < j && nums[i] == nums[i - 1]) i++;
                }
            }
        }

        return rtValue;
    }


    @Test
    public void t(){
        int nums[] = {0, -3, 2, 1, 1, 1};
        System.out.println(this.threeSumClosest(nums, 1));
    }
}
