/**
 * Created by shuoshuo on 2017/10/17.
 */
public class BinomialCoefficient {
    public static void main(String[] args) {
        System.out.println(binomialCoefficientDP(5, 2));
    }

    private static int binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }

    private static int binomialCoefficientDP(int n, int k) {
        int[][] dp = new int[n + 1][n + 1];

        for (int i =0; i <= n; i++) {
            for (int j = 0;j <= i && j <= k;j++) {
                if (j == 0 || i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[n][k];
    }
}
