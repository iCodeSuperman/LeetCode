package com.easy;

public class E167_TwoSum2InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        int i = 1;
        int j = numbers.length;
        int count = 0;
        while(i < j){
            if(numbers[i - 1] + numbers[j - 1] < target){
                i++;
            }else if(numbers[i - 1] + numbers[j - 1] > target){
                j--;
            }else{
                arr[count++] = i;
                arr[count++] = j;
                i++;
                j--;
            }
        }
        return arr;
    }
}
