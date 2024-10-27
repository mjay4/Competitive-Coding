class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] countTops = new int[7], countBottoms = new int[7], same = new int[7];
        int n = tops.length;
        for (int i = 0; i < n; ++i) {
            countTops[tops[i]]++;
            countBottoms[bottoms[i]]++;
            if (tops[i] == bottoms[i])
                same[tops[i]]++;
        }
        for (int i  = 1; i < 7; ++i)
            if (countTops[i] + countBottoms[i] - same[i] == n)
                return n - Math.max(countTops[i], countBottoms[i]);
        return -1;
    }
}