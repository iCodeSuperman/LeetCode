package com.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class M006_ZigZagConversion {

    public String convert2(String s, int numRows) {
        if(s == null || s.length() == 0) return "";
        if(numRows == 1) return s;

        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int T = 2 * numRows - 2; // 周期
        List<List<Integer>> pos = new ArrayList<List<Integer>>();

        int deltaT = T;
        for(int i = 0; i < numRows; i++){
            if(deltaT == T || deltaT == 0){
                int j = i;
                List<Integer> arr = new ArrayList<>();
                while(j < len){
                    arr.add(j);
                    j += T;
                }
                pos.add(arr);
            }else{
                int j = i;
                Boolean odd = false;
                List<Integer> arr = new ArrayList<>();
                while(j < len){
                    arr.add(j);
                    if(odd){ // 是奇数位
                        odd = false;
                        j = j + T - deltaT;
                    }else{ // 是偶数位
                        odd = true;
                        j = j + deltaT;
                    }
                }
                pos.add(arr);
            }
            deltaT -= 2;
        }

        for(int i = 0; i < pos.size(); i++){
            for(int j = 0; j < pos.get(i).size(); j++){
              sb.append(str[pos.get(i).get(j)]);
            }
        }

        return sb.toString();
    }


    public String convert(String s, int numRows){
        if(numRows <= 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            rows.add(new StringBuilder()); // 有几行就创建几行
        }

        char[] sc = s.toCharArray();
        int index = 0, flag = -1; //为-1，因为第一行，index为0，会为相反数
        for(int i = 0; i < s.length(); i++){
            rows.get(index).append(sc[i]);
            if(index == 0 || index == numRows - 1){
                flag = - flag;
            }
            index += flag;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }

        return sb.toString();
    }


    @Test
    public void myTest(){
        String s = "PAYPALISHIRING";
        String ans = convert(s, 4);
        if(ans.equals("PINALSIGYAHRPI")){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
