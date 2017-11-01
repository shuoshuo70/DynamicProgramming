/**
 * 最大的子数组和，用sum来记录遍历到当前值时的和，如果sum < 0，负数加上x，一定会小于x，所以可直接舍弃原来的
 * 和，从x开始加起，否则，继续向后加，再维护一个变量max，记录在遍历过程中的最大值，因为sum只是表示以i结尾，
 * 且含i的数的最大和，并不是全局最大
 * Created by shuoshuo on 2017/11/1.
 */
public class LargestSubArray {
    public static void main (String[] args)
    {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
    }

    private static int maxSubArraySum(int[] a) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int n : a) {
            if (sum < 0) {
                sum = n;
            } else {
                sum += n;
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}
