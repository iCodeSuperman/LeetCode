package com.medium;

public class M684_RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        UnionFindFor684 uf = new UnionFindFor684(2 * len);
        for(int i = 0; i < len; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            if(!uf.isConnected(x, y)){
                uf.union(x, y);
            }else{
                return edges[i];
            }
        }
        return new int[]{};
    }
}


class UnionFindFor684{
    private int count;
    private int[] fa;
    private int[] size;

    public UnionFindFor684(int n){
        fa = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
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
        if(size[rootP] > size[rootQ]){
            fa[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }else{
            fa[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
    }

    public boolean isConnected(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
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
}













