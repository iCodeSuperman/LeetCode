package com.ToOffer;

/**
 * @author icodeboy
 */
public class Offer058_2 {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        StringBuffer sb = new StringBuffer(s);
        String sub1 = s.substring(0, n);
        String sub2 = s.substring(n, len);
        sb.append(sub2).append(sub1);
        return sb.toString();
    }
}
