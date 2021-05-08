package com.ToOffer;

/**
 * @author icodeboy
 */
public class Offer065 {
    public int add(int a, int b) {
        while(b != 0){
            int c = (a & b) << 1;
            a = a ^ b;
            b = c;
        }
        return a;
    }
}
