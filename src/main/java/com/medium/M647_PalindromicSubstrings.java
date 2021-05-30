package com.medium;

import org.junit.Test;

/**
 * @author icodeboy
 */
public class M647_PalindromicSubstrings {
    /**
     * 动态规划   O(N2)
     * 中心扩展法，上三角为求值区域
     * 1. dp数组含义 : dp[i,j] 表示 i,j区域为回文串
     * 2. base case : j-i=0 true; j-i=1&&s[i]==s[j] true
     * 3. 状态转移方程 :
     *      if(s[i]==s[j] && (j - i < 2 || dp[i + 1][j - 1]) dp[i][j]=true; count++
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        /**
         * 上三角区域求值，求解方向为从第一列往第len-1列，从上往下
         * 左下角的状态往右上角转移
         */
        int count = 0;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if(j == i){
                    // base case 1，一个字符的情况
                    dp[i][j] = true;
                    count++;
                }else if(s.charAt(i) == s.charAt(j) && j - i == 1){
                    // base case 2，两个字符，且相等的情况
                    dp[i][j] = true;
                    count++;
                }else if(s.charAt(i) == s.charAt(j) && j - i > 1 && dp[i + 1][j - 1]){
                    dp[i][j] = true;
                    count++;
                }
                // 以上可以简化为一行
                // if(s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])){}
            }
        }
        return count;
    }

    /**
     * 暴力法， O(N3)
     * @param s
     * @return
     */
    public int countSubstrings2(String s) {
        int count = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len + 1; j++) {
                if(isPalindromic(s.substring(i, j))){
                    count++;
                }
            }
        }

        return count;
    }

    boolean isPalindromic(String s){
        int len = s.length();
        int i = 0, j = 0;
        // 奇数
        if(len % 2 != 0){
            i = len / 2;
            j = len / 2;
        }else{
            // 偶数
            i = len / 2 - 1;
            j = len / 2;
        }
        while(i >= 0 && j < len){
            if(s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }else{
                break;
            }
        }
        if(i == -1 && j == len){
            return true;
        }else{
            return false;
        }
    }

    @Test
    public void t(){
        String s = "abcba";
        System.out.println(this.countSubstrings(s));
        // System.out.println(this.isPalindromic(s));
    }

}
