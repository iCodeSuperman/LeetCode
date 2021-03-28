package com.medium;

import org.junit.Test;

public class M318_MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] mask = new int[len];
        int[] wLen = new int[len];

        for(int i = 0; i < len; i++){
            int bitmask = 0;
            String word = words[i];
            wLen[i] = word.length();
            for(int j = 0; j < wLen[i]; j++){
                int index = word.charAt(j) - 'a';
                bitmask = bitmask | 1 << index;
            }
            mask[i] = bitmask;
        }

        int maxLen = 0;
        for(int i = 0; i < words.length - 1; i++){
            for(int j = i + 1; j < words.length; j++){
               if((mask[i] & mask[j]) == 0){
                   int val = wLen[i] * wLen[j];
                   if(val > maxLen){
                       maxLen = val;
                   }
               }
            }
        }
        System.out.println(maxLen);
        return maxLen;
    }

    @Test
    public void test(){
        String[] ws = {"abcw","baz","foo","bar","xtfn","abcdef"};
        this.maxProduct(ws);
        // System.out.println('z' - 'a');
        // int key = 25;
        // int val = 1 << key;
        // key = 3;
        // val = val | 1 << key;
        // System.out.println(Integer.toBinaryString(val));
    }
}
