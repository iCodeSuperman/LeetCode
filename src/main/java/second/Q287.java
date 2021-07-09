package second;

/**
 * 287. 寻找重复数
 * @author icodeboy
 */
public class Q287 {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while(fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
