package se.review;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Q020_ValidParentheses {
    public boolean isValid2(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> st = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
                if(st.isEmpty()){
                    return false;
                }
                char c = st.pop();
                if(c != map.get(s.charAt(i))){
                    return false;
                }
            }else{
                st.push(s.charAt(i));
            }
        }

        if(!st.isEmpty()){
            return false;
        }

        return true;
    }

    public boolean isValid(String s) {
        int len = s.length();
        //提速1: 提前判断字符个数是否为偶数，即对称
        if(len % 2 != 0){
            return false;
        }

        //提速2: 用数组代替hash，减少比较时间。这里的下标其实是ascii码
        char[] arr = new char[128];
        arr[')'] = '(';
        arr[']'] = '[';
        arr['}'] = '{';
        arr['('] = arr['['] = arr['{'] = '0';

        Deque<Character> st = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            //if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
            if(arr[s.charAt(i)] != '0'){
                if(st.isEmpty()){
                    return false;
                }
                char c = st.pop();
                if(c != arr[s.charAt(i)]){
                    return false;
                }
            }else{
                st.push(s.charAt(i));
            }
        }

        return st.isEmpty();
    }

    @Test
    public void t(){
        String s = "((()))";
        System.out.println(this.isValid(s));
    }
}
