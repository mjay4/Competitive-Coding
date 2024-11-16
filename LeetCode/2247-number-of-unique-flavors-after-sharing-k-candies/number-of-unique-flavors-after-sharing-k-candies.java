class Solution {
    public int shareCandies(int[] candies, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int candy : candies) freq.put(candy, freq.getOrDefault(candy, 0) + 1);
        int ans = 0;

        for (int i =0; i<candies.length; i++) {
            int candy = candies[i];
            freq.put(candy, freq.get(candy)-1);
            if (freq.get(candy) == 0) freq.remove(candy);
            if (i>=k) freq.put(candies[i-k], freq.getOrDefault(candies[i-k], 0)+1);
            if (i>=k-1) ans = Math.max(ans, freq.size());
        }

        return ans;
    }
}