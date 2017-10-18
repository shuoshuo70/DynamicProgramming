import java.util.Arrays;

/**
 * 截木棍，用分治的思想，取长度x，则cutRod(arr, n) = arr[x] + cutRod(arr, n - x)
 * Created by shuoshuo on 2017/10/18.
 */
public class CutRod {
    public static void main(String[] args) {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(arr));
    }

    private static int cutRod(int[] arr) {
        int[] mem = new int[arr.length + 1];
        Arrays.fill(mem, Integer.MIN_VALUE);
        return cutRod(arr, arr.length, mem);
    }

    private static int cutRod(int[] arr, int n, int[] mem) {
        if (n <= 0) return 0;

        if (mem[n] != Integer.MIN_VALUE) {
            return mem[n];
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, arr[i] + cutRod(arr, n - i - 1, mem));
        }

        mem[n] = res;
        return res;
    }
}
