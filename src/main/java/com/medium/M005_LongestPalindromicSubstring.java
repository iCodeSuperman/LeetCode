package com.medium;

import org.junit.Test;

public class M005_LongestPalindromicSubstring {
    public String longestPalindrome4(String s) {
        String line = "";
        for(int i = s.length() - 1; i >= 0; i--){
            line += s.charAt(i);
        }

        int maxLen = -1, maxIndex = -1;
        int count = 0, index = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == line.charAt(i)){
                index = i - count;
                count++;
            }else{
                count = 0;
                index = i;
            }

            if(maxLen < count){
                maxLen = count;
                maxIndex = index;
            }

        }

        String p = "";
        for(int i = maxIndex; i < maxIndex + maxLen; i++){
            p += s.charAt(i);
        }
        return p;
    }

    // 3-暴力
    public String longestPalindrome3(String s){
        int maxlen = -1;
        String maxStr = "";
        int count;
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                count = 0;
                for(int k = i, p = j; k < p; k++, p--){
                    if(s.charAt(k) != s.charAt(p)){
                        break;
                    }else{
                        count++;
                    }
                }
                if(count == (j - i + 1) / 2 && (j - i + 1) > maxlen){
                    maxlen = j - i + 1;
                    maxStr = "";
                    for(int k = i; k <= j; k++){
                        maxStr += s.charAt(k);
                    }
                }

            }
        }

        return maxStr;
    }

    // 2-动态
    public String longestPalindrome2(String s){
        String subStr = "";
        int len = s.length();
        Boolean[][] dp = new Boolean[len][len];

        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                Boolean a = s.charAt(i) == s.charAt(j);
                Boolean b = j - i < 2 || dp[i + 1][j - 1]; //dp会数组越界，但是||前面是true，跳过后面
                /**
                 * 1. len==1 || len==2 的字符串直接出结果，是不是回文串 -> j - i < 2
                 * 2. abcbd
                 * i==4 'd',     dp[4][4] = true && true
                 * i==3 'bd',    dp[3][3] = true && true
                 *               dp[3][4] = false && true
                 * i==2 'cbd',   dp[2][2] = false && true
                 *               dp[2][3] = false && true
                 *               dp[2][4] = false && true(dp[3][3]==true)
                 * i==1 'bcbd',  dp[1][1] = true && true
                 *               dp[1][2] = false && true
                 *               dp[1][3] = true && false(dp[2][2]==false)
                 *               dp[1][4] = false && true
                 */

                dp[i][j] = a && b;
                if(dp[i][j] && j - i + 1 > subStr.length()){
                    subStr = s.substring(i, j + 1);
                }
            }
        }

        return subStr;
    }

    // 1-扩展中心
    public String longestPalindrome(String s){
        if(s == null || s.length() == 0) return "";

        int maxLen = -1, maxIndex = -1;
        for(int i = 0; i < s.length(); i++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = len1 > len2 ? len1 : len2;
            if(len > maxLen){
                maxLen = len;
                maxIndex = i;
            }
        }
        return s.substring(maxIndex - (maxLen - 1) / 2, maxIndex + 1 + maxLen / 2);
    }

    public int expandAroundCenter(String s, int left, int right){
        int L = left, R = right;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;
    }

    @Test
    public void mytest(){
        String s = "a";
        System.out.println(longestPalindrome(s));
    }
}
