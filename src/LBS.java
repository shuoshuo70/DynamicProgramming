import java.util.Arrays;

/**
 * 最长的折线子序列，折线：开始时序列递增，之后序列下降，如果一个序列一直递增，可以看做递减序列长度为0，
 * 同样地，如果一个序列一直递减，可以看做递增序列长度为0
 * 思考：有递增有递减，我们很难估计转折点在哪，那就干脆不算转折点，从左往右算一次递增，再从右往左算一次
 * 递增（相当于从左往右的递减），把位置i当做转折点，那它的递增和递减长度之和就是折线的长度
 * dp[i] = left[i] + right[i] - 1
 * Created by shuoshuo on 2017/10/30.
 */
public class LBS {
    public static void main(String[] args) {
        int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5,
                13, 3, 11, 7, 15};
        System.out.println(lbs(arr));
    }

    private static int lbs(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n + 1], right = new int[n + 1];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i =  1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i - 1] > arr[j - 1]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }

        for (int i = n - 1; i > 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[i - 1] > arr[j - 1]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            max = Math.max(left[i] + right[i] - 1, max);
        }
        return max;
    }
}
