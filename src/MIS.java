/**
 * 递增子序列的最大和，要求序列递增，且和最大，用dp，dp[i]代表的是以arr[i]结尾的子序列的和，如果
 * arr[i] > arr[j]，那么dp[i] = max(dp[i], dp[j] + nums[i]), j从0遍历到i - 1.再取一个变量max，
 * 得到dp数组的最大值
 * Created by shuoshuo on 2017/10/19.
 */
public class MIS {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        System.out.println("Sum of maximum sum increasing "+
                " subsequence is "+
                maxSumIS( arr) );
    }

    private static int maxSumIS(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int n = arr.length, max = arr[0];
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
