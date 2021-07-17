package second;

/**
 * 240. 搜索二维矩阵 II
 */
public class Q240 {

    private int m, n;
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int x = 0, y = n - 1;
        while(x < m && y >= 0){
            int e = matrix[x][y];
            if(target == e){
                return true;
            }else if(target > e){
                x++;
            }else {
                y--;
            }
        }
        return false;
    }


    public boolean isOut(int x, int y){
        if(x >= m || x < 0){
            return true;
        }
        if(y >= n || y < 0){
            return true;
        }
        return false;
    }
}
