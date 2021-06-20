package second;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author icodeboy
 * 分割回文串，使得每个子串都是回文串，返回所有可能的切割方案
 */
public class Q131 {

    /**
     * 回溯+动态规划预处理
     */
    /**
     * 回溯+动态规划预处理
     */
    private List<List<String>> ans = new ArrayList<>();
    private boolean [][] dp;
    private int sLen;
    public List<List<String>> partition(String s) {
        sLen = s.length();
        dp = new boolean[sLen][sLen];
        for (int i = sLen - 1; i >= 0; i--) {
            for (int j = i; j < sLen; j++) {
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                }
            }
        }

        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < sLen; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        Deque<String> tmp = new ArrayDeque<>();
        myDfs(s, tmp, 0);
        return ans;
    }

    public void myDfs(String s, Deque<String> tmp, int index){
        if(index == sLen){
            ans.add(new ArrayList<String>(tmp));
            return;
        }
        for (int i = index; i < sLen; i++) {

            //System.out.printf("dp[%d][%d] = %d", index, i, dp[index][i]);
            if(dp[index][i]){
                String pre = s.substring(index, i + 1);
                //System.out.println(pre);
                tmp.addLast(pre);
                myDfs(s, tmp, i + 1);
                tmp.removeLast();
            }
        }
    }

    /**
     * 回溯
     */
    private char[] chars;
    private List<List<String>> res;
    private int len;
    public List<List<String>> partition1(String s) {
        res = new ArrayList<>();
        len = s.length();
        chars = s.toCharArray();

        Deque<String> path = new ArrayDeque<>();
        dfs(path, 0);
        return res;
    }

    /**
     *
     * @param path   路径数组，终止条件为index==len
     * @param index  后半部分开始下标
     */
    public void dfs(Deque<String> path, int index){
        if(index == len){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            if(isPalindrome(index, i)){
                // 是回文串，则前半部分加入path，dfs后半部分
                String prefix = new String(chars, index, i + 1 - index);
                path.addLast(prefix);
                dfs(path, i+1);
                path.removeLast();
            }
        }

    }

    /**
     * 判断是否是回文串，从两端开始往中间移动
     * @param left
     * @param right
     * @return
     */
    public boolean isPalindrome(int left, int right){
        while(left < right){
            if(chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Test
    public void t(){
        // char[] chars = {'1', '2', '3'};
        // String s = new String(chars, 0, 1);
        // System.out.println(s);
        System.out.println(this.partition("aaB"));
    }

}
