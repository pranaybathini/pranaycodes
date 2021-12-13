public class Power {

    //logx solution recursive when both x and y are positive integers
    public static int pow(int x, int y) {
        if (y == 0) {
            return 1;
        }
        int temp = pow(x, y / 2);
        if (y % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }

    //iterative when x and y are both positive integers
    public static int powItr(int x, int y) {
        int result = 1;
        while (y > 0) {
            if (y % 2 == 0) {
                x = x * x;
                y = y / 2;
            } else {
                result = result * x;
                y--;
            }
        }
        return result;
    }

    public static double pow(double x, int n){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            //value of int is -2,147,483,648 to 2,147,483,647.
            // -n of -2,147,483,648 is 2,147,483,648 which causes overflow. Need to handle it.
            return 1/x*pow(1/x,-(n+1));
        }
        return n%2 == 0 ? pow(x*x, n/2) : x*pow(x*x,n/2);
    }

    public static double myPow(double x, int n){
        double ans = 1;
        long nn = n;
        if(n<0) nn = -1 * n;
        while (nn !=0 ){
            if(nn%2 ==0){
                x = x*x; n = n/2;
            }else{
                ans = ans*x; n = n-1;
            }
        }
        if(n<0) ans = (double) (1.0)/(double) (ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(pow(2.0,-5));
        System.out.println(powItr(2,5));
    }
}
