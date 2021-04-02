package com.online;


import java.util.*;

public class HJ08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            int n = scan.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> keys = new TreeSet<>();
            for(int i = 0; i < n; i++){
                int key = scan.nextInt();
                int value = scan.nextInt();
                if(!map.containsKey(key)){
                    map.put(key, value);
                }else{
                    map.put(key, map.get(key) + value);
                }
                keys.add(key);
            }

            // Iterator iterator = keys.iterator();
            // while(iterator.hasNext()){
            //     int key = (int)iterator.next();
            //     System.out.println(key + " " + map.get(key));
            // }

            for(int k : map.keySet()){
                System.out.println(k + " " + map.get(k));
            }
        }
    }
}
