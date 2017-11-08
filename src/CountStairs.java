/**
 * Created by shuoshuo on 2017/11/8.
 */
public class CountStairs {
    public static void main (String args[])
    {
        int s = 4;
        System.out.println("Number of ways = "+ countWays(s));
    }

    private static int countWays(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[num];
    }
}
