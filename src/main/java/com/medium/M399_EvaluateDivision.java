package com.medium;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class M399_EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationLen = equations.size();
        UnionFindByString uf = new UnionFindByString(equationLen * 2);
        Map<String, Integer> map = new HashMap<>();

        int idx = 0;
        for(int i = 0; i < equationLen; i++){
            List<String> el = equations.get(i);
            String x = el.get(0);
            String y = el.get(1);
            if(!map.containsKey(x)){
                map.put(x, idx);
                idx++;
            }
            if(!map.containsKey(y)){
                map.put(y, idx);
                idx++;
            }
            uf.union(map.get(x), map.get(y), values[i]);
        }

        int queriesLen = queries.size();
        double[] ans = new double[queriesLen];
        for(int i = 0; i < queriesLen; i++){
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);

            Integer a = map.get(x);
            Integer b = map.get(y);
            if(a == null || b == null){
                ans[i] = -1.0;
            }else{
                ans[i] = uf.connected(a, b);
            }
        }
        return ans;
    }
}

class UnionFindByString{
    private int count;
    private int[] fa;
    private double[] weight;

    public UnionFindByString(int n){
        fa = new int[n];
        weight = new double[n];
        for(int i = 0; i < n; i++){
            fa[i] = i;
            weight[i] = 1.0;
        }
    }

    public void union(int p, int q, double val){
       int rootP = find(p);
       int rootQ = find(q);
       if(rootP == rootQ){
           return;
       }
       fa[rootP] = rootQ;
       weight[rootP] = weight[q] * val / weight[p];
    }

    public double connected(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ){
            return weight[p] / weight[q];
        }else{
            return -1.0;
        }
    }

    public int find(int x){
        if (x != fa[x]) {
            int origin = fa[x];
            fa[x] = find(fa[x]);
            weight[x] *= weight[origin];
        }
        return fa[x];
    }


    public int getCount(){
        return count;
    }
}
