import java.util.Arrays;

/**
 * 最小硬币个数这类的题用dp而不是贪心求解，贪心是局部最优解
 * Created by shuoshuo on 2017/11/11.
 */
public class MinCoins {
    public static void main(String args[])
    {
        int coins[] =  {9, 6, 5, 1};
        int V = 11;
        System.out.println("Minimum coins required is "+ minCoins(coins, V) );
    }

    private static int minCoins(int[] coins, int target) {
        if (target <= 0) {
            return -1;
        }

        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.sort(coins);

        for (int coin : coins) {
            if (coin > target) {
                break;
            }
            dp[coin] = 1;
        }

        for (int i = 1; i <= target; i++) {
            for (int coin : coins) {
                if (coin > i) break;
                if (dp[i - coin] < Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

        return dp[target];
    }
}
