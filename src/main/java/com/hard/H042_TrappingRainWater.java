package com.hard;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class H042_TrappingRainWater {
    // 暴力法
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

    // 动态规划
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

    // 单调栈
    public int trap3(int[] height){
        if(height.length < 2){
            return 0;
        }
        int sum = 0;
        Deque<Integer> st = new LinkedList<>();
        st.addLast(0);
        for(int i = 1; i < height.length; i++){
            if(height[i] < height[st.getLast()]){
                st.addLast(i);
            } else if(height[i] == height[st.getLast()]){
                st.removeLast();
                st.addLast(i);
            } else {
                while(!st.isEmpty() && height[i] > height[st.getLast()]){
                    int mid = st.removeLast();
                    if(!st.isEmpty()){
                        int dh = Math.min(height[i], height[st.getLast()]) - height[mid];
                        int dw = i - st.getLast() - 1;
                        sum += dh * dw;
                    }
                }
                st.addLast(i);
            }
        }

        return sum;
    }

    // double pointer
    public int trap4(int[] height){
        int left_max = 0;
        int right_max = 0;
        int left = 0, right = height.length - 1;
        int sum = 0;
        while(left < right){
            /**
             * 对于left，仅left_max可信
             * 对于right，仅right_max可信
             * so
             * 仅当left_max < right_max才能确定自己能装多少水，
             * 即利用短板决定水位高度+left_max是可信的。
             * so
             * height[left] < height[right]处理左侧，
             * 保证了左侧出现的最大值，一定会小于右侧，即短板有效。
             */
            if(height[left] < height[right]){
                if(height[left] >= left_max){
                    left_max = height[left];
                }else{
                    sum += left_max - height[left];
                }
                left++;
            } else {
                if(height[right] >= right_max){
                    right_max = height[right];
                }else{
                    sum += right_max - height[right];
                }
                right--;
            }
        }

        return sum;
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
        System.out.println(this.trap4(height));
    }
}
