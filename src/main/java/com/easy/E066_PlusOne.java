package com.easy;

public class E066_PlusOne {
    public int[] plusOne(int[] digits) {
        int sum = 0; // 每一位相加和
        int c = 1; // 初始为1，后面作为进位
        for(int i = digits.length - 1; i >= 0; i--){
            sum = digits[i] + c;
            if(sum >= 10){
                digits[i] = sum % 10;
                c = 1;
            }else{
                digits[i] = sum;
                return digits;
            }
        }

        int len = digits.length + 1;
        int[] nums = new int[len];
        for(int i = 0; i < len; i++){
            if(i == 0){
                nums[i] = c;
            }else{
                nums[i] = digits[i - 1];
            }
        }
        return nums;
    }

    public int[] plusOne2(int[] digits) {
        /**
         * 因为+1，当最后一位是9，则变0，进一位。
         *        当最后一位非9，则直接相加，放回
         * 进位也为1，所以产生进位时，每一位都自加1即可
         *
         * 当产生进位导致，已有位数不够，此时值一定为10000形式
         * 所以只需新建一个大一位的数组，第一位值赋值为0即可
         *
         */
        int i = digits.length - 1;
        while(i >=0){
            if( digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i]++;
                return digits;
            }
            i--;
        }
        int[] nums = new int[digits.length + 1];
        nums[0]=1;
        return nums;
    }
}
