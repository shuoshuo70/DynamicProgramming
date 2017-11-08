/**
 * 从起点（0,0）移动到（r，c），在移动的过程中要始终保持每个方块内的生命值大于等于1
 * 设置dp数组，dp[i][j]表示进入方块(i,j)前的生命值，一旦进入，下一个去向就是dp[i+1][j]和dp[i][j+1]，这两个
 * 值代表的是进入这两个块前的生命值，也就是进入(i,j)后的生命值，dp[i][j] + nums[i][j] = dp[i+1][j]或dp[i][j+1]
 * 若希望dp[i][j]最小，则应该选取dp[i+1][j]和dp[i][j+1]中的最小值。
 * nums[i][j]有三种情况：
 * 1. nums[i][j]为0， 经过后生命值不变
 * 2. nums[i][j] < 0，dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) - nums[i][j]
 * 3. nums[i][j] > 0, dp[i][j]在相减以后变得很小、甚至为负数，但是要保证生命值为1，所以dp[i][j]最小为1
 *                    dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - nums[i][j])
 * Created by shuoshuo on 2017/11/8.
 */

public class MInPointsReachDes {
    public static void main (String args[])
    {
        int points[][] = { {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
        };
        int R = 3, C = 3;
        System.out.println("Minimum Initial Points Required: "+
                minInitialPoints(points, R, C) );
    }

    private static int minInitialPoints(int[][] nums, int r, int c) {
        int[][] dp = new int[r][c];
        dp[r - 1][c - 1] = Math.max(1 - nums[r - 1][c - 1], 1);

        for (int i = r - 2; i >= 0; i--) {
            dp[i][c - 1] = Math.max(1, dp[i + 1][c - 1] - nums[i][c - 1]);
        }

        for (int j = c - 2; j >= 0; j--) {
            dp[r - 1][j] = Math.max(1, dp[r - 1][j + 1] - nums[r - 1][j]);
        }

        for (int i = r - 2; i >= 0; i--) {
            for (int j = c - 2; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - nums[i][j]);
            }
        }

        return dp[0][0];
    }

}
