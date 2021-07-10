package second;

import java.util.ArrayList;
import java.util.List;

/**
 * @author icodeboy
 * 448. 找到所有数组中消失的数字
 */
public class Q448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            while(nums[v - 1] != v){
                int temp = nums[v - 1];
                nums[v - 1] = v;
                v = temp;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1){
                res.add(i + 1);
            }
        }
        return res;
    }
}
