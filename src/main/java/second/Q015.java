package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        // 左右指针i,j占两个位置，且0<=k<i<j<len
        for(int k = 0; k < len - 2; k++){
            // nums[k] > 0，意味着k,i,j三者的和都>0
            if(nums[k] > 0){
                break;
            }
            // 去重
            if(k > 0 && nums[k - 1] == nums[k]){
                continue;
            }
            int i = k + 1, j = len - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]){}
                }else if(sum > 0){
                    while(i < j && nums[j] == nums[--j]){}
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    res.add(list);
                    while(i < j && nums[i] == nums[++i]){}
                    while(i < j && nums[j] == nums[--j]){}
                }
                //System.out.println("i="+i+"; j="+j);
            }
        }

        return res;
    }
}
