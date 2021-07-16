package second;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author icodeboy
 * 739. 每日温度
 */
public class Q739 {


    public int[] dailyTemperatures(int[] temperatures){
        int len = temperatures.length;
        int[] res = new int[len];
        res[len - 1] = 0;
        //严格单调递减栈，存下标。遇到相等的也出栈前一个
        Deque<Integer> st = new ArrayDeque<>();
        st.addLast(len - 1);
        for (int i = len - 2; i >= 0; i++) {
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.getLast()]){
                st.removeLast();
            }
            if(st.isEmpty()){
                res[i] = 0;
            }else{
                res[i] = st.getLast() - i;
            }
            st.addLast(i);
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        for (int i = 0; i < len - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < len; j++) {
                if(temperatures[i] > temperatures[j]){
                    count++;
                }else{
                    res[i] = count;
                }
            }
        }
        res[len -  1] = 0;
        return res;
    }
}
