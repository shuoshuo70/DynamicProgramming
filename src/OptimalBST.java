/**
 * 优化的BST。keys是二叉树节点的val，freq是对应节点的cost，总的cost是节点所在的层数乘以freq，求最小的cost
 * 根据keys数组，BST可以有多种组合方式，对于某一种方式而言，它的总cost的计算可以是：左cost+右cost+根，左右
 * 的cost可以递归的去计算，但是由于cost还与层数有关，dfs计算的时候会少一层，所以，用递归算完以后要再加上
 * 所有节点的cost和，把少算的补上，这样明明是乘法的和就用加法机智的解决了
 * Created by shuoshuo on 2017/11/1.
 */
public class OptimalBST {
    public static void main(String[] args) {
        int keys[] = {10, 12, 20};
        int freq[] = {34, 8, 50};
        System.out.println("Cost of Optimal BST is " +
                optimalSearchTree(keys, freq));
    }

    private static int optimalSearchTree(int[] keys, int[] freq) {
        return helper(keys, freq, 0, keys.length - 1);
    }

    private static int helper(int[] keys, int[] freq, int start, int end) {
        if (start > end) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        int fSum = getSum(freq, start, end);

        for (int i = start; i <= end; i++) {
            int cost = helper(keys, freq, start, i - 1) + helper(keys, freq, i + 1, end);
            min = Math.min(min, cost);
        }
        return min + fSum;
    }

    private static int getSum(int[] freq, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += freq[i];
        }
        return sum;
    }

}