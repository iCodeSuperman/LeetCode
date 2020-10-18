package com.hard;

public class H164_MaximumGap {
    private class Bucket{
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }
    public int maximumGap(int[] nums) {
        //特判
        int len = nums.length;
        if(nums == null || len < 2){
            return 0;
        }

        //找出nums中的最大值和最小值
        int min = nums[0];
        int max = nums[0];
        for(int i = 1; i < len; i++){
            min = min < nums[i] ? min : nums[i];
            max = max > nums[i] ? max : nums[i];
        }

        //分配桶长度
        int temp = (max - min) / (len - 1);
        int bucketSize = temp > 1 ? temp : 1;

        //计算桶个数
        Bucket[] buckets = new Bucket[(max - min)/bucketSize + 1];

        //遍历nums，初始化每个桶的min和max
        for(int i = 0; i < len; i++){
            int loc = (nums[i] - min) / bucketSize;
            if(buckets[loc] == null){
                buckets[loc] = new Bucket();
            }
            buckets[loc].max = buckets[loc].max > nums[i] ? buckets[loc].max : nums[i];
            buckets[loc].min = buckets[loc].min < nums[i] ? buckets[loc].min : nums[i];
        }

        int preMax = Integer.MIN_VALUE;
        int maxGap = Integer.MIN_VALUE;
        for(int i = 0; i < buckets.length; i++){
            if(buckets[i] != null && preMax != Integer.MIN_VALUE){
                maxGap = maxGap > (buckets[i].min - preMax) ? maxGap :(buckets[i].min - preMax);
            }
            if(buckets[i] != null){
                preMax = buckets[i].max;
                maxGap = maxGap > (buckets[i].min - preMax) ? maxGap :(buckets[i].min - preMax);
            }
        }

        return maxGap;
    }
}
