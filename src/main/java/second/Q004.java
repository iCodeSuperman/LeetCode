package second;


public class Q004 {
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
    }
}
