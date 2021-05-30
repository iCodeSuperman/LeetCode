package com.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author icodeboy
 */
public class M139_WordBreak {
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
    public boolean wordBreak(String s, List<String> wordDict) {
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
