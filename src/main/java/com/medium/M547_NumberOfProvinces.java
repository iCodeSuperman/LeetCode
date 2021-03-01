package com.medium;

import java.util.HashSet;
import java.util.Set;

public class M547_NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFindBy547 uf = new UnionFindBy547(n);
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(isConnected[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }
}

class UnionFindBy547{
    private int count;
    private int[] fa;
    private int[] size;

    public UnionFindBy547(int n){
        fa = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
            size[i] = 1;
        }
        count = n;
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ){
            return;
        }
        if(size[p] > size[q]){
            //p为根
            fa[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }else {
            fa[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    public int find(int x){
        int root = x;
        while(root != fa[root]){
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


