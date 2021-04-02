package com.HUAWEIonline;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        // for(int i = 0; i < 10; i++){
        //     map.put(new Character((char)i), i);
        // }
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);
        while (scan.hasNextLine()) {
           String str = scan.nextLine().substring(2);
           int count = 0;
           int sum = 0;
           for(int i = str.length() - 1; i >= 0; i--){
               char c = str.charAt(i);
               sum += (int)Math.pow(16, count) * map.get(c);
               count++;
           }
           System.out.println(sum);
        }
    }

    @Test
    public void test(){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < 10; i++){
            char c = (char)(i + '0');
            System.out.println(c);
            map.put(c, i);
        }
        System.out.println(map.get('0'));
    }
}
