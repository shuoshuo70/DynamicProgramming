import java.util.Arrays;

/**
 * Created by shuoshuo on 2017/10/16.
 */
public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int arr[] = new int[] {1, 2, 3, 4, 3};

        System.out.println("Minimum number of multiplications is "+
                matrixChainOrder(arr));
    }

    //分治合并
    public static int matrixChainOrder(int[] arr) {
        int[][] visited = new int[arr.length][arr.length];
        for (int[] nums : visited) {
            Arrays.fill(nums, Integer.MAX_VALUE);
        }

        return matrixChainOrder(arr, 0, arr.length - 1, visited);
    }

    private static int matrixChainOrder(int[] arr, int start, int end, int[][] visited) {
        if (visited[start][end] != Integer.MAX_VALUE) {
            return visited[start][end];
        }

        int sum = 0, minValue = Integer.MAX_VALUE;
        if (start + 1 >= end) {
            return 0;
        }

        for (int i = start + 1; i < end; i++) {
            sum = matrixChainOrder(arr, start, i, visited) + matrixChainOrder(arr, i, end, visited) + arr[start] * arr[i] * arr[end];
            minValue = Math.min(minValue, sum);
        }

        visited[start][end] = minValue;
        return minValue;
    }

    //dp
    public static int matrixChainOrderDP(int[] p) {
        int n = p.length;
        int m[][] = new int[n][n];

        int i, j, k, L, q;

        /* m[i,j] = Minimum number of scalar multiplications needed
        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is p[i-1] x p[i] */

        // cost is zero when multiplying one matrix.
        for (i = 1; i < n; i++)
            m[i][i] = 0;

        // L is chain length.
        for (L=2; L<n; L++)
        {
            for (i=1; i<n-L+1; i++)
            {
                j = i+L-1;
                if(j == n) continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k=i; k<=j-1; k++)
                {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n-1];
    }
}
