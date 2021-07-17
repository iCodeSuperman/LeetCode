package second;

/**
 * @author icodeboy
 * 198 打家劫舍1
 */
public class Q198 {
    public int rob(int[] nums) {
        // dp[i]=x 表示从第i间房开始打劫，最多能打劫到的钱为x
        // base case dp[n] = 0;
        int len = nums.length;
        int[] dp = new int[len + 2];
        for (int i = len - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];
    }
}
