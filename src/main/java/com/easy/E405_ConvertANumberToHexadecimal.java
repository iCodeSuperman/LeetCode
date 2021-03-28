package com.easy;

public class E405_ConvertANumberToHexadecimal {
    public String toHex(int num) {
        if(num == 0) return "0";

        String sep = "0123456789abcdef";
        StringBuffer sb = new StringBuffer();
        char[] arr = sep.toCharArray();
        //注意-1="fff..ffff"，题中规定是32位，所以这里右移次数有限制
        int count = 1;
        while(num != 0 && count <= 8){
            //和0000(6个) 0000 1111与，仅保留低4位，结果为sep中的坐标
            //例如 1010 = 10 = a
            int index = num & 0xf;
            sb.append(arr[index]);
            num >>= 4;
            count++;
        }
        return sb.reverse().toString();
    }
}
