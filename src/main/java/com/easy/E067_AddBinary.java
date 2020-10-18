package com.easy;

public class E067_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        int na, nb, sum = 0;
        while(i >= 0 || j >= 0){
            na = (i >= 0 ? a.charAt(i) - '0' : 0);
            nb = (j >= 0 ? b.charAt(j) - '0' : 0);
            sum = na + nb + carry;
            carry = sum / 2;
            sb.append(sum % 2);
            i--;
            j--;
        }
        if(carry == 1){
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i, j, na, nb, carry = 0, sum = 0;
        for(i = a.length() - 1, j = b.length() - 1; i >= 0 && j >= 0; i--, j--) {
            na = a.charAt(i) - '0';
            nb = b.charAt(j) - '0';
            sum = na + nb + carry;
            if (sum == 0) {
                sb.insert(0, '0');
                carry = 0;
            } else if (sum == 1) {
                sb.insert(0, '1');
                carry = 0;
            } else if (sum == 2) {
                sb.insert(0, '0');
                carry = 1;
            } else if (sum == 3) {
                sb.insert(0, '1');
                carry = 1;
            }
        }


        while(i >= 0){
            na = a.charAt(i) - '0';
            sum = na + carry;
            if(sum == 0){
                sb.insert(0, '0');
                carry = 0;
            }else if(sum == 1){
                sb.insert(0, '1');
                carry = 0;
            }else if(sum == 2){
                sb.insert(0, '0');
                carry = 1;
            }
            i--;
        }

        while(j >= 0){
            nb = b.charAt(j) - '0';
            sum = nb + carry;
            if(sum == 0){
                sb.insert(0, '0');
                carry = 0;
            }else if(sum == 1){
                sb.insert(0, '1');
                carry = 0;
            }else if(sum == 2){
                sb.insert(0, '0');
                carry = 1;
            }
            j--;
        }

        if(i < 0 && j < 0 && carry == 1){
            sb.insert(0, '1');
        }



        return sb.toString();
    }
}
