class Solution {
    public boolean canSortArray(int[] nums) {
        int maxTillNow = 0, particianMin=0, particianMax =0;

        int particianCount = 0;
        for (int num : nums) {
            int currentCount = (int)Integer.bitCount(num);

            if (particianCount == currentCount) {
                particianMax = Math.max(particianMax, num);
                particianMin = Math.min(particianMin, num);
            } else if (particianMin < maxTillNow) {
                return false;
            } else {
                maxTillNow = particianMax;
                particianMax = particianMin = num;
                particianCount = currentCount;
            }
        }
        return particianMin >= maxTillNow;
    }
}