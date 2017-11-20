import java.util.Arrays;

/**
 * 到达车站的最小cost。
 * 找中间的点，经由中间点算cost。这种方式在计算的时候要注意的是（i，k）和（k，j）的距离必须是之前计算好的，所以以length
 * 作为遍历的最外层，从最小的length开始   时间复杂度O（n^3)  空间复杂度O(n^2)
 * 优化：
 * dp[i][j]代表的是从i到j的最小cost，降维：dp[i]代表从0到i的最小cost，因为没有必要算每个起点的cost，各个起点间也没有关联
 * dp[i] = dp[j] + cost[j][i]   时间复杂度O（n^2)  空间复杂度O(n)
 * Created by shuoshuo on 2017/11/20.
 */
public class MinCostToDestination {
    static int INF = Integer.MAX_VALUE,N = 4;

    public static void main(String args[])
    {
        int cost[][] = { {0, 15, 80, 90},
                {INF, 0, 40, 50},
                {INF, INF, 0, 70},
                {INF, INF, INF, 0}
        };
        System.out.println("The Minimum cost to reach station "+ N +
                " is "+minCost2(cost));
    }

    private static int minCost(int[][] cost) {
        int m = cost.length, n = cost[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                    dp[i][j] = cost[i][j];
            }
        }

        for (int len = 2; len < m; len++) {
            for (int i = 0; i + len < m; i++) {
                for (int j = i; j < i + len; j++) {
                    dp[i][i + len] = Math.min(dp[i][i + len], dp[i][j] + dp[j][i + len]);
                }
            }
        }

        return dp[0][n - 1];
    }


    private static int minCost2(int[][] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j  = 0; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + cost[j][i]);
            }
        }

        return dp[n - 1];
    }
}
