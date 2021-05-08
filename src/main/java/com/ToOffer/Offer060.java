package com.ToOffer;

import org.junit.Test;

public class Offer060 {

    /**
     * dp 动态规划
     * @param n
     * @return
     */
    public double[] dicesProbability2(int n) {
        // min 表示n个骰子和的最小值，max表示最大值
        int min = n, max = 6 * n;
        // baseCount 表示n个骰子的情况和
        int baseCount = (int)Math.pow(6, n);
        // 这里dp[][0] 不用
        int[][] dp = new int[n + 1][max + 1];

        for (int i = 1; i < 6 + 1; i++) {
            dp[1][i] = 1;
        }
        // 表示前i个骰子和，i为骰子个数
        for(int i = 2; i < n + 1; i++){
            // 前i个骰子和的范围[i, end]，j表示i个骰子和的值
            int start = i, end = 6 * n;
            for (int j = i; j < end + 1; j++) {
                //dp[n][j] = dp[n-1][j-1] + ... + dp[n-1][j - 6]
                for (int k = 1; k < 6 + 1; k++) {
                    // 边界处理， 例如2个骰子和为2的个数，dp[2][2]，不可能2-[2,3,...,6]演变
                    if(j - k <= 0) break;
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        // 求概率
        double[] res = new double[max - min + 1];
        for(int i = min; i < max + 1; i++){
            res[i - min] = dp[n][i] * 1.0 / baseCount;
        }

        return res;
    }


    /**
     * 暴力递归
     */
    int[] sumCount;
    public double[] dicesProbability(int n) {
        // len 为有效值个数
        int len = 5 * n +1;
        // counts 为基数，组合总数
        int counts = (int)Math.pow(6, n);
        // s为有效值起点，e为有效值终点
        int start = n, end = 6 * n;
        sumCount = new int[end + 1];
        dfs(n, 0);
        double[] res = new double[len];
        for(int i = start; i <= end; i++){
            res[i - start] = 1.0 * sumCount[i] / counts;
        }
        return res;
    }

    public void dfs(int n, int sum){
        if(n == 0){
            sumCount[sum]++;
            return;
        }
        for(int i = 1; i <= 6; i++){
            dfs(n - 1, sum + i);
        }
    }

    @Test
    public void t(){
        double[] res = this.dicesProbability(2);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%.5f \n", res[i]);
        }
    }

    @Test
    public void t2(){
        double[] tmp1 = {0.00000,0.00463,0.01389,0.02778,0.04630,0.06944,0.09259,0.10648,0.11111,0.10648,0.09259,0.06944,0.04630,0.02778,0.01389,0.00463};
        double[] tmp2 = {0.00463,0.01389,0.02778,0.04630,0.06944,0.09722,0.11574,0.12500,0.12500,0.11574,0.09722,0.06944,0.04630,0.02778,0.01389,0.00463};
        int len = Math.max(tmp1.length, tmp2.length);

        for (int i = 0; i < len; i++) {
            System.out.printf("%.5f   %.5f \n", tmp1[i], tmp2[i]);
        }

    }

}
