package second;


import java.util.ArrayDeque;
import java.util.Deque;

public class Q085 {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] heights = new int[rows][cols + 2];
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols + 1; j++) {
                if(i == 0 && matrix[i][j - 1] == '1'){
                    heights[i][j] = 1;
                }
                if(i > 0 && matrix[i][j] == '1'){
                    heights[i][j] = heights[i - 1][j] + 1;
                }else{
                    heights[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols + 2; j++) {
                System.out.print(heights[i][j] + " ");
            }
            System.out.println();
        }

        int res = 0;
        for (int i = 0; i < rows; i++) {
            // 存的是下标
            Deque<Integer> st = new ArrayDeque<>();
            st.addLast(0);
            for (int j = 1; j < cols + 2; j++) {
                while (heights[i][st.getLast()] > heights[i][j]){
                    int height = heights[i][st.removeLast()];
                    int width = i - st.getLast() - 1;
                    int area = height * width;
                    res = res > area ? res : area;
                }
            }
        }
        return res;
    }
}
