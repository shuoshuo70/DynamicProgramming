/**
 * 两个字符串组成的最短字符串长度，使得该字符串的子序列包含原来的两个字符串，比如geek和eke，返回geeke的长度；
 * aggtab和gxtxayb，返回agxgtxayb的长度
 * 新的字符串构成：两个字符串的最长公共子序列，加上两个字符串剩余的部分组成，所以返回的长度应该是两串之和减去
 * LCS长度。将问题转化为求LCS
 * Created by shuoshuo on 2017/11/20.
 */
public class ShortestCommonSuperSequence {
    public static void main(String args[])
    {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println("Length of the shortest supersequence is "
                +shortestSuperSequence(X, Y));
    }

    private static int shortestSuperSequence(String x, String y) {
        int commonLen = getLCS(x, y);
        return x.length() + y.length() - commonLen;
    }

    private static int getLCS(String x, String y) {
        int m = x.length(), n = y.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
