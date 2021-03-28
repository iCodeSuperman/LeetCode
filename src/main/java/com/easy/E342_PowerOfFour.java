package com.easy;

public class E342_PowerOfFour {
    public boolean isPowerOfFour(int n) {
        int len = Integer.MAX_VALUE;
        boolean[] isTrue = new boolean[len];
        for(int i = 0; i < 31; i++){
            isTrue[(int)Math.pow(2, i)] = true;
        }
        if(isTrue[n] == true) return true;
        else return false;
    }
}
