package com.medium;

public class M338_CountingBits {
    public int[] countBits(int num) {
        /**
         * 对于偶数：
         *      val中个数 = val >> 1(val / 2)中个数一样。 因为末尾为0，右移只是少了一个0；
         *      2 = 0010; 4 = 0100; 8 = 1000;
         *      3 = 0011; 6 = 0110; 12 = 1010;
         * 对于奇数：
         *      val中的个数，只比val前一个偶数多了一个1，多的就是最低位的1
         *      1 = 0001; 3 = 0011;
         *      0 = 0000; 2 = 0010;
         */
        int[] res = new int[num + 1];
        res[0] = 0;
        for(int i = 1; i < num + 1; i++){
            if(i % 2 == 0){
                res[i] = res[i >> 1];
            }else{
                res[i] = res[i - 1] + 1;
            }
        }

        return res;
    }



    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for(int i = 1; i < num + 1; i++){
            int count = 0;
            int val = i;
            while(val != 0){
                val &= val - 1;
                count++;
            }
            res[i] = count;
        }
        return res;
    }
}
