package com.online;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HJ06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLong()){
            long value = scan.nextLong();
            long rp = value;
            for(long i = 2; i * i <= rp; i ++){
                while(value % i == 0){
                    System.out.print(i + " ");
                    value /= i;
                }
                //System.out.println("hi"+i);
                if(value == 1) break;
            }
            System.out.println(value == 1 ? "" : value);
        }

    }
}
