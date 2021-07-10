package WeeklyMatches.Day2021_0710;

import org.junit.Test;

/**
 * 5792. 统计平方和三元组的数目
 */
public class Q001 {
    public int countTriples(int n) {
        int res = 0;
        for (int c = 1; c <= n; c++) {
            for (int a = 1; a < c; a++) {
                for (int b = 1; b < c; b++) {
                    if(a*a + b*b == c*c){
                        res++;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void t(){
        System.out.println(countTriples(10));
    }
}
