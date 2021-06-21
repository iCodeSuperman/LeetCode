package second;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q132 {
    @Test
    public void t(){
        String s = "ababbbabbaba";
        System.out.println(this.minCut(s));
    }

    public int minCut(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        //切割成为单个字符，一定都是回文串
        char[] chars = s.toCharArray();
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if(chars[i] == chars[j] && (j - i <= 2 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                }
            }
        }


        int[] f = new int[len];
        Arrays.fill(f, len);
        for (int i = 0; i < len; i++) {
            if(dp[0][i] == true){
                f[i] = 0;
            }else{
                for(int j = 0; j < i; j++){
                    if(dp[j + 1][i] == true){
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }
        return f[len - 1];
    }

    // public void bfs(){
    //     Deque<Integer> st = new ArrayDeque<>();
    //     boolean find = false;
    //     int depth = 0;
    //     st.addLast(0);
    //
    //     while(!st.isEmpty() && !find){
    //         depth++;
    //         int index = st.removeFirst();
    //         System.out.println("出队=" + index);
    //         for (int i = index; i < len; i++) {
    //             //System.out.printf("dp[%d][%d]=%b, depth=%d \n", index, i, dp[index][i], depth);
    //             if(dp[index][i] && (i == len - 1 || dp[i + 1][len - 1])){
    //                 if(depth < min){
    //                     min = depth;
    //                     find = true;
    //                     break;
    //                 }
    //             }else if(dp[index][i] && i != len - 1){
    //                 st.addLast((i + 1));
    //                 System.out.println("入队=" + (i + 1) + "; 队长=" + st.size());
    //
    //             }
    //         }
    //     }
    // }
    //
    //
    // public void dfs(int index, int depth){
    //     if(index == len - 1){
    //         if(depth < min){
    //             min = depth;
    //         }
    //         return;
    //     }
    //     depth++;
    //     for (int i = index; i < len; i++) {
    //         //System.out.printf("dp[%d][%d]=%b, depth=%d \n", index, i, dp[index][i], depth);
    //         // if(isPalindrome(index, i) && isPalindrome(i + 1, len - 1)){
    //         if(dp[index][i] && dp[i + 1][len - 1]){
    //             if(depth < min){
    //                 min = depth;
    //                 return;
    //             }
    //             //}else if(isPalindrome(index, i)){
    //         }else if(dp[index][i]){
    //             dfs(i + 1, depth);
    //         }
    //     }
    // }
}
