package com.ToOffer;

import org.junit.Test;

/**
 * @author icodeboy
 */
public class Offer05 {
    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    @Test
    public void t(){
        String s = "  ";
        System.out.println(this.replaceSpace(s));
    }

    @Test
    public void t2(){
        int nmin = Integer.MIN_VALUE;
        int nmax = Integer.MAX_VALUE;
        int max = (1 << 31) - 1;
        int min = 1 << 31;
        System.out.println("整数最小值" + nmin);
        System.out.println("整数最大值" + nmax);
        System.out.println(max);
        System.out.println(min);
    }
}
