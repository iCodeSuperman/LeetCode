package com.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author icodeboy
 */

public class M207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjoin = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++){
            adjoin.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
            adjoin.get(p[1]).add(p[0]);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.addLast(i);
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.removeFirst();
            numCourses--;
            for(int i = 0; i < adjoin.get(cur).size(); i++){
                int node = adjoin.get(cur).get(i);
                inDegree[node] --;
                if(inDegree[node] == 0){
                    queue.addLast(node);
                }
            }
        }

        return numCourses == 0;
    }
}
