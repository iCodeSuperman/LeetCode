package com.ToOffer;

public class Offer033 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int left, int right){
        if(left > right) return true;
        // 寻找第一个大于根的元素
        int m = right;
        for(int i = left; i < right; i++){
            if(postorder[i] > postorder[right]){
                m = i;
                break;
            }
        }
        // 左子树 [left, m - 1]

        // 右子树 [m, right - 1]
        for(int i = m; i < right; i++){
            if(postorder[i] <= postorder[right]){
                return false;
            }
        }
        return recur(postorder, left, m - 1) && recur(postorder, m, right - 1);
    }
}
