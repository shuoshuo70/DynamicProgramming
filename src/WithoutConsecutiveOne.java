/**
 * 不连续的0和1，在第i位只有0和1两种状态，若第i位是0，则i - 1位可以是0和1，若第i位是1，则i - 1位只能是0，
 * 两种状态用两个dp数组表示，类似于股票的题。
 * 状态转移的由***变成***，都用dp，每个状态用一个dp数组表示
 * Created by shuoshuo on 2017/11/2.
 */
public class WithoutConsecutiveOne {
    public static void main (String args[])
    {
        System.out.println(countStrings(3));
    }

    private static int countStrings(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] zeros = new int[n], ones = new int[n];
        zeros[0] = 1;
        ones[0] = 1;

        for (int i = 1; i < n; i ++) {
            zeros[i] = zeros[i - 1] + ones[i - 1];
            ones[i] = zeros[i - 1];
        }

        return zeros[n - 1] + ones[n - 1];
    }
}
