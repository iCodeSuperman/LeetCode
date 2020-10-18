package com.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E119_PascalsTriangle2 {
    public List<Integer> getRow(int numRows) {
        if (numRows < 0) {
            return new ArrayList();
        }
        List<Integer> arr = new ArrayList();
        arr.add(1);
        long C = 1; // 防止整数溢出
        for (int i = 1; i <= numRows; i++) {
            C = C * (numRows + 1 - i) / i;
            arr.add((int) C);
        }
        return arr;
    }
}
