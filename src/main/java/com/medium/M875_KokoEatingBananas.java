package com.medium;

public class M875_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int right = getMax(piles) + 1;
        int left = 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(canFinish(piles, H, mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canFinish(int[] piles, int H, int speed){
        int time = 0;
        for(int i = 0; i < piles.length; i++){
            time += timeof(piles[i], speed);
        }
        return time <= H;
    }

    public int timeof(int n, int speed){
        return (n / speed) + (n % speed == 0 ? 0 : 1);
    }

    public int getMax(int[] piles){
        int max = piles[0];
        for(int i = 1; i < piles.length; i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }
        return max;
    }
}
