class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        int[][] dp = new int[n][3];

        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        for (int[] a: dp) {
            Arrays.fill(a,-1);
        }
        return findMax(events, 0, 0, dp);
    }

    int findMax(int[][] events, int idx, int cnt, int[][] dp) {
        if (cnt == 2 || idx >= events.length)
            return 0;
        if (dp[idx][cnt] == -1) {
            int end = events[idx][1];
            int lo = idx + 1, hi = events.length - 1;
            while (lo < hi) {
                int mid = lo + ((hi - lo)>>1);
                if (events[mid][0] > end)
                    hi = mid;
                else
                    lo = mid + 1;
            }
            int include = events[idx][2] + (lo < events.length && events[lo][0] > end ? findMax(events, lo, cnt + 1, dp) : 0);
            int exclude = findMax(events, idx + 1, cnt, dp);
            dp[idx][cnt] = Math.max(include, exclude);
        }
        return dp[idx][cnt];
    }
}