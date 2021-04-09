package se.review;

public class Q075_SortColors {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if(len < 3){
            return;
        }

        /**
         * 区间分布示意图
         * [0, zero) -> 0
         * [zero, i) -> 1
         * [two, len-1] -> 2
         */

        /**
         * 初始态: 确保0区间无元素，zero=0，即[0,0)
         * 交换前: zero指向0区间的下一个位置
         * 交换: i遍历到0元素时，交换nums[zero]和nums[i] (交换后，此时zero指向0区间尾巴)
         * 交换后: zero再自增 (自增后确保zero一直指向0区间的下一个位置)
         *        i也自增 (因为i >= zero, 所以zero动，i必须动)
         */
        int zero = 0;

        /**
         * 循环结束条件: i == two 即i遍历到了2区间头位置，表示完成了排序
         * 循环条件: i < two
         * 变换状态: [1]当前遍历到0元素，zero++ i++  [2]当前遍历到1元素，i++  [3]当前遍历到2元素 two--
         */
        int i = 0;


        /**
         * 初始态: 确保1区间无元素，two=len，即[len, len-1]
         * 交换前: two指向2区间头位置
         * 交换: i遍历到2元素时，先two--, 再交换nums[i]和nums[two] (确保two一直指向2元素的头位置)
         *
         */
        int two = len;

        while(i < two){
            if(nums[i] == 0){
                swap(nums, zero, i);
                zero++;
                i++;
            }else if(nums[i] == 1){
                i++;
            }else{
                two--;
                swap(nums, i, two);
            }
        }


    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
