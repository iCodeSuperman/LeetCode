package com.HUAWEIonline;

import java.util.Scanner;

public class HJ09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int value = scanner.nextInt();
            boolean[] exits = new boolean[10];
            while(value > 0){
                int v = value % 10;
                value /= 10;
                if(!exits[v]){
                    System.out.print(v);
                    exits[v] = true;
                }
            }
            System.out.println();
        }
    }
}
