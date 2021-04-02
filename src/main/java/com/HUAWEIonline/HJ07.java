package com.HUAWEIonline;

import java.util.Scanner;

public class HJ07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextDouble()){
            double value = scan.nextDouble();
            double v = value - Math.floor(value);
            if(v >= 0.5){
                System.out.println(Math.ceil(value));
            }else{
                System.out.println(Math.floor(value));
            }
        }
    }
}
