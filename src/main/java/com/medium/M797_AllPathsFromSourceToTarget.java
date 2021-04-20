package com.medium;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author icodeboy
 */
public class M797_AllPathsFromSourceToTarget {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int len = graph.length;
        boolean[] isVisited = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(res, graph, len, isVisited, path, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[][] graph, int len, boolean[] isVisited, Deque<Integer> path, int index){
        if(graph[index].length == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(isVisited[index] == true) {
            return;
        }
        isVisited[index] = true;
        path.addLast(index);
        for(int i = 0; i < graph[index].length; i++){
            dfs(res, graph, len, isVisited, path, graph[index][i]);
        }
        path.removeLast();
        isVisited[index] = false;
    }
}
