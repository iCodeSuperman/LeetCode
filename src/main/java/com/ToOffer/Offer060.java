package com.ToOffer;

import org.junit.Test;

public class Offer060 {

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

}
