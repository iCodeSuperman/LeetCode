package com.ToOffer;

import org.junit.Test;

import java.util.Objects;

/**
 * @author icodeboy
 */
public class Offer017 {
    /**
     * 原始函数入口
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        String[] strings = this.printNumberString(n).split(",");
        int len = strings.length;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        return nums;
    }

    char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char[] nums;
    int n;
    StringBuffer sb;
    /**
     * start 表示有效数字为。
     *      例如n = 3，start = 0；则有效位3位；
     *      start = 1；则有效位为2位，要删除第0位。011 -> 11；
     *      start = 2；则有效位位1位，要删除第0，1位， 001 -> 1；
     * nine 表示当前最大9的个数。
     *      例如n = 3, nine = 0；表示没有一个9 -> 1 ~ 8
     *      nine = 1；表示当前有1个9 -> 9
     *      nine = 2；表示当前有2个9 -> 10 ~ 99
     *      nine = 3; 表示当前有3个9 -> 100 ~ 999
     *
     *      start = n - nine
     */
    int start, nine;
    public String printNumberString(int n){
        this.n = n;
        start = n - 1;
        nine = 0;
        sb = new StringBuffer();
        nums = new char[n];
        dfs(0);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void dfs(int x){
        if(x == n){
            String ans = String.valueOf(nums).substring(start);
            if(!Objects.equals(ans, "0")){
                sb.append(ans).append(",");
            }
            if(n - start == nine) {
                start--;
            }
            return;
        }
        for (char i : loop) {
            if(i == '9'){
                nine++;
            }
            nums[x] = i;
            dfs(x + 1);
        }
        nine--;
    }

    @Test
    public void t(){
        String s = this.printNumberString(3);
        System.out.println(s);
    }

    @Test
    public void t2(){
        System.out.println("001".substring(2));
    }
}
