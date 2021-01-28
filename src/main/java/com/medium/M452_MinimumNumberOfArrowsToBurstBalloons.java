package com.medium;

import java.util.Arrays;

public class M452_MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        int nums = points.length;
        if(nums == 0) return 0;

        //将二维数组，按第二维从小到大排序
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1;
        int x_end = points[0][1];
        for(int i = 1; i < nums; i++){
            int start = points[i][0];
            if(start > x_end){
                count++;
                x_end = points[i][1];
            }
        }

        return count;
    }
}
