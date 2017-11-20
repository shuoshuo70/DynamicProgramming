/**
 * 键盘只有输入单个A,ctrl-A，ctrl-C，ctrl-V这四种操作。求N次操作以后，A的最大个数
 * 执行全选-复制-粘贴这三个步骤后，A的个数变为dp[i-3]的二倍，之后可以一直执行粘贴操作，长度变为第一次粘贴之后
 * 每次增加dp[i-3]这么长，关键点在于什么时候执行复制呢，取复制的点为j，共有i次操作，则长度为
 * dp[j - 3] * (i - j + 2)
 * Created by shuoshuo on 2017/11/20.
 */
public class FourKeys {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.println(fourKeys(i));
        }

    }

    private static int fourKeys(int n) {
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 4; i <= n; i++) {
            for (int j = 4; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 3] * (i - j + 2));
            }
        }

        return dp[n];
    }
}
