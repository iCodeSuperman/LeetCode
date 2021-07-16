package second;


import org.junit.Test;

/**
 * @author icodeboy
 */
public class Q461 {
    public int hammingDistance(int x, int y) {
        int count = 0;

        while(x > 0 && y > 0){
            int a = x & 1;
            int b = y & 1;
            if(a != b){
                count++;
            }
            x = x >> 1;
            y = y >> 1;
        }

        while(x > 0){
            if((x&1) != 0){
                count++;
            }
            x = x >> 1;

        }

        while(y > 0){
            if((y&1) != 0){
                count++;
            }
            y = y >> 1;
        }

        return count;
    }

    @Test
    public void t(){
        System.out.println(this.hammingDistance(4, 1));
    }
}
