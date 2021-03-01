package com.medium;

import org.junit.Test;

import javax.sql.DataSource;
import java.util.*;

public class M399_EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationLen = equations.size();
        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
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

    @Test
    public void t1(){
        int[] father = new int[]{0, 0, 1, 2, 3};
        int[] weight = new int[]{1, 2, 3, 4, 5};
        int a = t3(4, father, weight);
        System.out.println(Arrays.toString(father));
        System.out.println(Arrays.toString(weight));
    }

    public int t2(int x, int[] father, int[] weight){
        if(x != father[x]){
            int origin = father[x];
            father[x] = t2(father[x], father, weight);
            weight[x] *= weight[origin];
        }
        return father[x];
    }

    /**
     * [0, 0, 0, 0, 0] 都变了
     * [1, 2, 3, 4, 120] 注意这里只有最后一个变了
     * @param x
     * @param father
     * @param weight
     * @return
     */
    public int t3(int x, int[] father, int[] weight){
        int root = x;
        int mul = 1;
        while(root != father[root]){
            mul *= weight[root];
            root = father[root];
        }
        //weight[x] = mul;

        while(x != father[x]){
            int temp = father[x];
            int del = weight[x];

            weight[x] = mul;
            mul /= del;

            father[x] = root;
            x = temp;
        }

        return root;
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
        // 有向图，这里p和q有向
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

    public int find2(int x){
        int root = x;
        int mul = 1;
        while(root != fa[root]){
            mul *= weight[root];
            root = fa[root];
        }

        while(x != fa[x]){
            int temp = fa[x];
            fa[x] = root;
            x = temp;
        }

        return root;
    }


    public int getCount(){
        return count;
    }
}