/**
 * 键盘上0-9可点，点击一个键以后只能点上下左右的四个键，点击n下后总共有多少种可能的结果
 * 第一下可以有10种选择，之后每个最多有4种。
 * Created by shuoshuo on 2017/11/8.
 */
public class MobileKeypad {
    public static void main(String[] args) {
        char[][] keypad = {{'1','2','3'},{'4','5','6'}, {'7','8','9'}, {'*','0','#'}};
        System.out.println("Count for numbers of length :" + getCount(keypad, 1));
        System.out.println("Count for numbers of length :" + getCount(keypad, 2));
        System.out.println("Count for numbers of length :" + getCount(keypad, 3));
        System.out.println("Count for numbers of length :" + getCount(keypad, 4));
        System.out.println("Count for numbers of length :" + getCount(keypad, 5));
    }

    static final int[] x = {0, -1, 0, 0, 1};
    static final int[] y = {0, 0, 1, -1, 0};
    private static int getCount(char[][] keypad, int n) {
        if (n <= 0) return 0;
        if (n == 1) return 10;

        int cnt = 0;
        for (int i = 0; i < keypad.length; i++) {
            for (int j = 0; j < keypad[0].length; j++) {
                if (keypad[i][j] != '*' && keypad[i][j] != '#') {
                    cnt += getCount(keypad, n, i, j);
                }
            }
        }
        return cnt;
    }

    /**
     * 每一个进入这个方法的都是valid，所以当n = 1时，返回1
     * @param keypad
     * @param n
     * @param i
     * @param j
     * @return
     */
    private static int getCount(char[][] keypad, int n, int i, int j) {
        if (n == 1) {
            return 1;
        }

        int cnt = 0;
        for (int k = 0; k <x.length; k++) {
            int row = i + x[k], column = j + y[k];
            if (row >= 0 && row < keypad.length && column >= 0 && column < keypad[0].length) {
                if (keypad[row][column] != '*' && keypad[row][column] != '#') {
                    cnt += getCount(keypad, n - 1, row, column);
                }
            }
        }
        return cnt;
    }
}
