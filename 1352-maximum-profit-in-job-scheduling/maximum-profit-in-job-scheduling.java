import java.util.*;

class Solution {
    int[][] jobs;
    Integer[] dp;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        dp = new Integer[n];
        return solve(0);
    }

    private int solve(int i) {
        if (i >= jobs.length) return 0;

        if (dp[i] != null) return dp[i];

        // Skip current job
        int skip = solve(i + 1);

        // Take current job
        int next = findNext(jobs[i][1]);
        int take = jobs[i][2] + solve(next);

        return dp[i] = Math.max(skip, take);
    }

    private int findNext(int endTime) {
        int left = 0, right = jobs.length - 1;
        int ans = jobs.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (jobs[mid][0] >= endTime) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}