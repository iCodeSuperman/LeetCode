package com.online;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ02 {
    public static void main(String[] args) {
        String str;
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()){
            str = scan.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char cs = str.charAt(i);
                if(cs >= 65 && cs <= 90){
                    cs += 32;
                }
                if(cs >= 97 && cs <= 122){
                    map.put(cs, map.getOrDefault(cs, 0) + 1);
                }
            }
            char c;
            c = scan.nextLine().charAt(0);
            if(c >= 65 && c <= 90){
                c += 32;
            }
            System.out.println(map.getOrDefault(c, 0));

        }
    }
}

/*
AAAAABBAA
A
AAAAABBAA
A


 */