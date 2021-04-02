package com.online;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 输入：每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。 str="abcqweracb"
 * 输出：每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。 str="abcqwer"
 */

public class Solution02 {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String str = scan.nextLine();
            int len = str.length();

            HashSet<Character> st = new HashSet<>();
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < len; i++){
                char c = str.charAt(i);
                if(st.contains(c)) continue;
                sb.append(c);
                st.add(c);
            }
            System.out.println(sb.toString());
        }

    }
}
