package com.arithmetic;

public class UF {
    //记录连通分量
    private int count;
    //节点x的父节点是parent[x]
    private int[] parent;
    //增加一个数据记录树的重量
    private int[] size;

    /*构造函数 n为图的总数*/
    public UF(int n){
        // 一开始互不相同
        this.count = n;
        // 父节点指针指向自己
        parent = new int[n];
        // 初始每棵树只有一个节点，重量应该初始化为1
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }

    }


    /*将p和q连接*/
    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ){
            return;
        }

        //小树接到大树下面，比较平衡
        if(size[rootP] > size[rootQ]){
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }else{
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }

        //两个分量合二为一
        count --;
    }

    /*返回某个节点x的根节点*/
    private int find(int x){
        // 根节点的parent[x]=x 即根节点的父节点为它自身
        while(parent[x] != x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    /*判断p和q是否连通，即判断是否有相同的根节点*/
    public boolean connected(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int count(){
        return count;
    }
}
