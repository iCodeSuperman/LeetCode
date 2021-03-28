package com.medium;

public class M137_SingleNumberII {
    // 出现0次为0，出现1次为1，出现2次的值无所谓，出现3次就又回到0，
    // 也就是说，我们一共需要记录3种状态：0次，1次，2次，之后次数都是这三种状态的循环。
    public int singleNumber(int[] nums) {
        int X = 0, Y = 0;
        for (int Z : nums) {
            int Y_new = ~X & (Y ^ Z);
            X = (X & ~Y & ~Z) | (~X & Y & Z);
            Y = Y_new;
        }
        return Y;
    }
}
