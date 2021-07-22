package second;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 20. 有效的括号
 */
public class Q020 {

    public boolean isValid2(String s){
        int len = s.length();
        if(len % 2 != 0){
            return false;
        }

        Map<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> st = new ArrayDeque<>(len);
        char[] arr = s.toCharArray();
        for (int i = 0; i < len; i++) {
            char ch = arr[i];
            if(map.containsKey(ch)){
                if(st.isEmpty() || st.getLast() != map.get(ch)){
                    return false;
                }
                st.removeLast();
            }else{
                st.addLast(ch);
            }
        }
        return st.isEmpty();
    }

    public boolean isValid(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        Deque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if(arr[i] == '(' || arr[i] == '[' || arr[i] == '{'){
                st.addLast(arr[i]);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                if(arr[i] == ')'){
                    if(st.getLast() == '('){
                        st.removeLast();
                    }else {
                        break;
                    }
                }else if(arr[i] == ']'){
                    if(st.getLast() == '['){
                        st.removeLast();
                    }else {
                        break;
                    }
                }else if(arr[i] == '}'){
                    if(st.getLast() == '{'){
                        st.removeLast();
                    }else {
                        break;
                    }
                }
            }
        }
        return st.isEmpty();
    }

    @Test
    public void t(){
        System.out.println(this.isValid("}"));
    }
}
