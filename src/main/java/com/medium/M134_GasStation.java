package com.medium;

import org.junit.Test;

/**
 * @author icodeboy
 */
public class M134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for(int i = 0; i < len; i++){
            int rest = gas[i] - cost[i];
            int index = (i + 1) % len;
            while (rest > 0 && index != i){
                rest += gas[index] - cost[index];
                index = (index + 1) % len;
            }
            if(rest >= 0 && index == i){
                return i;
            }
        }
        return - 1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        int curSum = 0;
        int globalSum = 0;
        int start = 0;
        for(int i = 0; i < len; i++){
            curSum += gas[i] - cost[i];
            globalSum += gas[i] - cost[i];
            if(curSum < 0){
                start = i + 1;
                curSum = 0;
            }
        }
        if(globalSum < 0) {
            return -1;
        }
        return start;
    }


    public void print(int[] arr){
        for (int i : arr) {
            System.out.println(i + " ");
        }
    }

    @Test
    public void t(){
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(this.canCompleteCircuit(gas, cost));

    }

    @Test
    public void t1(){
        int len = 6;
        for(int i = 0; i < len; i++){
            int index = (i + 1) % len;
            while(index != i){
                System.out.print(index + " ");
                index = (index + 1) % len;
            }
            System.out.println();
        }
    }
}
