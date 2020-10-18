package com.medium;

import org.junit.Test;

public class M048_RotateImage {
    /**
     * 先转置，然后每一行逆序
     * @param matrix
     */
    public void rotate1(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public void rotate(int[][] matrix) {
       int n = matrix[0].length;
       for(int i = 0; i < (n + 1) / 2; i++){
           for(int j = 0; j < n / 2; j++){
               int temp = matrix[n - 1 - j][i];
               matrix[n - 1 - j][i] =  matrix[n - 1 - i][n - 1 - j];
               matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
               matrix[j][n - 1 - i] = matrix[i][j];
               matrix[i][j] = temp;
           }
       }
    }
    @Test
    public void t(){
        int[] ns = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for(int i = 0; i < ns.length; i++){
            int v = ns[i];
            int u = v / 2 + v % 2;
            System.out.println(v + " = " + u);
        }
    }
}
