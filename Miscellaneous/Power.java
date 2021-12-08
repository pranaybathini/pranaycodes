public class Power {

    //logx solution recursive
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

    //iterative
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

    public static void main(String[] args) {
        System.out.println(pow(2,5));
        System.out.println(powItr(2,5));
    }
}
