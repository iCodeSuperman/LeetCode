package WeeklyMatches.Day2021_0710;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 5793. 迷宫中离入口最近的出口
 */
public class Q002 {
    private int[][] nextForward = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int M, N;
    public int nearestExit(char[][] maze, int[] entrance) {
        this.M = maze.length;
        this.N = maze[0].length;
        int res = 0;
        int x = entrance[0];
        int y = entrance[1];
        boolean[][] visited = new boolean[M][N];
        visited[x][y] = true;
        res = dfs(maze, 0, visited, x, y);
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }

    public int dfs(char[][] maze, int step, boolean[][] visited, int x, int y){
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int X = x + nextForward[i][0];
            int Y = y + nextForward[i][1];

            // 如果出界了
            if(isOuted(X, Y)){
                if(step == 0){
                    res = Math.min(res, Integer.MAX_VALUE);
                }else{
                    res = Math.min(res, step);
                    break;
                }
            }else if(!visited[X][Y] && maze[X][Y] != '+'){
                // 不是墙壁，也没有访问过，继续递归
                visited[X][Y] = true;
                res = Math.min(dfs(maze, step + 1, visited, X, Y), res);
                visited[X][Y] = false;
            }

        }
        return res;
    }

    public boolean isOuted(int x, int y){
        if(x < 0 || x >= M){
            return true;
        }
        if(y < 0 || y >= N){
            return true;
        }
        return false;
    }

    private class Pos{
        int x;
        int y;
        int step;
        public Pos(int x, int y, int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public int getStep(){
            return step;
        }
    }

    public int bfs(char[][] maze, boolean[][] visited, int x, int y){
        Deque<Pos> st = new ArrayDeque<>();
        st.addLast(new Pos(x, y, 0));
        int res = Integer.MAX_VALUE;
        while(!st.isEmpty()){
            Pos pos = st.removeFirst();

            for (int i = 0; i < 4; i++) {
                int X = pos.getX() + nextForward[i][0];
                int Y = pos.getY() + nextForward[i][1];
                if(isOuted(X, Y)){
                    if(pos.getStep() == 0){
                        res = Math.min(res, Integer.MAX_VALUE);
                    }else{
                        return pos.getStep();
                    }
                }else if(!visited[X][Y] && maze[X][Y] != '+'){
                    // 不是墙壁，也没有访问过，继续递归
                    visited[X][Y] = true;
                    st.addLast(new Pos(X, Y, pos.getStep() + 1));
                }
            }
        }
        return res;
    }
}
