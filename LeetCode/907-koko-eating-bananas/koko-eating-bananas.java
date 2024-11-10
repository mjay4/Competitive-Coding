class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        long low = 1, high = piles[piles.length-1];
        while(low <= high) {
            long mid = (low + high) /2;
            if (isValid(mid, piles, h)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return (int)low;
    }

    private boolean isValid(long k, int[] piles, int h) {
        long totalHours = 0;
        for (int i=0; i<piles.length; i++) {
            totalHours+= piles[i]/k;
            if (piles[i]%k!=0) totalHours++;
        }
        return totalHours<=h;
    }
}