package com.medium;

public class M260_SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }

        xor = xor & (-xor);
        int[] res = {0, 0};
        for(int num : nums){
            if((num & xor) == 0){
                res[0] = res[0] ^ num;
            }else{
                res[1] = res[1] ^ num;
            }
        }
        return res;
    }
}
