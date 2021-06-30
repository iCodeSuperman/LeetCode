package second;

<<<<<<< HEAD
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
        while(m < len1 && n < len2){
            if(nums1[m] > nums2[n]){
                nums[k] = nums2[n];
                k++;
                n++;
            }else{
                nums[k] = nums1[m];
                k++;
                m++;
            }
        }
        while(m < len1){
            nums[k] = nums1[m];
            k++;
            m++;
        }
        while(n < len2){
            nums[k] = nums1[n];
            k++;
            n++;
        }

        int len = len1 + len2;
        if(len / 2 == 0){
            res = 1.0 * (nums[len / 2 - 1] + nums[len / 2]) / 2;
        }else{
            res = 1.0 * nums[len / 2];
        }
        return res;
=======

class Q004_1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 确保nums1长度大于nums2
        if(len1 < len2){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int mid = (len1 + len2) / 2;
        int i = 0, j = 0, k = 0;
        while(i < len1 && j < len2){

        }








        int len = len1 + len2;
        int mid = len / 2;











        int i = 0, j = 0, k = 0;
        while(i < len1 && j < len2){
            if(k == mid){
                break;
            }
            if(nums1[i] < nums2[j]){
                i++;
                k++;
            }else{
                j++;
                k++;
            }
        }
        while(k < mid && i < len1){
            i++;
            k++;
        }
        while(k < mid && j < len2){
            j++;
            k++;
        }

        double res = 0;
        if(len / 2 == 0){
            res =
        }

        return 0;
>>>>>>> 5a9e49f05d30aa48dc3427b831065c731932bc9d
    }
}
