/**
 * 最大和的矩形，复杂的时候可以考虑降维，把二维数组转换成一维数组，问题变成一维数组的最大连续和，那如何
 * 转化呢？ 设一个一维数组，每行的值按对应列加入到这个数组中
 * 时间复杂度O(n^3)
 * Created by shuoshuo on 2017/11/2.
 */
public class MaxSumRectangle {
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println(findMaxSubMatrix(new int[][] {
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        }));
    }

    private static int findMaxSubMatrix(int[][] arr) {
        int m = arr.length, n = arr[0].length, max = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            int[] dp = new int[n];
            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    dp[k] += arr[j][k];
                }
                max = Math.max(max, helper(dp));
            }
        }

        return max;
    }

    private static int helper(int[] dp) {
        int sum = 0, max = Integer.MIN_VALUE;

        for (int i = 0; i < dp.length; i++) {
            if (sum < 0) {
                sum = dp[i];
            } else {
                sum += dp[i];
            }

            max = Math.max(max, sum);
        }
        return max;
    }
}
