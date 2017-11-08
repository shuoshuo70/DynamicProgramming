/**
 * 找到start为起点的递增的最长串，第一步先找起点，找到起点，长度至少为1，所以递归调用1 + helper(),target变为下一个字符
 * 起点位置为i，j的八个方位，这八个方位中有的可以找到target，有的找不到，所以用max比较，dfs的思路，尝试向下寻找
 * 同样的也是第一位和其他不同，第一位在mat里找match，后面的在前一位的八个方位上，分成两个函数来描述
 * 同一个值可能会遍历多次，用cache存起来
 * Created by shuoshuo on 2017/11/8.
 */
public class LongestConsecutivePath {
    public static void main(String args[])
    {
        char mat[][] = { {'a','c','d'},
                { 'h','b','a'},
                { 'i','g','f'}};

        System.out.println(getLen(mat, 'a') );
        System.out.println(getLen(mat, 'e') );
        System.out.println(getLen(mat, 'b') );
        System.out.println(getLen(mat, 'f') );
    }

    static final int[] x = {-1, 0, 1};
    static final int[] y = {-1, 0, 1};
    private static int getLen(char[][] mat, char start) {
        int m = mat.length, n = mat[0].length, i = 0, j = 0;
        int[][] cache = new int[m][n];

        for (i = 0; i < m; i++) {
            for(j = 0; j < n; j++) {
                if (mat[i][j] == start) {
                    return 1 + findLen(mat, ++start, i, j, cache);
                }
            }
        }

        return 0;
    }

    /**
     * 下探的条件是在数组范围内且值为target
     * @param mat
     * @param target
     * @param i
     * @param j
     * @return
     */
    private static int findLen(char[][] mat, char target, int i, int j, int[][] cache) {
        int res = 0;

        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        for (int k1 = 0; k1 < x.length; k1++) {
            for (int k2 = 0; k2 < y.length; k2++) {
                int row = i + x[k1], column = j + y[k2];
                if (row == i && column == j) {
                    continue;
                }
                if (row >= 0 && row < mat.length && column >=0 && column < mat[0].length && mat[row][column] == target) {
                    res = Math.max(res, 1 + findLen(mat, ++target, row, column, cache));
                }
            }
        }

        cache[i][j] = res;
        return res;
    }
}
