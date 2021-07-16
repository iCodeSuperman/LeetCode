package second;


/**
 * @author icodeboy
 * 238. 除自身以外数组的乘积
 */
public class Q238 {

    /**
     * nums[]= 1,2,3,4
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int left = 1, right = 1;

        for (int i = 0; i < len; i++) {
            // res[] = 1 1 2 6
            res[i] = left;
            // left = 1 1 2 6
            left *= nums[i];
        }

        for (int i = len - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] res = new int[len + 1];
        res[len] = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] = nums[i] * res[i + 1];
        }

        int left = 1;
        for (int i = 0; i < len; i++) {
            res[i] = left * res[i + 1];
            left *= nums[i];
            nums[i] = res[i];
        }
        return nums;
    }

}
