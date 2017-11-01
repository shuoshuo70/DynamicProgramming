/**
 * 最长回文子串，用dp记录i，j是否是回文，从中间向外扩展
 * Created by shuoshuo on 2017/11/1.
 */
public class LongestPalindSubstr {
    public static void main(String[] args) {

        String str = "forgeeksskeegfor";
        System.out.println("Length is: " +
                longestPalSubstr(str));
    }

    private static int longestPalSubstr(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int n = str.length(), max = 0;
        boolean[][] dp = new boolean[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if ((j - i < 2 || dp[i + 1][j - 1]) && str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = true;
                    max = Math.max(j - i + 1, max);
                }
            }
        }

        return max;
    }
}
