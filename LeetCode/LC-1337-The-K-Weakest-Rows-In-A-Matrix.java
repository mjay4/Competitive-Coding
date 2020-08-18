class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i =0;i<mat.length;i++){
            int count =0;
            for(int j = 0;j<mat[0].length; j++){
                if(mat[i][j] == 1)
                    count++;
            }
            map.put(i,count);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> (a.getValue() == b.getValue() ? a.getKey() - b.getKey() : a.getValue() - b.getValue()));
        pq.addAll(map.entrySet());
        
        int ans[] = new int[k];
        for(int i =0;i<k;i++){
            ans[i] = mp.getKey();
        }
        return ans;
    }
}