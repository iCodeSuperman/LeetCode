package com.medium;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class M017_LetterCombinationsOfAPhoneNumber {
    HashMap<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wzyz");
        backDate(digits, 0, "", res);
        return res;
    }

    public void backDate(String digits, int index, String str, List<String> list){
        if(index == digits.length()){
            list.add(str);
            return;
        }
        String value = map.get(digits.charAt(index));
        for(int i = 0; i < value.length(); i++){
            backDate(digits, index + 1, str+value.charAt(i), list);
        }

    }

    @Test
    public void myt(){
        List<String> list = letterCombinations("234");
        int count = 1;
        for (String s : list) {
            System.out.println(count + " : " +s);
            count++;
        }
    }

}
