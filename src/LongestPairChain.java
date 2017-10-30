import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by shuoshuo on 2017/10/30.
 */
public class LongestPairChain {
    private static int maxChainLength(Pair[] arr) {
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.a - p2.a;
            }
        });

        int n = arr.length, max = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i].a > arr[j].b) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        Pair arr[] = new Pair[] {new Pair(5,24), new Pair(15, 25),
                new Pair (27, 40), new Pair(50, 60)};
        System.out.println("Length of maximum size chain is " +
                maxChainLength(arr));
    }
}

class Pair{
    int a;
    int b;
    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}