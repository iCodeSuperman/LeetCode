package com.ToOffer;

import org.junit.Test;

public class Offer051 {

    private int[] a;
    private int[] b;
    private int num = 0;
    @Test
    public void mergeSortTest(){
        a = new int[]{7, 5, 6, 4, 6};
        b = new int[a.length];
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        merge(0, a.length - 1);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("nums = "+num);
    }


    public int reversePairs(int[] nums) {
        int len = nums.length;
        this.a = nums;
        this.b = new int[len];
        merge(0, len - 1);
        return num;
    }

    public void merge(int left, int right){
        if(left >= right){
            return;
        }
        int mid = (right - left) / 2 + left;
        merge(left, mid);
        merge(mid + 1, right);

        int i = left;
        int j = mid + 1;
        int count = left;
        while(i <= mid && j <= right){
            if(a[i] <= a[j]){
                b[count] = a[i];
                i++;
            }else{
                num += (mid - i + 1);
                b[count] = a[j];
                j++;
            }
            count++;
        }
        while(i <= mid){
            b[count] = a[i];
            count++;
            i++;
        }
        while(j <= right){
            b[count] = a[j];
            count++;
            j++;
        }

        for(int k = left; k <=right; k++){
            a[k] = b[k];
        }
    }
}