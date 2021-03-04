package com.medium;

import org.junit.Test;

public class M1011_CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int D) {
        int left = getMax(weights);
        int right = getSum(weights) + 1;
        while(left < right){
            int mid = left + (right - left ) / 2;
            if(canFinish(weights, mid, D)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public int getSum(int[] w){
        int sum = 0;
        for (int i : w) {
            sum += i;
        }
        return sum;
    }

    public int getMax(int[] w){
        int max = w[0];
        for(int i = 1; i < w.length; i++){
            if(w[i] > max){
                max = w[i];
            }
        }
        return max;
    }

    // 如果载重为cap，能否在D天内运完
    public boolean canFinish(int[] w, int cap, int D){
        int i = 0;
        for(int d = 0; d < D; d++){
            int c = cap; //每天的运载能力
            while((c -= w[i]) >= 0){
                i++;
                if(i == w.length){
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void t(){
        int a = 10;
        int b = 3;
        while((a -= b) >= 0){
            System.out.println("a = "+a+"; b = "+b);
        }
        System.out.println("a = "+a+"; b = "+b);
    }

}
