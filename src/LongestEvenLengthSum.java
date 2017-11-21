/**
 * 给定一个字符串，从中截取一个长度为2k的子串，子串的左右两部分的和相等，求2k的最大值
 * 求sum，定一个sum数组，这样求i，j的和直接作差即可，k的长度从大到小排列，算到结果就返回
 * 时间复杂度为O(n^2)
 * Created by shuoshuo on 2017/11/21.
 */
public class LongestEvenLengthSum {
    public static void main(String[] args)
    {
        String str = "153803";
        System.out.println("Length of the substring is "
                + findLength(str));
    }

    private static int findLength(String str) {
        int n = str.length();
        int[] sum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            sum[i + 1] += sum[i] + str.charAt(i) - '0';
        }

        for (int k = n / 2; k > 0; k--) {
            for (int i = 0; i + 2 * k < n; i++) {
                int totalSum = sum[i + 2 * k] - sum[i];
                int leftSum = sum[i + k] - sum[i];

                if (totalSum == leftSum * 2) {
                    return 2 * k;
                }
            }
        }

        return 0;
    }

}
