package com.hard;

public class H685_RedundantConnection2 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] degree = new int[n];
        int[] index = new int[2];
        int count = 0;
        for(int i = 0; i < n; i++){
            degree[edges[i][1]]++;
        }

        for(int i = n - 1; i >= n; i--){
            if(degree[i] == 2){
                index[count++] = i;
            }
        }

        if(count > 1){
            if(isTreeAfterDelete(edges, index[0])){
                return edges[index[0]];
            }else{
                return edges[index[1]];
            }
        }

        return getRemoveEdge(edges);
    }

    public int[] getRemoveEdge(int[][] edges){
        int n = edges.length;
        UnionFindFor685 uf = new UnionFindFor685(n);
        for(int i = 0; i < n; i++){
            if(uf.isConnected(edges[i][0], edges[i][1])){
                return edges[i]; //成环，一定不是树
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return new int[]{};
    }

    public boolean isTreeAfterDelete(int[][] edges, int deleteEdge){
        int n = edges.length;
        UnionFindFor685 uf = new UnionFindFor685(n);
        for(int i = 0; i < n; i++){
            if(i == deleteEdge) continue;
            if(uf.isConnected(edges[i][0], edges[i][1])){
                return false; //成环，一定不是树
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return true;
    }
}

class UnionFindFor685{
    private int count;
    private int[] fa;
    public UnionFindFor685(int n){
        count = n;
        for(int i = 0; i < n; i++){
            fa[i] = i;
        }
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ){
            return;
        }
        fa[rootQ] = rootP;
        count--;
    }

    public boolean isConnected(int p, int q){
        return find(p) == find(q);
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











