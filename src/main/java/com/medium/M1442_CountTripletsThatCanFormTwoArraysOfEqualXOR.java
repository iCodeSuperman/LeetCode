package com.medium;

public class M1442_CountTripletsThatCanFormTwoArraysOfEqualXOR {
    public int countTriplets(int[] arr) {
        int len = arr.length;
        int res = 0;
        for(int i = 0; i < len; i++){
            int temp = arr[i];
            for(int k = i + 1; k < len; k++){
                temp ^= arr[k];
                if(temp == 0){
                    res += k - 1;
                }
            }
        }
        return res;
    }
}
