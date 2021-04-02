package com.HUAWEIonline;

import java.util.Scanner;

/**
 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，
 * 求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，
 * 0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
 */

public class Solution01 {
    public static void main(String[] args){
        int n, ans = 0;
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            n = scan.nextInt();
            int num = n;
            boolean[] bo = new boolean[n];
            for(int i = 0; i < n; i++){
                bo[i] = true;
            }
            int i = 0;
            int cnt = 0;
            while(num > 1){
                if(bo[i]){
                    if(cnt == 2){
                        num--;
                        bo[i] = false;
                    }
                    cnt++;
                    if(cnt == 3){
                        cnt = 0;
                    }
                }
                i++;
                if(i == n) i = 0;
                //if(i == n) break;
            }
            for(int k = 0; k < n; k++){
                //System.out.println("k = " + k + ", " + bo[k]);
                if(bo[k] == true) ans = k;
            }
            System.out.println(ans);
        }
    }
}
