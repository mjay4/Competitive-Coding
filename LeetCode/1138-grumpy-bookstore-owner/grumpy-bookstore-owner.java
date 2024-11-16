class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int runningSum = 0;
        int ans = 0;

        for (int i=0; i<minutes; i++) {
            if (grumpy[i] == 0) {
                // If Not Grumpy, then customer is satisfied by default. 
                ans+=customers[i];
                customers[i] = 0;
            } else {
                // Running sum for the first m minutes. 
                runningSum += customers[i];
            }
        }

        int maxSum = runningSum;

        for (int i=minutes; i<n; i++) {
            int idx = i-minutes;
            if (grumpy[i] == 0) {
                ans+=customers[i];
                customers[i] = 0; 
            } 
            // Running sum for the window. (When grumpy = 1)
            runningSum += customers[i]-customers[idx];
            maxSum = Math.max(maxSum,runningSum);
        }
        return ans+maxSum;
    }
}