package com.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class M210_CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();

        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjoin = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++){
            adjoin.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
            adjoin.get(p[1]).add(p[0]);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                deque.addLast(i);
            }
        }
        while (!deque.isEmpty()){
            int pre = deque.removeFirst();
            res.add(pre);
            numCourses--;
            for (int i = 0; i < adjoin.get(pre).size(); i++) {
                int cur = adjoin.get(pre).get(i);
                inDegree[cur]--;
                if(inDegree[cur] == 0){
                    deque.addLast(cur);
                }
            }
        }

        if(numCourses == 0){
            int[] arr = new int[res.size()];
            for(int i = 0; i < res.size(); i ++){
                arr[i] = res.get(i);
            }
           return arr;
        }else{
            return new int[0];
        }
    }
}
