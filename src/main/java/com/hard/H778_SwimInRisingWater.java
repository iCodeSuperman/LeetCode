package com.hard;

public class H778_SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int len = n * n;
        UnionFindFor778 uf = new UnionFindFor778(len);

        /**
         * 这里下标为高度，从低到高，可以按顺序遍历，优先低
         */
        int[] index = new int[len]; //下标为grid[i][j]的值(即水池高度), 值为下标
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                index[grid[i][j]] = getIndex(i, j, n);
            }
        }

        int[][] d = {{1,0},{0, 1},{-1, 0},{0, -1}};
        for (int i = 0; i < index.length; i++) {
            int x = index[i] / n;
            int y = index[i] % n;
            for (int k = 0; k < 4; k++) {
                int newX = x + d[k][0];
                int newY = y + d[k][1];
                //没有出界，水池高度<=i时刻的水位
                if(inArea(newX, newY, n) && grid[newX][newY] <= i){
                    uf.union(index[i], getIndex(newX, newY, n));
                }
                if(uf.isConnected(0, n * n - 1)){
                    return i;
                }
            }
        }
        return -1;
    }


    public int getIndex(int i, int j, int n){
        return i * n + j;
    }

    public boolean inArea(int i, int j, int n){
        return i >= 0 && i < n && j >= 0 && j < n;
    }
}



class UnionFindFor778{
    private int count;
    private int[] fa;
    private int[] size;

    public UnionFindFor778(int n){
        count = n;
        fa = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            fa[i] = i;
        }
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

    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    public int getCount(){
        return count;
    }
}
