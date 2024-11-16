class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int maxSum = 0;
        int runningSum = 0;
        int ans = 0;

        for (int i=0; i<minutes; i++) {
            if (grumpy[i] == 0) {
                ans+=customers[i];
                customers[i] = 0;
            } else {
                runningSum += customers[i];
            }
        }

        maxSum = runningSum;

        for (int i=minutes; i<n; i++) {
            int idx = i-minutes;
 
            if (grumpy[i] == 0) {
                ans+=customers[i];
                customers[i] = 0; 
            } 
            runningSum += customers[i]-customers[idx];
            maxSum = Math.max(maxSum,runningSum);
        }
        return ans+maxSum;
    }
}