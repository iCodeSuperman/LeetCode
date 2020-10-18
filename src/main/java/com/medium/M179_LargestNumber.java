package com.medium;

import org.junit.Test;

import java.util.Arrays;

public class M179_LargestNumber {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] arr = new String[len];
        for(int i = 0; i < len; i++){
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, ((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));

        if(arr[0].equals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    @Test
    public void t(){
        String[] arr = {"3","2","5"};
        System.out.println("1".compareTo("2"));
        Arrays.sort(arr, ((o1, o2) -> (o1).compareTo(o2)));
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
