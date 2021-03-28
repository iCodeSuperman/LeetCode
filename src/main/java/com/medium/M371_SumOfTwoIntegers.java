package com.medium;

import org.junit.Test;

public class M371_SumOfTwoIntegers {
    /**
     * 算法总体思路：
     *  将十进制值，转成32位表示的二进制，从低位(第0个)开始，逐位计算到高位(第30)。
     *  例如 3 + 7 ==> (0)... 0011 + (0)... 0111 = (0)... 1010
     *
     */
    public int getSum(int a, int b) {
        int ans = 0;
        int na = 0, nb = 0, nc = 0;
        for(int i = 0; i < 32; i++){
            /**
             * 这里表示将第i位取出
             *      例如 a = 10 ==> 1010 ==> [1,0,1,0]
             * 分步详解，以i取值[0,4)
             *      1 << i 表示右移i位，[0000, 0010, 0100, 1000]
             *      a & (1 << i) 表示取值，[0, 10, 0, 1000]
             *      a & (1 << i) >> i 表示将只有一个1的多位二进制，变成一位。
             */
            na = (a & (1 << i)) >> i;
            nb = (b & (1 << i)) >> i;
            int[] op = operation(na, nb, nc);
            // System.out.println("i = " + i +"; " + na + " + " + nb + " = " + op[1] + "; 进位 = " + op[0]);
            nc = op[0];
            ans = ans | (op[1] << i);
        }

        return ans;
    }

    public int[] operation(int a, int b, int c){
        //a和b是运算值，c是进位
        /**
         * 这个式子用真值表推算，其中分别取X和Y结果为1的行。
         */
        int Y = a&(~b)&(~c) | (~a)&(b)&(~c) | (~a)&(~b)&(c) | a&b&c; //个位
        int X = a&b&(~c) | (~a)&(b)&(c) | (a)&(~b)&(c) | a&b&c; //进位

        int[] res = new int[2];
        res[0] = X;
        res[1] = Y;
        return res;
    }


    @Test
    public void t(){
        int a = 10;
        for(int i = 0; i < 4; i++){
            System.out.println(((a & (1 << i)) >> i));
        }

        System.out.println(Integer.toBinaryString(0 << 32));
    }

    @Test
    public void t2(){
        int v = this.getSum(3, 7);
        System.out.println(v);
    }
}
