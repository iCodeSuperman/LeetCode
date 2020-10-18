package com.medium;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M012_IntegerToRoman {
    public String intToRoman2(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        List<Integer> nums = new ArrayList<>();
        while(num > 0){
            nums.add(num % 10);
            num /= 10;
        }

        String ans = "";
        for(int i = nums.size() - 1; i >= 0; i--){
            int value = nums.get(i);
            int bit = (int)Math.pow(10, i);
            if(value == 9){
                ans += map.get(9 * bit);
            }else if(value >= 5){
                value -= 5;
                ans += map.get(5 * bit);
                while(value > 0){
                    value--;
                    ans += map.get(1 * bit);
                }
            }else if(value == 4){
                ans += map.get(4 * bit);
            }else{
                while(value > 0){
                    value--;
                    ans += map.get(1 * bit);
                }
            }
        }

        return ans;
    }

    public String intToRoman(int num) {
        int[] number = {1000,900,500,400,100,90,50,40,10,9,5,4,1} ;
        String[] s = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(num > 0){
            while(num >= number[i]){
                sb.append(s[i]);
                num -= number[i];
            }
            i++;
        }
        return sb.toString();
    }

    @Test
    public void myt(){
        System.out.println(intToRoman(2));
    }
}
