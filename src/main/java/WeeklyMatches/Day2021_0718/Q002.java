package WeeklyMatches.Day2021_0718;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 5814. 新增的最少台阶数
 * @author icodeboy
 */

public class Q002 {
    int[] rungs;

    // 在rungs数组中找到第一个比target小的值的下标。
    public int findLessEquals(int target, int start, int end){
        int left = start, right = end;

        while(left < right){
            int mid = (right - left) / 2 + left;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("left="+left+"; right="+right+"; mid="+mid);
            int val = rungs[mid];
            if(val == target){
                return left;
            }else if(val < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left - 1;
    }



    public int addRungs(int[] rungs, int dist) {
        this.rungs = rungs;
        int len = rungs.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(rungs[i], rungs[i]);
        }

        int up = rungs[len - 1];
        int now = 0;
        int index = 0;
        int count = 0;

        while(now < up){
            int newHeight = now + dist;
            if(newHeight < rungs[0]){
                count++;
                now = newHeight;
            }else{
                //比newHeight小的下标
                int position = findLessEquals(newHeight, index, len - 1);
                int tempV = rungs[position];
                System.out.println("tempV="+tempV);
                if(now < tempV){
                    now = tempV;
                    // index = position;
                } else {
                    count++;
                    now = newHeight;
                }
            }
            System.out.println("=========  now="+now+"  ============");
        }
        return count;
    }


    @Test
    public void t(){
        int[] arr = {1,3,5,10};
        int dist = 2;
        System.out.println(this.addRungs(arr, dist));
    }
}
