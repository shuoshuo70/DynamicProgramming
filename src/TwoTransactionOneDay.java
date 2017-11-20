/**
 * Created by shuoshuo on 2017/11/20.
 */
public class TwoTransactionOneDay {
    public static void main(String args[])
    {
        int price[] = {2, 30, 15, 10, 8, 25, 80};
        System.out.println("Maximum Profit = "+ maxProfit(price));
    }

    private static int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE, sell1 = 0, sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }
}
