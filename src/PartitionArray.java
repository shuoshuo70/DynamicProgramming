/**
 * Created by shuoshuo on 2017/10/30.
 */
public class PartitionArray {
    private static boolean findPartition(int[] arr) {
        int n = arr.length, sum = 0;
        for (int num : arr) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        return findSum(arr, 0, n - 1, sum / 2);
    }

    private static boolean findSum(int[] arr, int start, int end, int target) {
        if (start > end) {
            return target == 0;
        }

        for (int i = start; i <= end; i++) {
            if (findSum(arr, i + 1, end, target - arr[i])) {
                return true;
            }
        }

        return false;
    }


    public static void main (String[] args)
    {

        int arr[] = {3, 1, 5};
        if (findPartition(arr) == true)
            System.out.println("Can be divided into two "+
                    "subsets of equal sum");
        else
            System.out.println("Can not be divided into " +
                    "two subsets of equal sum");
    }


}
