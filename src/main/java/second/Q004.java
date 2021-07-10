package second;

/**
 * 004 寻找两个正序数组的中位数
 */
public class Q004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 寻找中位数，left表示第left个，right表示第right个
        // 假设len=len1+len2; left=(len+1)/2; right=(len+2)/2;
        // 举例奇数 [1,2],[3]; 找第2个: left=4/2=2; right=5/2=2;
        // 举例偶数 [1,2],[2,4]; 找第2个和第3个: left=5/2=2; right = 6/2=3;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        double res1 = findM(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left);
        double res2 = findM(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right);
        return (res1 + res2) / 2;
    }

    public double findM(int[] nums1, int begin1, int end1, int[] nums2, int begin2, int end2, int k){
        int len1 = end1 - begin1 + 1;
        int len2 = end2 - begin2 + 1;
        // 确保有一个数组为空时，一定是nums1
        if(len1 > len2){
            return findM(nums2, begin2, end2, nums1, begin1, len1, k);
        }
        // k表示第k个，实际下标为k-1，加上偏移量begin2
        if(len1 == 0){
            return nums2[begin2 + k - 1];
        }
        // 当k==1，返回数组中第一个元素，谁小要谁
        if(k == 1){
            return Math.min(nums1[begin1], nums2[begin2]);
        }

        int i = begin1 + Math.min(len1, k / 2) - 1;
        int j = begin2 + Math.min(len2, k / 2) - 1;
        if(nums1[i] > nums2[j]){
            return findM(nums1, begin1, end1, nums2, j + 1, len2, k - Math.min(len2, k / 2));
        }else{
            return findM(nums1, i + 1, end1, nums2, begin2, len2, k - Math.min(len1, k / 2));
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
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