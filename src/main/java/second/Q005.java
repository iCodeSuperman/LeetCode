package second;

/**
 * @author icodeboy
 *
 * 最长回文子串
 */
public class Q005 {
    /**
     * 动态规划
     * 1. 从右下角开始，特殊情况为len=1和len=2，当最大长度更新，记录substring(begin, end)
     * 2. len = 1，直接一开始初始化 pa[i][i] = true;
     * 3. len = 2，内部判断，当s[i]==s[j] && j - i < 2，pa[i][j]=true;
     * 4. len > 2，内部判断，当s[i]==s[j] && pa[i+1][j-1]=true，pa[i][j]=true;
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] pa = new boolean[len][len];

        int max = 1, begin = 0, end = 1;
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if(s.charAt(i) == s.charAt(j) && (pa[i + 1][j - 1] || j - i < 2)){
                    if(max < j - i + 1){
                        begin = i;
                        end = j + 1;
                        max = j - i + 1;
                    }
                    pa[i][j] = true;
                }
            }
        }
        return s.substring(begin, end);
    }


    /**
     * dp
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        boolean[][] pa = new boolean[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = 1;
            pa[i][i] = true;
        }
        int max = 1;
        String str = s.substring(0, 1);
        for(int i = len - 2; i >= 0; i--){
            for(int j = i + 1; j < len; j++){
                if(s.charAt(i) == s.charAt(j) && (pa[i + 1][j - 1] || j - i < 2)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    pa[i][j] = true;
                }else{
                    dp[i][j] = Math.max(
                            dp[i][j - 1],
                            dp[i + 1][j]
                    );
                }
                if(max < dp[i][j]){
                    //System.out.printf("dp[%d][%d]=%d \n", i, j, dp[i][j]);
                    max = dp[i][j];
                    str = s.substring(i, j + 1);
                }
            }
        }
        //    for(int i = 0; i < len; i++){
        //        for(int j = 0; j < len; j++){
        //            System.out.print(dp[i][j] + " ");
        //        }
        //        System.out.println();
        //    }
        //System.out.println(dp[0][len - 1]);
        return str;
    }

    /**
     * 方法一： 暴力破解
     *  step1：列举所有子串
     *  step2：判断这些子串是不是回文串，记录最大的
     *
     *  abb -> a, ab, abb
     *             b, bb
     *                 b
     */

    public String longestPalindrome1(String s) {
        String res = "";
        int max = 1;
        int len  = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String sub = s.substring(i, j + 1);
                if(isPalindrome(sub)){
                    if(max > sub.length()){
                        max = sub.length();
                        res = sub;
                    }
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s){
        int len = s.length();
        int i = 0, j = 0;
        if(len % 2 == 0){
            j = len / 2;
            i = j - 1;
        }else{
            j = len / 2;
            i = j;
        }
        while(i >= 0 && j < len){
            if(s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }else{
                return false;
            }
        }
        return true;
    }
}
