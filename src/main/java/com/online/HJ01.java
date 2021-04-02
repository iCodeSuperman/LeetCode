package com.online;

import java.util.Scanner;

public class HJ01 {
    public static void main(String[] args) {
        String str;
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            str = scan.nextLine();
            // String[] strArr = str.split(" ");
            // int len = strArr.length;
            // System.out.println(strArr[len - 1].length());
            int count = 0;
            for(int i = str.length() - 1; i >= 0; i--){
                if(str.charAt(i) == ' '){
                    break;
                }
                count++;
            }
            System.out.println(count);
        }
    }
}
