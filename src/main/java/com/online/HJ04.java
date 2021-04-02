package com.online;

import org.junit.Test;

import java.util.Scanner;

public class HJ04 {
    public static void main(String[] args) {
        // Scanner scan = new Scanner(System.in);
        // while(scan.hasNextLine()){
        //     String str = scan.nextLine();
        //     int len = str.length();
        //     if(len == 0) continue;
        //     if(len == 8){
        //         System.out.println(str);
        //     }else if(len < 8){
        //         StringBuffer sb = new StringBuffer(str);
        //         for(int i = 0; i < 8 - len; i++){
        //             sb.append("0");
        //         }
        //         System.out.println(sb.toString());
        //     }else{
        //         int num = len / 8;
        //         int del = len % 8;
        //         int sArrLen = num + (len % 8 == 0 ? 0 : 1);
        //         String[] sArr = new String[sArrLen];
        //         for(int i = 0; i < num; i++){
        //             sArr[i] = str.substring(i * 8, (i + 1) * 8);
        //         }
        //         if(del != 0){
        //             String temp = str.substring(num * 8, len);
        //             StringBuffer sb = new StringBuffer(temp);
        //             for(int i = 0; i < 8 - del; i++){
        //                 sb.append("0");
        //             }
        //             sArr[num] = sb.toString();
        //         }
        //         for (String s : sArr) {
        //             System.out.println(s);
        //         }
        //
        //     }

        // }
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String str = scan.nextLine();
            StringBuffer sb = new StringBuffer(str);
            int len = str.length();
            int addZero = 8 - len % 8;
            while(addZero > 0 && addZero < 8){ //特别注意要小于8
                sb.append("0");
                addZero--;
            }
            String s = sb.toString();
            while(s.length() > 0){
                System.out.println(s.substring(0, 8));
                s = s.substring(8);
            }
        }
    }

    @Test
    public void method2(){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String str = scan.nextLine();
            StringBuffer sb = new StringBuffer(str);
            int len = str.length();
            int addZero = 8 - len % 8;
            while(addZero > 0 && addZero < 8){ //特别注意要小于8
                sb.append("0");
            }
            String s = sb.toString();
            while(s.length() > 0){
                System.out.println(s.substring(0, 8));
                s = s.substring(8);
            }
        }
    }
}
