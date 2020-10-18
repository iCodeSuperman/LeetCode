package com.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M057_InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int index = 0;
        int len = intervals.length;
        List<int[]> arr = new ArrayList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        while(index < len && intervals[index][0] < newStart){
            arr.add(intervals[index++]);
        }

        if(arr.size() == 0 || arr.get(arr.size() - 1)[1] < newStart){
            arr.add(newInterval);
        }else{
            int right = Math.max(newEnd, arr.get(arr.size() - 1)[1]);
            arr.get(arr.size() - 1)[1] = right;
        }

        while(index < len){
            if(arr.get(arr.size() - 1)[1] < intervals[index][0]){
                arr.add(intervals[index]);
            }else{
                int right = Math.max(intervals[index][1], arr.get(arr.size() - 1)[1]);
                arr.get(arr.size() - 1)[1] = right;
            }
            index++;
        }

        return arr.toArray(new int[arr.size()][]);
    }



    public int[][] insert2(int[][] intervals, int[] newInterval) {

        int index = 0;
        int len = intervals.length;
        List<int[]> arr = new ArrayList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        while(index < len && intervals[index][0] < newStart){
            arr.add(intervals[index++]);
        }

        if(arr.size() == 0 || arr.get(arr.size() - 1)[1] < newStart){
            arr.add(newInterval);
        }else{
            int right = Math.max(newEnd, arr.get(arr.size() - 1)[1]);
            arr.get(arr.size() - 1)[1] = right;
        }

        while(index < len){
            if(arr.get(arr.size() - 1)[1] < intervals[index][0]){
                arr.add(intervals[index]);
            }else{
                int right = Math.max(intervals[index][1], arr.get(arr.size() - 1)[1]);
                arr.get(arr.size() - 1)[1] = right;
            }
            index++;
        }

        return arr.toArray(new int[arr.size()][]);
    }
}
