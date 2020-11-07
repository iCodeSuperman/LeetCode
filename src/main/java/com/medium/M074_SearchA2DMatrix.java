package com.medium;

public class M074_SearchA2DMatrix {
    //1. 两次二分，第一次判断范围要特殊处理
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = 0;
        if(m > 0){
            n = matrix[0].length;
            if(n == 0){
                return false;
            }
        }else{
            return false;
        }

        /*
        int row = m - 1; // 根据比较结果，定位到行
        for(int i = 0; i < m; i++){
            if(i == 0 && target < matrix[i][0]){
                //特判，比第一行行头小，则不在矩阵中
                return false;
            }
            if(target <= matrix[i][0]){
                if(target == matrix[i][0]){
                    return true;
                }
                //比i行行头小，则必在i-1行
                row = i - 1;
                break;
            }
        }
         */
        //对行用二分法
        int l = 0, r = m - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(target == matrix[mid][0]){
                return true;
            }else if(target < matrix[mid][0]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        if(l >= m || l > 0 && matrix[l][0] > target){
            l--;
        }
        int row = l;

        //对列用二分法
        int i = 0, j = n - 1;
        while(i <= j){
            int mid = i + (j - i) / 2;
            if(target == matrix[row][mid]){
                return true;
            }else if(target < matrix[row][mid]){
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target){
        int m = matrix.length;
        if(m <= 0) return false;
        int n = matrix[0].length;
        if(n <= 0) return false;

        int col = n - 1;
        int row = 0;
        while(col >= 0 && row < m){
            int value = matrix[row][col];
            if(target == value){
                return true;
            }else if(target < value){
                col --;
            }else {
                row ++;
                //col = n - 1; //这行代码用不到，直接开始比
            }
        }
        return false;
    }
}
