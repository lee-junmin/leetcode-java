package powXN;

public class SolutionRecursive {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        double res = helper(x,n);
        if (n < 0) res = 1 / res;
        return res;
    }

    private double helper(double x, int n){
        if (n == 0) return 1;
        double result = helper(x, Math.abs(n/2));
        result *= result;
        if (n % 2 != 0) result *= x;
        return result;
    }
}
