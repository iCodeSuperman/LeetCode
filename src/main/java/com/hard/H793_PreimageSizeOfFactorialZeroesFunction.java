package com.hard;

public class H793_PreimageSizeOfFactorialZeroesFunction {
    public int preimageSizeFZF(long K) {
        return (int)(findRight(K) - findLeft(K)) + 1;
    }

    public long countZero(long n){
        long res = 0;
        long div = 5;
        while(div <= n){
            res += n / div;
            div *= 5;
        }
        return res;
    }

    public long findLeft(long K){
        long left = 0;
        long right = Long.MAX_VALUE;
        while(left < right){
            long mid = left + (right - left) / 2;
            long count = countZero(mid);
            if(count == K){
                right = mid;
            }else if(count > K){
                right = mid;
            }else if(count < K){
                left = mid + 1;
            }
        }
        return left;
    }

    public long findRight(long K){
        long left = 0;
        long right = Long.MAX_VALUE;
        while(left < right){
            long mid = left + (right - left) / 2;
            long count = countZero(mid);
            if(count == K){
                left = mid + 1;
            }else if(count > K){
                right = mid;
            }else if(count < K){
                left = mid + 1;
            }
        }
        return left - 1;
    }
}















