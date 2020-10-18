package com.easy;

public class E038_CountAndSay {
    public String countAndSay(int n) {
        // String ans = "1";
        // for(int i = 1; i < n; i++){
        //     ans = nextString(ans);
        // }
        // return ans;
        if(n == 1) return "1";
        else return nextString(countAndSay(n - 1));
    }

    public String nextString(String str){
        StringBuffer next = new StringBuffer();
        char pre = str.charAt(0), now;
        int count = 1;
        for(int i = 1; i < str.length(); i++){
            now = str.charAt(i);
            if(pre != now){
                next = next.append(count).append(pre);
                count = 1;
                pre = str.charAt(i);
            }else{
                count++;
            }

        }
        next = next.append(count).append(pre);
        return next.toString();
    }

}
