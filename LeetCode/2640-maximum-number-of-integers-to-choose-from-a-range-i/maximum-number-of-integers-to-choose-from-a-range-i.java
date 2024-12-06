class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int ans =0;

        Set<Integer> ban = new HashSet<>();
        for (int i: banned) {
            ban.add(i);
        }

        long sum =0;
        for(int i=1;i<=n;i++) {
            if (!ban.contains(i)) {
                sum+=i;
                if (sum>maxSum) break;
                ans++;
            }
        }
        return ans;
    }
}