package com.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list2 = new ArrayList<List<Integer>>();
        ArrayList<Integer> arr;
        for(int i = 1; i <= numRows; i++){
            arr = new ArrayList<Integer>(Collections.nCopies(i, 1));
            for(int j = 1; j < i - 1; j++){
                // if(j == 0) arr.add(1);
                // else if(j == i - 1) arr.add(1);
                // else{
                //     int v = list2.get(i - 2).get(j - 1) + list2.get(i - 2).get(j);
                //     arr.add(v);
                // }
                int v = list2.get(i - 2).get(j - 1) + list2.get(i - 2).get(j);
                arr.set(j,v);
            }
            list2.add(arr);
        }
        return list2;
    }
}
