package com.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class H128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
           set.add(num);
        }
        int longestSub = 0;
        int currentSub = 0;
        for (int num : nums) {
            if(!set.contains(num - 1)){
                while(set.contains(num)){
                    currentSub++;
                    num++;
                }
                longestSub = currentSub > longestSub ? currentSub : longestSub;
                currentSub = 0;
            }
        }
        return longestSub;
    }

    public int lc(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        UnionFindByHashMap uf = new UnionFindByHashMap(nums);

        for (int num : nums) {
            if(!uf.connected(num, num + 1))
                uf.union(num, num + 1);
        }

        int max = 0;
        int temp = 0;
        for (int num : nums) {
            temp = uf.getSize(num);
            max = temp > max ? temp : max;
        }
        return max;
    }
}

class UnionFindByHashMap{
    private int count;
    private Map<Integer, Integer> map;
    private Map<Integer, Integer> size;

    public UnionFindByHashMap(int[] arr){
        map = new HashMap<>(); // cur, leader
        size = new HashMap<>(); // cur, size
        for (int i : arr) {
            map.put(i, i); // 各自为自己的leader
            size.put(i, 1);
        }
        count = map.size();
    }

    public void union(int p, int q){
        Integer rootP = find(p);
        Integer rootQ = find(q);
        if(rootP.equals(rootQ)){
            return;
        }
        if(rootP == null || rootQ == null){
            return;
        }

        if(size.get(rootP) > size.get(rootQ)){
            map.put(rootQ, rootP); // rootQ小树作为子树
            size.put(rootP, size.get(rootQ)+size.get(rootP)); // 更新rootP大树的尺寸
        }else{
            map.put(rootP, rootQ); // rootP小树作为子树
            size.put(rootQ, size.get(rootQ)+size.get(rootP)); // 更新rootQ大树的尺寸
        }
        count --;
    }

    public Integer find(int root){
        if(!map.containsKey(root)){
            return null;
        }
        int x = root;
        while(root != map.get(root)){
            root = map.get(root);
        }

        while(x != map.get(x)){
            int val = map.get(x);
            map.put(x, root);
            x = val;
        }
        return root;
    }

    public boolean connected(int p, int q){
        Integer rootQ = find(q);
        Integer rootP = find(p);
        return rootQ == rootP;
    }

    public int getCount(){
        return count;
    }

    public int getSize(int key){
        if(!map.containsKey(key)){
            return Integer.MIN_VALUE;
        }
        return size.get(key);
    }
}
