/**
 * Created by shuoshuo on 2017/11/1.
 */
public class SubsetSum {
    public static void main (String args[])
    {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        if (isSubsetSum(set, sum) == true)
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");
    }

    private static boolean isSubsetSum(int[] arr, int sum) {
        return helper(arr, 0, arr.length - 1, sum);
    }

    private static boolean helper(int[] arr, int start, int end, int sum) {
        if (start > end) {
            return sum == 0;
        }

        for (int i = start; i <= end; i++) {
            if (helper(arr, i + 1, end, sum) || helper(arr, i + 1, end, sum - arr[i])) {
                return true;
            }
        }

        return false;
    }
}
