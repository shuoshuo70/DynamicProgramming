/**
 * 跳到最后一格的最少步数，curMax代表当前本层可以跳的格子，nextMax代表下一步可跳的位置，要一直跳到
 * nextMax等于最后一格
 * Created by shuoshuo on 2017/10/31.
 */
public class MinStep {
    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 1, 0, 9};

        System.out.println("Minimum number of jumps to reach end is : "+
                minJumps(arr));
    }

    private static int minJumps(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int step = 0, curMax = 0, nextMax = 0, i = 0;

       while (nextMax < arr.length - 1) {
           for(; i <= curMax && i < arr.length; i++) {
               nextMax = Math.max(nextMax, i + arr[i]);
           }

           step++;
           curMax = nextMax;
       }

        return step;
    }

}
