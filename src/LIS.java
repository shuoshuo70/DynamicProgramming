import java.util.Arrays;

/**
 * Created by shuoshuo on 2017/10/16.
 */
public class LIS {

    public static void main(String[] args) {
        int arr[] = {50, 3, 10, 7, 40, 80, 39};
        System.out.println(findLIS(arr));
    }

    private static int findLIS(int[] arr) {
        int len = 0;
        int[] increases = new int[arr.length];
        int[] parent = new int[arr.length];
        Arrays.fill(parent, -1);

        for (int n : arr) {
            if (len == 0 || increases[len - 1] < n) {
                //只有在新值加入时才会影响到parent
                if (len > 0) {
                    parent[len] = increases[len - 1];
                }
                increases[len++] = n;

            } else {
//                int index = Arrays.binarySearch(increases, 0, len, n);
//                if (index < 0) {
//                    index = -index - 1;
//                }
                int index = binarySearch(increases, 0, len - 1, n);
                increases[index] = n;

            }
        }

        for (int i = 0; i < len; i++) {
            System.out.print(parent[i] + "->");
        }
        System.out.println();
        return len;
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
