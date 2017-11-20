
/**
 * 求两路的最大值，其中一路走过的值就变成0。
 * 一路的时候是下一步能走到哪，取最大值，两路的时候也是用一样的算法。
 * 两路同时走，每次下探一行，如果恰好y1 == y2，那两路走的是同一个格子，加和为其中一个的值，每次下探有9种不同的组合状态，
 * 取其中最大的那一组即可
 * Created by shuoshuo on 2017/11/11.
 */
public class MaxPointsTwoTraversals {
    public static void main(String[] args) {
        int arr[][] = {{3, 6, 8, 2},
            {5, 2, 4, 3},
            {1, 1, 20, 10},
            {1, 1, 20, 10},
            {1, 1, 20, 10},
        };
        System.out.println(maxPoints(arr));
    }

    private static int maxPoints(int[][] arr) {
       return helper(arr, 0, 0, arr[0].length - 1);
    }

    private static int helper(int[][] arr, int x, int y1, int y2) {
        if (!isValid(arr, x, y1, y2)) {
            return Integer.MIN_VALUE;
        }

        if (x == arr.length - 1 && y1 == 0 && y2 == arr[0].length - 1) {
            return y1 == y2 ? arr[x][y1] : arr[x][y1] + arr[x][y2];
        }

        if (x == arr.length - 1) {
            return Integer.MIN_VALUE;
        }

        int ans = Integer.MIN_VALUE;

        int temp = (y1 == y2)? arr[x][y1]: arr[x][y1] + arr[x][y2];

        ans = Math.max(ans, temp + helper(arr, x+1, y1, y2-1));
        ans = Math.max(ans, temp + helper(arr, x+1, y1, y2+1));
        ans = Math.max(ans, temp + helper(arr, x+1, y1, y2));

        ans = Math.max(ans, temp + helper(arr, x+1, y1-1, y2));
        ans = Math.max(ans, temp + helper(arr, x+1, y1-1, y2-1));
        ans = Math.max(ans, temp + helper(arr, x+1, y1-1, y2+1));

        ans = Math.max(ans, temp + helper(arr, x+1, y1+1, y2));
        ans = Math.max(ans, temp + helper(arr, x+1, y1+1, y2-1));
        ans = Math.max(ans, temp + helper(arr, x+1, y1+1, y2+1));

        return ans;
    }


    private static boolean isValid(int[][] arr, int x, int y1, int y2) {
        int m = arr.length, n = arr[0].length;
        return x >= 0 && x < m && y1 >= 0 && y1 < n &&y2 >= 0 && y2 < n;
    }
}
