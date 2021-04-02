package com.HUAWEIonline;

import java.util.*;

public class HJ03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            // int n = scan.nextInt();
            // Set<Integer> st = new TreeSet<>();
            // for(int i = 0; i < n; i++){
            //     int e = scan.nextInt();
            //     st.add(e);
            // }
            //
            // Iterator it = st.iterator();
            // while(it.hasNext()){
            //     System.out.println(it.next());
            // }
            boolean[] bool = new boolean[1010];
            int n = scan.nextInt();
            for(int i = 0; i < n; i++){
                int e = scan.nextInt();
                bool[e] = true;
            }
            for(int i = 0; i < 1010; i++){
                if(bool[i] == true){
                    System.out.println(i);
                }
            }
        }
    }
}
