package second;

/**
 * 004 寻找两个正序数组的中位数
 */
public class Q004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] nums = new int[len1 + len2];
        int m = 0, n = 0, k = 0;
        while (m < len1 && n < len2) {
            if (nums1[m] > nums2[n]) {
                nums[k] = nums2[n];
                k++;
                n++;
            } else {
                nums[k] = nums1[m];
                k++;
                m++;
            }
        }
        while (m < len1) {
            nums[k] = nums1[m];
            k++;
            m++;
        }
        while (n < len2) {
            nums[k] = nums1[n];
            k++;
            n++;
        }

        int len = len1 + len2;
        if (len / 2 == 0) {
            res = 1.0 * (nums[len / 2 - 1] + nums[len / 2]) / 2;
        } else {
            res = 1.0 * nums[len / 2];
        }
        return res;
    }
}