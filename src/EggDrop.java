import java.util.Arrays;

/**
 * 在第x层抛下一颗鸡蛋，有两种情况：
 * 1）坏了，还剩n - 1颗鸡蛋，只能在x - 1层中选择 dp[x - 1][n - 1]
 * 2) 没坏，还剩n颗鸡蛋，在 k - x层中选择  dp[k - x][n]
 * 不管是哪种情况，为了保证能选出楼层，必须在两者中取最大值
 * Created by shuoshuo on 2017/10/17.
 */
public class EggDrop {
    public static void main(String[] args) {
        System.out.println(getSteps(100, 2));
    }

    private static int getSteps(int floors, int eggs) {
        int[][] dp = new int[floors + 1][eggs + 1];

        for (int[] n : dp) {
            Arrays.fill(n, Integer.MAX_VALUE);
        }

        //鸡蛋有0个时，0次， 1个时，1次
        for (int i =0; i <= floors; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }

        //楼层0层时，不用抛，0次，1层时，1次
        for (int j = 0; j <= eggs; j++) {
            dp[0][j] = 0;
            dp[1][j] = 1;
        }

        //楼层总数不能直接用floors，要一点一点算过去，所以先设置i为当前的总楼层数
        for (int i = 2; i <= floors; i++) {
            //当前j个鸡蛋
            for (int j = 2; j <= eggs; j++) {
                //从第k层抛下
                for (int k = 1; k <= i; k++) {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[k - 1][j - 1], dp[i - k][j]));
                }
            }
        }

        return dp[floors][eggs];
    }
}
