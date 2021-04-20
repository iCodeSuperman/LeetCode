package com.ToOffer;

/**
 * 1. 对于[m,n]问题，删掉第m个元素后，变为[m,n-1]问题，由于存在m>n，
 *    所以可以表述为删除(m-1)%n位置的元素，下一轮从m%n开始，记m%n为t,
 *    则有位置对应关系如下：
 *    [m, n-1]   [m, n]问题删除后
 *          0       t+0
 *          1       t+1
 *          2       t+2
 *         ...      ...
 *         n-2      t-2
 *    综上，当[m,n-1]问题中，解为x时，即最后留下的数字为x，
 *          [m,n]问题中对应x的位置为x -> (t+x)%n -> (m%n+x)%n
 *
 * 2. 记[m,n]的解为f(n)，[m,n-1]的解为f(n-1)=x，
 *    则有：f(n) = ( f(n-1) + t ) % n
 *              = ( f(n-1) + m % n) % n
 *              = ( f(n-1) + m) % n
 *    而[m, 1] = f(1) 问题的解恒为0， 即[0]中，删除第m个元素，最后剩下的元素一定为0
 */

public class Offer062 {
    /**
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        int x = 0;
        for(int i = 2; i <= n; i++){
            x = (x + m) % i;
        }
        return x;
    }
}
