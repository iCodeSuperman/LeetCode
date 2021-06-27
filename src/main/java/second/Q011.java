package second;

/**
 *  011. 盛最多水的容器
 */
public class Q011 {
    public int maxArea(int[] height) {
        int max = -1;
        int i = 0, j = height.length;
        while(i < j){
            int area = 0;
            if(height[i] > height[j]){
                area = (j - i) * height[j];
                j--;
            }else{
                area = (j - i) * height[i];
                i++;
            }
            max = max > area ? max : area;
        }
        return max;
    }
}
