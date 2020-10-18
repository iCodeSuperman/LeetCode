package com.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q056_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int L = interval[0];
            int R = interval[1];
            if(res.size() == 0 || res.get(res.size() - 1)[1] < L){
                res.add(new int[]{L, R});
            }else{
                R = Math.max(R, res.get(res.size() - 1)[1]);
                res.get(res.size() - 1)[1] = R;
            }
        }


        return res.toArray(new int[res.size()][]);
    }
}
