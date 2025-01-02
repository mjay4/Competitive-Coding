class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int prefixSum[] = new int[words.length+1];
        int size = queries.length;
        int ans[] = new int[size];

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i =0; i<words.length; i++) {
            prefixSum[i + 1] = prefixSum[i];
            if (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1))) {
                prefixSum[i + 1]++;
            }
        }

        for (int i =0; i<size; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = prefixSum[r+1]-prefixSum[l];
        }

        return ans;
    }
}