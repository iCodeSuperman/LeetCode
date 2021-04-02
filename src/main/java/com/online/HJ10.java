package com.online;

import java.util.Scanner;

public class HJ10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean[] exits = new boolean[128];
        while(scan.hasNextLine()){
            String str = scan.nextLine();
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(exits[c] == false){
                    exits[c] = true;
                }
            }
            int count = 0;
            for(int i = 0; i < 128; i++){
                if(exits[i] == true){
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
