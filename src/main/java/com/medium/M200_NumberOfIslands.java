package com.medium;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class M200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dummy = m * n;
        int[] island = new int[dummy];
        UnionFindByInt uf = new UnionFindByInt(dummy);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    island[i * n + j] = 1;
                }
            }
        }

        for (int i = 0; i < m - 1; i++) {
            if (grid[i][0] == '1' && grid[i + 1][0] == '1') {
                uf.union(i * n, (i + 1) * n);
            }

            if (grid[i][n - 1] == '1' && grid[i + 1][n - 1] == '1') {
                uf.union(i * n + n - 1, (i + 1) * n + n - 1);
            }
        }

        for (int j = 0; j < n - 1; j++) {
            if (grid[0][j] == '1' && grid[0][j + 1] == '1') {
                uf.union(j, j + 1);
            }
            if (grid[m - 1][j] == '1' && grid[m - 1][j + 1] == '1') {
                uf.union((m - 1) * n + j, (m - 1) * n + j + 1);
            }
        }


        int[][] d = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == '1')
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (grid[x][y] == '1') {
                            uf.union(x * n + y, i * n + j);
                        }
                    }
            }
        }

        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < dummy; i++) {
            if (island[i] == 1) {
                st.add(uf.find(i));
            }
        }
        return st.size();
    }


    @Test
    public void test() {
        char[][] c = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] c2 = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] c3 = {{'1', '1', '1'}, {'1', '0', '1'}, {'1', '1', '1'}};
        char[][] c4 = {{'1', '1', '1', '1'}, {'1', '0', '0', '1'}, {'1', '0', '0', '1'}, {'1', '1', '1', '1'}};
        int ans = this.numIslands(c4);
        System.out.println(ans);
    }
}


class UnionFindByInt {

    private int count = 0;
    private int[] arr;
    private int[] size;

    public UnionFindByInt(int n) {
        arr = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
            size[i] = 1;
        }
        count = n;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (size[rootP] >= size[rootQ]) {
            arr[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            arr[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }

        count--;
    }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int find(int x) {
        // return x == arr[x] ? x : (arr[x] = find(arr[x]));
        int root = x;
        while (root != arr[root]) {
            root = arr[root];
        }

        while (x != arr[x]) {
            int temp = arr[x];
            arr[x] = root;
            x = temp;
        }
        return root;

    }

    public int getCount() {
        return count;
    }

    public int getSize(int x) {
        return size[x];
    }

    public int getArr(int x) {
        return arr[x];
    }
}

