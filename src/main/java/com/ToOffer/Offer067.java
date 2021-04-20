package com.ToOffer;

import org.junit.Test;

/**
 * @author icodeboy
 */
public class Offer067 {
    public int strToInt(String str) {
        str = str.trim();
        int len = str.length();
        if(len <= 0) {
            return 0;
        }
        if(str.charAt(0) != '+' && str.charAt(0) != '-' && str.charAt(0) < '0' && str.charAt(0) > '9'){
            return 0;
        }

        // 符号位
        int positive = 1;
        // 边界值，搭配最后一位是否大于7来判断是否越界
        int boundry = Integer.MAX_VALUE / 10;
        int i = 0;
        //判断第一个是不是+-号，不是不用移动
        if(str.charAt(i) == '-'){
            positive = -1;
            i++;
        }else if(str.charAt(i) == '+'){
            i++;
        }

        int res = 0;
        while(i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            // 注意是大于7，负数尾巴是XXX48，正数尾巴是XXX47。
            // 正数情况下，最大只能存到XXX47，所以这里取7位分界线
            // 负数情况下，最大能存到XXX48，所以这里不能>=7，漏了负数XXX47这里
            if(res > boundry || res == boundry && str.charAt(i) > '7'){
                return positive == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + str.charAt(i) - '0';
            i++;
        }

        return positive * res;
    }

    @Test
    public void t(){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int res = -2147483648;
        System.out.println(res);
    }
}
