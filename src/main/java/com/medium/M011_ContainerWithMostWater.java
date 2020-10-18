package com.medium;

import org.junit.Test;

public class M011_ContainerWithMostWater {
    public int maxArea2(int[] height) {
        int areaMax = -1, max = -1;
        for(int i = 0; i < height.length; i++){
            max = Math.max(max, findMax(height, i));
            areaMax = Math.max(areaMax, max);
        }
        return areaMax;
    }
    public int findMax(int[] height, int index){
        int max = -1;
        for(int i = 0; i < height.length; i++){
            int w = index - i;
            int h = Math.min(height[i], height[index]);
            int area = w * h;
            max = Math.max(max, area);
        }
        return max;
    }

    public int maxArea(int[] height){
        int max = -1;
        int i = 0, j = height.length - 1;
        while(i < j){
            int w = j - i;
            int h = height[i] < height[j] ? height[i++] : height[j--];
            int area = h * w;
            max = area > max ? area : max;
        }
        return max;
    }

    @Test
    public void myt(){
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
