package second;

/**
 * 050 POW(x,n)
 * @author icodeboy
 */
public class Q050 {
    public double myPow(double x, int n) {
        return n >= 0 ? pow(x, n) : 1.0 / pow(x, n);
    }

    public double pow(double x, int n){
        if(n == 0){
            return 1.0;
        }
        double y = pow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
