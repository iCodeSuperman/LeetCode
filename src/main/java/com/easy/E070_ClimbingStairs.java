package com.easy;

public class E070_ClimbingStairs {
    private int[] pm;
    public int climbStairs(int n) {
        pm = new int[n + 1];
        return cs(0, n);
    }

    public int cs(int i, int n){
        if(i > n){
            return 0;
        }
        if(i == n){
            return 1;
        }
        if(pm[i] > 0){
            return pm[i];
        }
        pm[i] = cs(i + 1, n) + cs(i + 2, n);
        return pm[i];
    }

    // 动态规划 O(n) O(n)
    public int climbStairs2(int n){
        pm[0] = 1;
        pm[1] = 2;
        if(n == 1 || n == 2){
            return n == 1 ? 1 : 2;
        }
        for(int i = 3; i < n; i++){
            pm[i] = pm[i - 1] + pm[i - 2];
        }
        return pm[n - 1];
    }

    // 斐波那契数列 O(n) O(1)
    public int climbStairs3(int n){
        if(n == 1){
            return 1;
        }
        int first = 1;
        int second = 2;
        for(int i = 3; i < n; i++){
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

}
