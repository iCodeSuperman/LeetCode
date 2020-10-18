package com.easy;

public class E168_ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H",
                "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String s = "";
        while(n > 0){
            int k = n % 26;
            if(k == 0){
                k = 26;
                n--;
            }
            n = n / 26;
            s = alphabet[k - 1] + s;
        }
        return s;
    }
}
