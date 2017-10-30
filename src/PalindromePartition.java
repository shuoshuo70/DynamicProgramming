/**
 * 一个字符串至少切几下才能保证每段都是回文
 * 回文的判断还是老办法dp[i+1][j-1]推dp[i][j]，再额外加一个cut数组，str(i, j)是回文的话，str（i，）的cut
 * 就是str（j+1,）的cut + 1
 * Created by shuoshuo on 2017/10/30.
 */
public class PalindromePartition {
    private static int minPalPartion(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int n = str.length();
        int[] cut = new int[n + 1];
        boolean[][] dp = new boolean[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            cut[i] = n - i - 1;
            for (int j = i; j < n; j++) {
                if ((j - i < 2 || dp[i + 1][j - 1]) && str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = true;
                    cut[i] = Math.min(cut[i], cut[j + 1] + 1);
                }
            }
        }

        return cut[0];
    }

    public static void main(String args[])
    {
        String str = "ababbbabbababa";
        System.out.println("Min cuts needed for "+
                "Palindrome Partitioning is "+
                minPalPartion(str));
    }
}
