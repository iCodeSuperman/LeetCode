package com.hard;

public class H765_CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        int m = row.length; //人数
        int n = m / 2; //情侣对数
        UnionFindFor765 uf = new UnionFindFor765(n);

        for (int i = 0; i < m; i+=2) {
            uf.union(row[i] / 2, row[i+1] / 2);
        }
        /** 使用并查集来处理，每次遍历相邻的两个位置，
         * 如果他们本来就是情侣，他们处于大小为1的错误环中，只需要交换0次。
         * 如果不是情侣，说明他们呢两对处在同一个错误环中，我们将他们合并（union），
         * 将所有的错坐情侣合并和后，答案就是情侣对 - 环个数。
         */
        return n - uf.getCount();
    }
}

class UnionFindFor765{
    private int count;
    private int[] fa;
    private int[] size;

    public UnionFindFor765(int n){
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

    public int getCount(){
        return count;
    }
}







