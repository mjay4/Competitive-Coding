class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 0, right = position[position.length-1];
        int ans = -1;
        while (left<right) {
            int mid = left + (right-left)/2;
            if (isValid(position, m, mid)) {
                ans = mid;
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return ans;
    }

    public boolean isValid(int[] position, int m, int diff) {
        int count = 1;
        int last = position[0];
        for (int i =1; i<position.length; i++) {
            if (position[i]-last >= diff) {
                count++;
                last = position[i];
            }
        }
        return count>= m;
    }
}