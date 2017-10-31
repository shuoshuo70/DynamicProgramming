/**
 * Created by shuoshuo on 2017/10/31.
 */
public class MaxSubSquare {
    public static void main(String[] args)
    {
        int M[][] =  {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        System.out.println(printMaxSubSquare(M));
    }

    private static int printMaxSubSquare(int[][] nums) {
        int m = nums.length, n = nums[0].length, max = 0;
        int[][] dp = new int[m][n];

        dp[0][0] = nums[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = nums[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = nums[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (nums[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }
}
