package com.hard;

import org.junit.Test;

public class H042_TrappingRainWater {

    public int trap1(int[] height){
        //暴力法
        int len = height.length;
        int ans = 0;
        for(int i = 0;i < len; i++){
            int leftM = 0, rightM = 0;
            for(int j = i; j >= 0; j--){
                leftM = Math.max(height[j], leftM);
            }
            for(int j = i; j < len; j++){
                rightM = Math.max(height[j], rightM);
            }

            ans += Math.min(leftM, rightM) - height[i];
        }
        return ans;
    }

    public int trap2(int[] height){
        // 动态规划
        // 利用两个数组提前保存i位置的最大值
        int ans = 0;
        int len = height.length;
        int[] leftM = new int[len];
        int[] rightM = new int[len];
        int lm = 0, rm = 0;

        for(int i = 0; i < len; i++){
            lm = Math.max(height[i], lm);
            leftM[i] = lm;
        }
        for(int j = len - 1; j >= 0; j--){
            rm = Math.max(height[j], rm);
            rightM[j] = rm;
        }
        for(int i = 0; i < len; i++){
            ans += Math.min(leftM[i], rightM[i]) - height[i];
        }
        return ans;
    }

    public int trap(int[] height) {
        int sum = 0;
        int len = height.length;

        //去掉前导0
        int i = 0, j = 0;
        while(i < len){
            if(height[i] != 0){
                break;
            }
            i++;
        }

        while (i < len){
            j = i + 1;
            int tempSum = 0;
            while(j < len){
                if(height[j] < height[i]){
                    tempSum += height[i] - height[j];
                }else{
                    i = j;
                    break;
                }
                j++;
            }

            if(j == len && height[i] > height[len - 1]){
                tempSum = 0;
                i++;
            }
            sum += tempSum;
            if(i == len - 1){
                break;
            }
        }

        return sum;
    }

    public void print(int[] a){
        for(int i = 0;i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void t(){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2 = {4,0,0,0,4};
        int[] height3 = {0,0,0,0};
        int[] height4 = {0,0,2,2,0,0};
        int[] height5 = {0,0,2,0,2,0};
        int[] height6 = {4,2,0,3,2,5};
        System.out.println(this.trap2(height));
    }
}
