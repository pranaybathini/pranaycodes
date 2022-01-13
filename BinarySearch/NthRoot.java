public class NthRoot {
    // complexity = log2(m*d)*n
    // n = for multiplying mid till n for log2(m*d)
    // m = max search space
    // d = number of decimal places, here our eps is till 6 spaces
    public static void main(String[] args) {
        int n = 3, m = 27;
        double eps = 1e-6;
        double high = m, low = 1;
        double mid = 0;
        while ((high - low) > eps) {
            mid = (low + high) / 2;
            if (multiply(mid, n) < m) {
                low = mid;
            } else {
                high = mid;
            }
        }
        System.out.println(mid);
    }

    private static double multiply(double mid, int n) {
        double ans = 1.0;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
        }
        return ans;
    }
}
