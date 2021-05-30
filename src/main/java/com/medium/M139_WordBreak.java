package com.medium;

import org.junit.Test;

import java.util.ArrayList;
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
    private Map<String, Boolean> map;
    public boolean wordBreakByDFS(String s, List<String> wordDict) {
        dfs(s, wordDict, 0);
        return canBreak;
    }

    public void dfs(String s, List<String> wordDict, int start){
       if(s.equals("")){
           canBreak = true;
           return;
       }
        for (int i = 1; i <= s.length(); i++) {
            //System.out.println(s.substring(0,i));
            String prefix = s.substring(0, i);
            if(map.containsKey(prefix) && map.get(prefix) == false){
                continue;
            }
            if(wordDict.contains(prefix)){
                dfs(s.substring(i), wordDict, 0);
            }else{
                map.put(prefix, false);
            }
        }
    }

    @Test
    public void t(){
        String s = "12345";
        List<String> list = new ArrayList<>();
        list.add("12");
        list.add("45");
        System.out.println(this.wordBreakByDFS("12345",list));
        //System.out.println("01234".replace("123", "").contains("123"));
    }
}
