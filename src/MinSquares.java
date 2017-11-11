import java.util.Arrays;

/**
 * 求某个数最少由多少个平方数组成
 * Created by shuoshuo on 2017/11/11.
 */
public class MinSquares {
    public static void main(String args[])
    {
        System.out.println(getMinSquares(6));
    }

    private static int getMinSquares(int num) {
        if (num <= 0) {
            return 0;
        }

        int[] dp =new int[num + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i <= Math.sqrt(num); i++) {
            dp[i * i] = 1;
        }

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j * j < i; j++) {
                if (dp[i - j * j] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[num];
    }
}
