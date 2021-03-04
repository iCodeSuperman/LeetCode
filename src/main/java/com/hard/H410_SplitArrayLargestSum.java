package com.hard;

public class H410_SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int left = getMax(nums);
        int right = getSum(nums) + 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            /**
             * mid大，则单个子数组容量大，子数组数量就少
             */
            int n = split(nums, mid);
            if(n == m){
                //收缩右边界，达到搜索左边界的目的
                right = mid;
            }else if(n < m){
                // 最大子数组和上限高了，可以减少一些
                right = mid;
            }else if(n > m){
                // 最大子数组和上限低了，可以增加一些
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 若限制最大子数组和为max，计算最多可以被划分为几个数组
     * @param nums
     * @param max
     * @return
     */
    public int split(int[] nums, int max){
        int sum = 0;
        int count = 1;
        for(int i = 0; i < nums.length; i++){
            // 超过了max的限制，不能继续添加元素（即相加）
            if((sum + nums[i]) > max){
                count++;
                sum = nums[i];
            }else{
                // 没到限制，可以继续加元素
                sum += nums[i];
            }
        }
        return count;
    }

    public int getMax(int[] nums){
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(max < nums[i]){
                max = nums[i];
            }
        }
        return max;
    }

    public int getSum(int[] nums){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
