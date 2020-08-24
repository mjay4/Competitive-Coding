class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int ans[] = new int[queries.length];
        
        for(int i =1;i<arr.length;i++){
            arr[i] = arr[i]^arr[i-1];
        }
        for(int i =0 ; i<queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = arr[r]^(l==0 ? 0 : arr[l-1]);
        }
        return ans;
    }
}