package com.easy;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class E496_NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len2 = nums2.length;
        int len1 = nums1.length;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> st = new LinkedList<>();
        for(int i = len2 - 1; i >= 0; i--){
            while(!st.isEmpty() && nums2[i] >= st.getLast()){
                st.removeLast();
            }
            int value = st.isEmpty() ? -1 : st.getLast();
            map.put(nums2[i], value);
            st.addLast(nums2[i]);
        }

        // for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        //     Integer key = entry.getKey();
        //     Integer value = entry.getValue();
        //     System.out.println(key + ":" + value);
        // }

        int[] res = new int[len1];
        for(int i = 0; i < len1; i++){
            res[i] = map.get(nums1[i]);
            System.out.println(res[i]);
        }
        return res;
    }

    @Test
    public void t(){
        int[] n1 = {4,1,2};
        int[] n2 = {1,3,4,2};
        System.out.println(this.nextGreaterElement(n1, n2));
    }
}
