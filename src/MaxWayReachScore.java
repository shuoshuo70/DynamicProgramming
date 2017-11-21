/**
 * 有3,5,10三种硬币，凑成总数为20的有多少种，其中5,5,10和5,10,5算作一种
 * 算作一种的话只能先用某一种硬币，看它能凑出什么数，然后再换一种硬币，叠加到上一种上，这样就
 * 保证了硬币的顺序
 * 扩展：如果不同顺序算作不同种呢？
 * 让硬币的金额作为内循环，只要能得到相应的金额不管是什么顺序都相加
 * Created by shuoshuo on 2017/11/20.
 */
public class MaxWayReachScore {
    public static void main(String[] args) {
        int[] arr = {10, 5, 3};
        System.out.println(getCount(20, arr));
    }

    private static int getCount(int n, int[] arr) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= arr[i]) {

                    dp[j] += dp[j - arr[i]];
                }
            }
        }

        return dp[n];
    }
}
