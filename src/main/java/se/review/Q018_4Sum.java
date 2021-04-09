package se.review;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q018_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();

        /*当数组为null或元素小于4个时，直接返回*/
        if(nums == null || nums.length < 4){
            return lists;
        }

        int len = nums.length;
        Arrays.sort(nums);

        for(int k = 0; k < len - 3; k++){
            if(k > 0 && nums[k] == nums[k -  1]){
                continue;
            }


            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if(min1 > target){
                break;
            }

            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1 = nums[k] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if(max1 < target){
                continue;
            }


            for(int v = k + 1; v < len - 2; v++){
                if(v > k + 1 && nums[v] == nums[v -  1]){
                    continue;
                }
                int i = v + 1;
                int j = len - 1;

                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
                int min = nums[k] + nums[v] + nums[i] + nums[i + 1];
                if(min > target){
                    break;
                }

                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max = nums[k] + nums[v] + nums[j] + nums[j - 1];
                if(max < target){
                    break;
                }

                while(i < j){
                    int sum = nums[k] + nums[v] + nums[i] + nums[j];
                    if(sum == target){
                        lists.add(new ArrayList<>(Arrays.asList(nums[k], nums[v], nums[i], nums[j])));
                        i++;
                        j--;
                        while (i < j && nums[j] == nums[j + 1]) j--;
                        while (i < j && nums[i] == nums[i - 1]) i++;
                    }else if(sum > target){
                        j--;
                        while (i < j && nums[j] == nums[j + 1]) j--;
                    }else{
                        i++;
                        while (i < j && nums[i] == nums[i - 1]) i++;
                    }
                }

            }
        }

        return lists;
    }


    @Test
    public void t(){
        //int nums[] = {1, 0, -1, 0, -2, 2};
        int nums[] = {-3,-2,-1,0,0,1,2,3};
        System.out.println(this.fourSum(nums, 0).toString());
    }
}









