package com.medium;

import org.junit.Test;

import java.util.*;

/**
 * @author icodeboy
 */
public class M139_WordBreak {

    /**
     * 动态规划实现
     * dp[i]定义：表示以i结尾的字符串是否可以被wordDict中组合而成
     * base case: dp[0]=true，表示空串且合法
     * 状态转移方程：dp[i] = dp[i] || dp[i-wordLength]
     *
     *  主要发现主问题和子问题的关系：主问题的解一定包括了子问题的解
     *  这道题里面，如果长串可以被分解，那么从长串最右边减去一个单词的子串，也一定可以被分解；
     *  所以对于一个当前串，每次从末尾减去单词表里面的单词，再看看子串能不能分解。
     *  若一个子串可以分解，再加上删去的单词，则源串一定可以分解。
     */
    public boolean wordBreak (String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                String word = wordDict.get(j);
                int wl = word.length();
                // dp[i - wl] 表示子串
                if(i - wl >= 0 && dp[i - wl] && Objects.equals(s.substring(i - wl, i), word)){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * DFS 实现
     *  1. 逐位遍历单词，看看在单词表示能否匹配上
     *  2. 匹配上，则继续dfs递归剩下的部分
     *  3. 匹配不上，则返回
     * @param s         单词
     * @param wordDict  单词表
     * @return
     */
    private boolean canBreak = false;
    private Map<Integer, Boolean> map;
    public boolean wordBreakByDFS(String s, List<String> wordDict) {
        map = new HashMap<>();
        return dfs(s, wordDict, 0);
    }

    public boolean dfs(String s, List<String> wordDict, int start){
        if(start == s.length()){
            return true;
        }
        if(map.containsKey(start)){
            return map.get(start);
        }

        // 因为String.substring(start, i) ===> [start, i)
        for (int i = start + 1; i < s.length() + 1; i++) {
            String prefix = s.substring(start, i);
            // 如果prefix和剩下的都能在单词列表中找到，则返回true
            if(wordDict.contains(prefix) && dfs(s, wordDict, i)){
                map.put(start, true);
                return true;
            }
        }

        // 如果遍历完整个字符串，都不能同时满足prefix和后缀在单词列表中找到，返回false;
        map.put(start, false);
        return false;
    }

    @Test
    public void t(){
        String s = "12345";
        List<String> list = new ArrayList<>();
        list.add("12");
        list.add("45");
        //System.out.println(this.wordBreakByDFS("12345",list));
        //System.out.println("01234".replace("123", "").contains("123"));
    }
}
