package com.medium;

import java.util.Arrays;

public class M435_NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int nums = intervals.length;
        if(nums == 0 || nums == 1){
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 1;
        int x_end = intervals[0][1];
        for(int i = 1; i < nums; i++){
            int start = intervals[i][0];
            if(start >= x_end){
                count++;
                x_end = intervals[i][1];
            }
        }

        return nums - count;
    }
}
