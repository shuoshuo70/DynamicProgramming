/**
 * Created by shuoshuo on 2017/11/8.
 */
public class CountNonDecrease {
    public static void main(String args[])
    {
        int n = 3;
        System.out.println(countNonDecreasing(n));
    }

    private static int countNonDecreasing(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 10;
        }

        int cnt = 0;
        for (int i = 1; i <= 9; i++) {
            cnt += helper(i, n - 1);
        }

        return cnt;
    }

    private static int helper(int pre, int n) {
        if (n == 0) {
            return 1;
        }

        int cnt = 0;
        for (int i = pre; i <= 9; i++) {
            cnt += helper(i, n - 1);
        }

        return cnt;
    }
}
