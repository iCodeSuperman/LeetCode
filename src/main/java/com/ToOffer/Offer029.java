package com.ToOffer;

public class Offer029 {
    public int[] spiralOrder(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int len = rowLen * colLen;
        int[] res = new int[len];
        int cs, ce, rs, re, i, j;
        cs = -1;
        ce = colLen - 1;
        rs = 0;
        re = rowLen - 1;
        int index = 0;
        i = 0;
        j = 0;
        while(index < len){
            cs = cs + 1;
            for(j = cs; j <= ce; j++){
                res[index++] = matrix[rs][j];
            }
            rs = rs + 1;
            for(i = rs; i <= re; i++){
                res[index++] = matrix[i][ce];
            }
            ce = ce - 1;
            for(j = ce; j >= cs; j--){
                res[index++] = matrix[re][j];
            }
            re = re - 1;
            for(i = re; i >= rs; i--){
                res[index++] = matrix[i][cs];
            }
        }

        return res;
    }
}
