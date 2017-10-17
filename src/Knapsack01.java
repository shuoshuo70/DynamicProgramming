/**
 * 0-1背包问题，有i件物品，可用重量为j，那么最大的value可能是两种情况：
 * 1） 第i件物品重量超重，无法放入   dp[i][j] = dp[i - 1][j]
 * 2) 第i件物品可放入：  放与不放对比 max(dp[i - 1][j - w[i]] + val[i], dp[i - 1][j])
 * Created by shuoshuo on 2017/10/17.
 */
public class Knapsack01 {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        System.out.println(knapSack(W, wt, val));
    }

    private static int knapSack(int w, int[] wt, int[] val) {
        int[][] dp = new int[wt.length + 1][w + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[wt.length][w];
    }
}
