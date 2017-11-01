/**
 * 第k个丑数。丑数是有2,3,5组成的数，丑数可以认为是已经生成的丑数序列再乘以2,3,5. 那如何得到原来的丑数序列？
 * 用数组保存，原来的丑数，每个数都要乘以2,3,5.得到的三个数哪个数最小，那相应的向后移一位，下次用移动后的数
 * 与剩下的两个数在比较
 * Created by shuoshuo on 2017/11/1.
 */
public class UglyNumber {
    public static void main(String args[])
    {
        UglyNumber obj = new UglyNumber();
        int no = obj.getNthUglyNo(150);
        System.out.println("150th ugly no. is "+ no);
    }

    private int getNthUglyNo(int k) {
        //xa,xb,xc是待比较的三个数，a,b,c是指向已经生成的丑数序列的三个指针
        int xa = 1, xb = 1, xc = 1, a = 0, b = 0, c = 0;
        int[] dp = new int[k];

        for (int i = 0; i < k; i++) {
            dp[i] = Math.min(xa, Math.min(xb, xc));
            if (dp[i] == xa) {
                xa = 2 * dp[a++];
            }
            if (dp[i] == xb) {
                xb = 3 * dp[b++];
            }
            if (dp[i] == xc) {
                xc = 5 * dp[c++];
            }
        }

        return dp[k - 1];
    }
}
