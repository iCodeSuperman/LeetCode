package com.hard;

import org.junit.Test;

public class H004_MedianOfTwoSortedArrays {
    // O(N)
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        double median = 0.0;
        int len = nums1.length + nums2.length;
        int[] allArr = new int[len];

        int i = 0;
        int j = 0;
        int count = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                allArr[count++] = nums1[i++];
            }else{
                allArr[count++] = nums2[j++];
            }
        }
        while(i < nums1.length) allArr[count++] = nums1[i++];
        while(j < nums2.length) allArr[count++] = nums2[j++];

        int index = count / 2;
        if(count % 2 == 0){
            median = (allArr[index - 1] + allArr[index]) * 0.5;
        }else{
            median = allArr[index] * 1.0;
        }

        for (int a : allArr) {
            System.out.println(a);
        }

        return median;
    }

    // O(logN)
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        return 0.5 * (getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left) +
                getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right));
    }
    public double getKth(int[] n1, int begin1, int end1, int[] n2, int begin2, int end2, int k){
        int len1 = end1 - begin1 + 1;
        int len2 = end2 - begin2 + 1;
        if(len1 > len2) return getKth(n2, begin2, end2, n1, begin1, end1, k);
        if(len1 == 0) return n2[begin2 + k - 1];

        if(k == 1) return Math.min(n1[begin1], n2[begin2]);

        int i = begin1 + Math.min(len1, k / 2) - 1;
        int j = begin2 + Math.min(len2, k / 2) - 1;

        if(n1[i] > n2[j]){
            return getKth(n1, begin1, end1, n2, j + 1, end2, k - (j - begin2 + 1));
        }else{
            return getKth(n1, i + 1, end1, n2, begin2, end2, k - (i - begin1 + 1));

        }

    }


    @Test
    public void myTest(){
        int[] n1 = {1, 2};
        int[] n2 = {3, 4};
        System.out.println(findMedianSortedArrays(n1, n2));
    }
}
