package com.medium;

import org.junit.Test;

import java.util.*;

public class M279_PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        int sqrtN = (int)Math.sqrt(n) + 1;
        List<Integer> squares = new ArrayList<>(sqrtN);
        for (int i = 0; i < sqrtN; i++) {
            squares.add(i * i);
        }

        for (int i = 0; i < n + 1; i++) {
            for (Integer square : squares) {
                if(i - square <= 0){
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }
        return dp[n];
    }


    @Test
    public void t(){
        System.out.println(numSquares(13));
    }
}
