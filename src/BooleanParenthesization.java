/**
 * 字符数组代表True和False，符号数组代表与或非等各种操作，将两个数组组合在一起，有多少种结果为True的情况
 * 数组的顺序不变，状态dp问题，设置True和False数组。T[i][j]由T[i][k], F[i][k]和T[k+1][j], F[k+1][j]得到
 * 这时候的难点在于i，j，k的赋值顺序，i：0到n-1。j:i+1到n-1。k：i到j-1。但是i，j遍历过程中可能有些值之前
 * 还没有计算过，涉及i，j，k的模板做法是设置gap，从gap为1起，向后计算
 * 时间复杂度O(n^3)
 * 空间复杂的O(n^2)
 * Created by shuoshuo on 2017/11/2.
 */
public class BooleanParenthesization {
    public static void main(String[] args) {
        char[] symbols = {'T', 'F', 'F'};
        char[] operators = {'^', '|'};
        System.out.println(getParenthesization(symbols, operators));
    }

    private static int getParenthesization(char[] symbols, char[] operators) {
        int m = symbols.length;
        int[][] T = new int[m][m], F = new int[m][m];

        for (int i = 0; i < m; i++) {
            if (symbols[i] == 'T') {
                T[i][i] = 1;
            } else {
                F[i][i] = 1;
            }
        }

        for (int gap = 1; gap < m; gap++) {
            for (int i = 0, j = gap; j < m; i++, j++) {
                for (int k = i; k < j; k++) {
                    if (operators[k] == '^') {
                        T[i][j] += T[i][k] * F[k + 1][j] + F[i][k] * T[k + 1][j];
                        F[i][j] += T[i][k] * T[k + 1][j] + F[i][k] * F[k + 1][j];
                    } else if (operators[k] == '&') {
                        T[i][j] += T[i][k] * T[k + 1][j];
                        F[i][j] += T[i][k] + F[k + 1][j] + F[i][k] * T[k + 1][j];
                    } else if (operators[k] == '|') {
                        T[i][j] += (T[i][k] + F[i][k]) * (T[k + 1][j] + F[k + 1][j]) - F[i][k] * F[k + 1][j];
                        F[i][j] += (T[i][k] + F[i][k]) * (T[k + 1][j] + F[k + 1][j]) - T[i][k] * T[k + 1][j];
                    }
                }
            }
        }

        return T[0][m - 1];
    }
}
