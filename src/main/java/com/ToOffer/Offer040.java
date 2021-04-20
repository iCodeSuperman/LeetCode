package com.ToOffer;

import java.sql.Connection;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Offer040 {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    public void quickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        int i = left, j = right;
        int mid = arr[left];
        while(i < j){
            while(i < j && arr[j] > mid){
                j --;
            }
            arr[i] = arr[j];
            while(i < j && arr[i] < mid){
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = mid;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }
}
