package second;

import java.util.HashMap;
import java.util.Map;

/**
 * @author icodeboy
 */
public class Q003 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int right = 0, left = 0, max = 0;

        Map<Character, Integer> map = new HashMap<>(len);
        // [left, right]
        while(right < len){
            if(map.containsKey(chars[right])){
                // max 用于表示abba，当left=1，right=3时，没有max情况下，left=1，而不是2，计算错误。
                left = Math.max(map.get(chars[right]) + 1, left);
            }
            map.put(chars[right], right);
            right++;
            max = Math.max(max, right - left);
        }
        return max;
    }
}
