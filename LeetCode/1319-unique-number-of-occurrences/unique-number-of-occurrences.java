class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map <Integer, Integer> occurrence = new HashMap<>();
        for (int val: arr) {
            occurrence.put(val, occurrence.getOrDefault(val, 0) + 1);
        }
        int[] count = new int[1001];
        for (Map.Entry<Integer,Integer> entrySet : occurrence.entrySet()) {
            Integer val = entrySet.getValue();
            if (count[val]++>0) return false;
        }

        return true;
    }
}