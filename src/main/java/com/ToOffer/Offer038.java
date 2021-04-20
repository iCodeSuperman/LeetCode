package com.ToOffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author icodeboy
 */
public class Offer038 {
    List<String> list = new ArrayList<>();
    char[] cArr;
    boolean[] isVisited;
    public String[] permutation(String s) {
        int len = s.length();
        isVisited = new boolean[len];
        cArr = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        dfs(0, sb);

        return list.toArray(new String[list.size()]);
    }

    public void dfs(int size, StringBuffer sb){
        if(size == cArr.length){
            list.add(sb.toString());
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < cArr.length; i++){
            char c = cArr[i];
            if(!set.contains(c) && !isVisited[i]){
                set.add(c);
                isVisited[i] = true;
                sb.append(c);
                dfs(size + 1, sb);
                sb.deleteCharAt(size);
                isVisited[i] = false;
            }
        }

    }

    @Test
    public void t(){
       String s = "aab";
       String[] res = this.permutation(s);
        for (String r : res) {
            System.out.println(r);
        }
    }
}
