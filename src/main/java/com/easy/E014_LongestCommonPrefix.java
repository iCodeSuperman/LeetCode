package com.easy;

public class E014_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String lcp = strs[0]; // 最长公共前缀
        for(int i = 1; i < strs.length; i++){
            if(lcp.length() == 0){
                break;
            }
            String temp = ""; // 临时字符串
            for(int j = 0; j < strs[i].length() && j < lcp.length(); j++){
                if(lcp.charAt(j) == strs[i].charAt(j)){
                    temp += lcp.charAt(j);
                }else{
                    break;
                }
            }
            lcp = temp;
        }
        return lcp;
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.length() == 0) return "";
            }
        }
        return prefix;
    }

    public String longestCommonPrefix3(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        for(int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(i == strs[j].length() || c != strs[j].charAt(i)){
                    // 条件一： flow
                    // 条件二： flight
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
