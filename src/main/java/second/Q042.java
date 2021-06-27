package second;

/**
 * 042 接雨水
 */
public class Q042 {
    // 参考题解：https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
    /**
     * 方法一：
     *  遍历每一列(除了第一列和最后一列）
     *      对于第i列，找出其左边和右边最高的，取两者最小的，记录为min
     *      求min - height[i]的累计和
     */
    public int trap1(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left_max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if(height[j] > left_max){
                    left_max = height[j];
                }
            }

            int right_max = 0;
            for (int j = i + 1; j < height.length; j++) {
                if(height[j] > right_max){
                    right_max = height[j];
                }
            }

            int min = Math.min(left_max, right_max);
            if(min > height[i]){
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 方法二：
     *  在方法一的基础上，提前预处理两边的最大高度
     */
    public int trap2(int[] height) {
        int len = height.length;
        int[] left_max = new int[len];
        int[] right_max = new int[len];

        for(int i = 1; i < len - 1; i++){
            left_max[i] = Math.max(left_max[i - 1], height[i - 1]);
        }
        for(int i = len - 2; i > 0; i--){
            right_max[i] = Math.max(right_max[i + 1], height[i + 1]);
        }
        int sum = 0;
        for(int i = 1; i < len - 1; i++){
            int min = Math.min(left_max[i], right_max[i]);
            if(min > height[i]){
                sum += min - height[i];
            }
        }
        return sum;
    }
}
