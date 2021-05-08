package com.ToOffer;

import org.junit.Test;

/**
 * @author icodeboy
 */
public class Offer066 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] left = new int[len + 2];
        int[] right = new int[len + 2];
        for (int i = 0; i < len + 2; i++) {
            left[i] = 1;
            right[i] = 1;
        }

        // [1, len] 为有效值
        for (int i = 0; i < len; i++) {
            left[i + 1] = left[i] * a[i];
        }
        for (int i = len - 1; i >= 0; i--) {
            right[i + 1] = right[i + 2] * a[i];
        }

        int[] res = new int[len];
        for (int i = 1; i < len + 1; i++) {
            res[i - 1] = left[i - 1] * right[i + 1];
        }

        return res;
    }



}
