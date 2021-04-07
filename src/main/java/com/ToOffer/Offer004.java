package com.ToOffer;

import org.junit.Test;

import java.util.Objects;

public class Offer004 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix[0] == null) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        if(n == 0 || m == 0) return false;

        int i = n - 1;
        int j = 0;
        while(i >= 0 && j < m){
            int elem = matrix[i][j];
            if(elem > target) i--;
            else if(elem < target) j++;
            else return true;
        }
        return false;
    }

    @Test
    public void t(){
        Integer a = new Integer(3);
        Integer b = new Integer(3);
        System.out.println(Objects.equals(a, b));

        Integer c = 1;
        Integer d = 1;
        System.out.println(a.equals(b));
    }
}
