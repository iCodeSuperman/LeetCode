package com.ToOffer;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;

/**
 * @author icodeboy
 */
public class Offer057 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int i = 0, j = len - 1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum < target){
                i++;
            }else if(sum > target){
                j--;
            }else{
                return new int[]{nums[i], nums[j]};
            }
        }

        return new int[0];
    }

}
