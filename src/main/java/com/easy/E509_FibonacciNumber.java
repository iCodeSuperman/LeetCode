package com.easy;

import org.junit.Test;

public class E509_FibonacciNumber {
    public int fib(int N) {
        if(N < 1) return 0;
        int[] memo = new int[N + 1];
        return helper(memo, N);
    }

    public int helper(int[] memo, int N){
        if(N == 1 || N == 2){
            return 1;
        }
        if(memo[N] != 0){
            return memo[N];
        }
        memo[N] = helper(memo, N - 1) + helper(memo, N - 2);
        return memo[N];
    }

    public int fib2(int N){
        if(N < 1){
            return 0;
        }
        if(N == 1 || N == 2){
            return 1;
        }
        int pre = 1;
        int cur = 1;
        int sum = 0;
        while(N > 2){
            sum = pre + cur;
            pre = cur;
            cur = sum;
            N --;
        }
        return cur;
    }

    @Test
    public void t(){
        int ans = fib2(5);
        System.out.println(ans);
    }
}
