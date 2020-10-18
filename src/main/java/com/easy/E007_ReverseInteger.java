package com.easy;

public class E007_ReverseInteger {
    public int reverse(int x) {
        int ans = 0;
        while(x != 0){
            int pop = x % 10;
            x = x / 10;
            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && pop > 7)) return 0;
            if(ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && pop < -8)) return 0;
            ans = pop + ans * 10;
        }
        return ans;
    }
}
