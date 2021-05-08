package com.ToOffer;

/**
 * @author icodeboy
 */
public class Offer021 {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int i = 0, j = len - 1;
        while(i  < j){
            while(nums[i] % 2 != 0){
                i++;
            }
            while(nums[j] % 2 == 0){
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return nums;
    }
}
