package com.ToOffer;

import java.util.*;

/**
 * @author icodeboy
 */
public class Offer048 {

    public int lengthOfLongestSubstrin2(String s) {
        int len = s.length();
        char[] cArrs = s.toCharArray();
        int right = 0, left = 0, max = 0, delta = 0;

        Map<Character, Integer> map = new HashMap<>();
        while(right < len){
            char c = cArrs[right];
            if(map.containsKey(c)){
                int tempIndex = map.get(c);
                left = tempIndex > left ? tempIndex : left;
            }
            map.put(c, right);
            delta = right - left + 1;
            max = delta > max ? delta : max;
            right++;
        }
        return max;
    }


    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        char[] cArrs = s.toCharArray();
        int right = 0, left = 0, max = 0, delta = 0;

        Map<Character, Integer> map = new HashMap<>();
        Set<Character> st = new HashSet<>();
        while(right < len){
            map.put(cArrs[right], map.getOrDefault(cArrs[right], 0) + 1);
            st.add(cArrs[right]);
            right++;

            Iterator<Character> iterator = st.iterator();
            while(iterator.hasNext()){
                char tmp = iterator.next();
                System.out.println(tmp);
                if(map.get(tmp) > 1){
                    map.put(cArrs[left], map.get(cArrs[left]) - 1);
                    st.remove(cArrs[left]);
                    left++;
                    break;
                }
            }

            delta = right - left;
            max = delta > max ? delta : max;

            System.out.println("right="+right+"; left="+left+"; delta="+delta+"; max="+max);
        }
        return max;
    }
}
