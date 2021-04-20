package se.review;

/**
 * @author icodeboy
 */
public class Q005 {
    public String longestPalindrome(String s) {
        String res = "";
        int len = s.length();
        for(int i = 0; i < len; i++){
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public String palindrome(String s, int l, int r){
        while (l >= 0 && r < s.length()){
            if(s.charAt(l) != s.charAt(r)){
                break;
            }
            l--;
            r++;
        }
        return s.substring(l, r + 1);
    }
}
