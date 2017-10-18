/**
 * 最长回文子序列，思路与最长回文子串类似，从中间向两边扩展，若两侧值相等，则dp[i][j] = dp[i + 1][j - 1] + 2,若不相等，
 * 则取不含i或j的最大值，max(dp[i][j - 1], dp[i + 1][j])
 * 初始化：i，j相同时dp[i][j] = 1
 * Created by shuoshuo on 2017/10/18.
 */
public class LPS {
    public static void main(String[] args) {
        System.out.println(getLPS("EEKSGEEKS")); //EESEE
    }

    private static int getLPS(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i > 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[1][n];
    }


}
