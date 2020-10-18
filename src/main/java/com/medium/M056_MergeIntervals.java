package com.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M056_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        /*
        a[0]相等，则用a[1]比较
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
         */
        list.add(intervals[0]);
        for(int i = 1; i < len; i++){
            int[] temp = list.get(list.size() - 1);
            if(temp[1] < intervals[i][0]){
                //新数组的左端点更大，直接添加
                list.add(intervals[i]);
            }else{
                //新数组的左端点有交集，更新右端点
                //新的右端点，必须是两者更大的那个
                if(list.get(list.size() - 1)[1] < intervals[i][1]){
                    list.get(list.size() - 1)[1] = intervals[i][1];
                }
            }
        }

        //链表数组化，注意格式
        return list.toArray(new int[list.size()][]);
    }

    @Test
    public void t(){
        int[][] intervals = {{1, 4}, {2, 3}};
        int[][] res = merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

}
