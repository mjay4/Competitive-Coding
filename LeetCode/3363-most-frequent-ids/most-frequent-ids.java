class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>((a, b) -> Long.compare(b.getKey(), a.getKey()));
        int len = nums.length;
        long[] ans = new long[len];
        Map<Integer, Long> idFreq = new HashMap<>();

        for (int i =0; i<len; i++) {
            idFreq.put(nums[i], idFreq.getOrDefault(nums[i], 0L) + freq[i]);

            // Adding the freq and ID mapping in the PriorityQueue.
            pq.add(new Pair<>(idFreq.get(nums[i]), nums[i]));

            // Check the pq's Top element and confirm if its frequency has changed by checking the map.

            while (idFreq.get(pq.peek().getValue()) != pq.peek().getKey()) {
                pq.poll();
                // Since this PQ can never be more then N. The time complexity can never go above N+N. (1 pop and 1 add)
            }

            ans[i] = pq.peek().getKey();
        }

        return ans;
    }
}