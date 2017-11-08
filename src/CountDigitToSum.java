/**
 *  求由n位数字组成的数的和为sum的个数。n位数首位1-9，其余0-9.分成两部分，先计算首位，剩下的sum就是sum-x，
 *  剩下的再用0-9算
 *  这类问题的做法就是找不同，按步骤。 类似的还有电话按键的，先把特殊的第一步计算好，后面的写在另外一个方法
 *  里面递归即可
 * Created by shuoshuo on 2017/11/8.
 */
public class CountDigitToSum {
    public static void main (String args[])
    {
        int n = 2, sum = 5;
        System.out.println(countDigits(n, sum));
    }

    private static int countDigits(int n, int sum) {
        int cnt = 0;

        for (int i = 1; i <= 9; i++) {
            if (sum - i < 0) {
                break;
            }
            cnt += helper(n - 1, sum - i);
        }
        return cnt;
    }

    private static int helper(int n, int sum) {
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }

        int cnt = 0;
        for (int i = 0; i <= 9; i++) {
            if (sum - i < 0) {
                break;
            }
            cnt += helper(n - 1, sum - i);
        }

        return cnt;
    }
}
