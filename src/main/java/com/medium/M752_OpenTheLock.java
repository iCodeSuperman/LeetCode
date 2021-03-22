package com.medium;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class M752_OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        Set<String> dset = new HashSet<>();
        for(int i = 0; i < deadends.length; i++){
            dset.add(deadends[i]);
        }
        int step = 0;
        queue.addLast("0000");
        visited.add("0000");

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                String cur = queue.removeFirst();

                if(cur.equals(target)){
                    return step;
                }
                if(dset.contains(cur)) continue;

                for(int j = 0; j < 4; j++){
                    String plusStr = plusOne(cur, j);
                    if(!visited.contains(plusStr)){
                        queue.addLast(plusStr);
                        visited.add(plusStr);
                    }

                    String minusStr = minusOne(cur, j);
                    if(!visited.contains(minusStr)){
                        queue.addLast(minusStr);
                        visited.add(minusStr);
                    }
                }
            }
            step++;
        }

        return -1;
    }

    public String plusOne(String s, int i){
        char[] chArr = s.toCharArray();
        if(chArr[i] == '9'){
            chArr[i] = '0';
        }else{
            chArr[i] += 1;
        }
        return new String(chArr);
    }

    public String minusOne(String s, int i){
        char[] chArr = s.toCharArray();
        if(chArr[i] == '0'){
            chArr[i] = '9';
        }else{
            chArr[i] -= 1;
        }
        return new String(chArr);
    }

    @Test
    public void t(){
        String s = "1234";
        char[] arr = s.toCharArray();
        for (char c : arr) {
            System.out.println(c);
        }
        arr[0] += 1;
        System.out.println(arr[0] + 1);
        System.out.println(arr[0]);
    }
}













