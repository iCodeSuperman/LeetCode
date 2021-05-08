package com.ToOffer;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author icodeboy
 */
public class Offer057_2 {
    public int[][] findContinuousSequence(int target) {
        if(target == 1 || target == 2){
            return new int[1][];
        }
        int left = 1, right = 2, sum = 3;

        List<int []> res = new ArrayList<>();
        while(left < right){
            if(target == sum){
                int len = right - left + 1;
                int[] tmp = new int[len];
                for(int k = 0; k < len; k++){
                    tmp[k] = left + k;
                }
                res.add(tmp);
            }
            if(sum < target){
                right++;
                sum += right;
            }else{
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[0][]);
    }


    public int[][] findContinuousSequence2(int target) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i < target; i++) {
            if(i + i > target) break;
            List<Integer> tmp = new ArrayList<>();
            int sum = 0;
            int j = i;
            while(sum < target){
                sum+=j;
                tmp.add(j);
                j++;
            }
            if(sum == target){
                lists.add(tmp);
            }
        }

        int rows = lists.size();
        //System.out.println(rows);
        int[][] res = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int cols = lists.get(i).size();
            int[] tmp = new int[cols];
            //System.out.println(cols);
            for (int j = 0; j < cols; j++) {
                tmp[j] = lists.get(i).get(j);
            }
            res[i] = tmp;
        }
        return res;
    }

}
