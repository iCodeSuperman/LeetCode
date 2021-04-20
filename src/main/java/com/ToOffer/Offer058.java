package com.ToOffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author icodeboy
 */
public class Offer058 {
    public String reverseWords(String s) {
        String str = s.trim();
        List<String> list = new ArrayList<>();
        int len = str.length();

        int i = 0;
        while(i < len){
            StringBuffer sb = new StringBuffer();
            while(i < len && str.charAt(i) != ' '){
                sb.append(str.charAt(i));
                i++;
            }
            list.add(sb.toString());
            while(i < len && str.charAt(i) == ' '){
                i++;
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int k = list.size() - 1; k >= 0; k--){
            sb.append(list.get(k));
            if(k > 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String reverseWords2(String s){
        s = s.trim();
        StringBuffer sb = new StringBuffer();
        int i = s.length() - 1;
        int j = i;
        while(i >= 0){
            while(i >= 0 && s.charAt(i) != ' '){ i--; }
            //String.substring(bg, ed) ===> [bg, ed)
            sb.append(s.substring(i + 1, j + 1)).append(" ");
            while(i >= 0 && s.charAt(i) == ' '){ i--; }
        }
        return sb.toString().trim();
    }

    @Test
    public void t(){
        String s = "111 222  3333    444  555 ";
        this.reverseWords(s);
    }
}
