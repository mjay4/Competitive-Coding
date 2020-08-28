class Solution {
    public int minSwaps(int[][] grid) {
        int zero = 0;
        int n = grid.length;
        int val[] = new int[n];
        
        for(int i =0 ; i<n; i++){
            zero = 0;
            for(int j = n-1;j>=0;j--){
                if(grid[i][j]==0)
                    zero++;
                else{
                    val[i] = zero;
                    break;
                }
            }
            if(val[i]==0 && zero!=0)
                val[i] = zero;
        }

        return min(val);
    }
   
    int min(int a[]) {
        int n = a.length;
        int ans = 0;
        for (int i=0; i<n; i++) {
            if (a[i] < (n-i-1)) {
                int j=i;
                while (j < n && a[j] < (n-i-1)) {
                    j++;
                }
				
                if (j == n) {     // Did not find any number greater than or equal to n-i-1.
                    return -1;  // so its impossible to get the answer.
                }
                while (j>i) {
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                    ans++;
                    j--;
                }
            }
        }
        return ans;
    }
}