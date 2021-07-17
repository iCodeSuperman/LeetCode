package second;

/**
 * 打家劫舍2
 * @author icodeboy
 */
public class Q213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        return Math.max(robRange(nums, 0, len - 2), robRange(nums, 1, len - 1));
    }
    public int robRange(int[] nums, int start, int end) {
        // dp[i]=x 表示从第i间房开始打劫，最多能打劫到的钱为x
        // base case dp[n] = 0;
        int len = nums.length;
        int[] dp = new int[len + 2];
        for (int i = end; i >= start; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[start];
    }
}
