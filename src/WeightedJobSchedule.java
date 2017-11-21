import java.util.Arrays;
import java.util.Comparator;

/**
 * 每个任务都有起止时间和value，任务之间不可以重叠，求最大的value和
 * 如果没有value的话，问最多可以安排多少个任务，可以用greedy，按任务的end时间排序，越早结束的先加入
 * 但是本题计算的是value，不能一定先结束的任务就有大value，大value的有可能占用的时间又久，只能用dp解
 * 先按任务的end日期排序，对于某个任务来说，他要么加入，要么不加入，这两种方案，加入的话，向前找哪个任务
 * 可以放在它之前，算前面的总value，加上当前点
 * 在查找前一个任务时，可以用二分加快查找
 * 时间复杂度 O(nlogn)
 * Created by shuoshuo on 2017/11/21.
 */
public class WeightedJobSchedule {
    public static void main(String[] args)
    {
        Job jobs[] = {new Job(1, 2, 50), new Job(3, 5, 20),
                new Job(6, 19, 100), new Job(2, 100, 200)};

        System.out.println("Optimal profit is " + schedule(jobs));
    }

    private static int schedule(Job[] jobs) {
        Arrays.sort(jobs, new Comparator<Job>() {
            public int compare(Job job1, Job job2) {
                return job1.end - job2.end;
            }
        });

        int[][] mem = new int[jobs.length][jobs.length];
        return schedule(jobs, 0, jobs.length - 1, mem);
    }

    private static int schedule(Job[] jobs, int left, int right, int[][] mem) {
        if (left > right) {
            return 0;
        }

        if (left == right) {
            return jobs[right].value;
        }

        if (mem[left][right] != 0) {
            return mem[left][right];
        }
        int index = findBeforeJobBinarySearch(jobs, left, right);
        int ans = Math.max(schedule(jobs, left, right - 1, mem), schedule(jobs, left, index, mem) + jobs[right].value);

        mem[left][right] = ans;
        return ans;
    }

    private static int findBeforeJob(Job[] jobs, int left, int right) {
        int index = -1;
        for (int i = right - 1; i >= left; i--) {
            if (jobs[i].end <= jobs[right].start) {
                index = i;
                break;
            }
        }

        return index;
    }

    private static int findBeforeJobBinarySearch(Job[] jobs, int left, int right) {
        int low = left, high = right - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid].end <= jobs[right].start) {
                if (mid + 1 <= right && jobs[mid + 1].end <= jobs[right].start) {
                    low = mid + 1;
                } else {
                    return low;
                }
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}

class Job {
    int start, end, value;
    Job (int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}
