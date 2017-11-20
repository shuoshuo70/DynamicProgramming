/**
 * 求从1到n的所有数的每一位数字的加和
 * 328为例，首位出现的次数10的len-1次幂，当然3出现的次数只有28+1次，后面就是1~99...9出现的次数，出现3次，
 * 再加上28出现的次数，递归求就好
 * Created by shuoshuo on 2017/11/20.
 */
public class SumOfDigits {
    public static void main(String args[])
    {
        int n = 328;
        System.out.println("Sum of digits in numbers"
                +" from 1 to " + n + " is "
                + sumOfDigitsFrom1ToN(n));
    }

    private static int sumOfDigitsFrom1ToN(int n) {
        if (n <= 9) {
            return (1 + n) * n / 2;
        }

        String val = String.valueOf(n);
        int len = val.length(), head = val.charAt(0) - '0', last = Integer.parseInt(val.substring(1));
        int multiNum = (int)Math.pow(10, len - 1);

        return sumOfDigitsFrom1ToN(head - 1) * multiNum
                + head * (last + 1 + sumOfDigitsFrom1ToN(multiNum - 1)) + sumOfDigitsFrom1ToN(last);
    }
}
