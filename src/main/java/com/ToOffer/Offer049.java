package com.ToOffer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author icodeboy
 */
public class Offer049 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[1] = 1;
        int a = 1, b = 1, c = 1;
        for(int i = 2; i < n; i++){
            dp[i] = Math.min(dp[a] * 2, Math.min(dp[b] * 3, dp[c] * 4));
            if(dp[i] == dp[a] * 2){
                a++;
            }
            if(dp[i] == dp[b] * 3){
                b++;
            }
            if(dp[i] == dp[c] * 5){
                c++;
            }
        }

        return dp[n - 1];
    }

}
