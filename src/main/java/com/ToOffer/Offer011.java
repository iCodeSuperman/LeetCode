package com.ToOffer;

public class Offer011 {
    public int minArray(int[] numbers) {
        if(numbers == null){
            return 0;
        }
        int len = numbers.length;
        int left = 0, right = len - 1;
        while(left < right){
            int mid = (right - left) / 2 + left;
            // 特别注意，减治需要用mid和right比较
            // [3, 4, 5, 1, 2]
            // [1, 2, 3, 4, 5]
            if(numbers[mid] > numbers[right]){
                // [3, 4, 5, 1, 2]，最小值一定在右边(mid, right]
                left = mid + 1;
            }else if(numbers[mid] == numbers[right]){
                // [2, 2, 0, 1, 2]，存在多个值相同，只能缩小右边界
                right = right - 1;
            }else{
                // [5, 1, 2, 3, 4]，最小值一定在左边[left, mid]
                right = mid;
            }
        }
        return numbers[left];
    }
}
