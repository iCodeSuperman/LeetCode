package com.medium;

import org.junit.Test;

public class M397_IntegerReplacement {
    public int integerReplacement(int n) {
        /**
         * 对于偶数，其二进制格式为0b...0，直接右移1位
         * 对于奇数，分三种情况：
         *      1. 0b...01，这里要直接减1，可以直接右移2位
         *      2. 0b...11，这里要直接加1，可以直接右移2位
         *      3. 0b11(特指3)，这要直接减1，然后右移1位
         */
        int count = 0;
        while(n != 1){
            if((n & 1) == 0){
                // 偶数
                /**
                 * 注意这里要用无符号右移，因为下面加法可能会溢出，>>会不断移入符号位，>>高位空位补充0，移入0就知道了结束了
                 */
                n >>>= 1;
            }else if(n == 3){
                n--;
            }else{
                n += (n & 3) == 3 ? 1 : -1;
            }
            count++;
        }
        return count;
    }

    public int integerReplacement2(int n) {
        return bfs(n, 0);
    }

    public int bfs(int n, int count){
        if(n == 1){
            return count;
        }
        if(n % 2 == 0){
            return bfs(n >>> 1, count + 1);
        }else{
            int plus = bfs(n + 1, count + 1);
            int minus = bfs(n - 1, count + 1);
            return plus < minus ? plus : minus;
        }

    }

    @Test
    public void t3(){
        System.out.println(this.integerReplacement2(8));
    }

    @Test
    public void t(){
        System.out.println(Integer.toBinaryString(2147483647));
        long n = 2147483647;
        int count = 0;
        //int n = 2147483647;
        while(n > 0){
            n &= n - 1;
            count++;
        }
        System.out.println(count);
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void t2(){
        int n = -1;
        System.out.println(Integer.toBinaryString(n));
        int count = 0;
        //int n = 2147483647;
        while(n != 0){
            n >>>= 1;
            count++;
        }
        System.out.println(count);
    }
}
