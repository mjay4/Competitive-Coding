class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int len = mat.length;
        int low = 0;
        int high = len-1;

        while (low<=high) {
            int mid = low + ((high-low)/2);
            int max = mat[mid][0];
            int maxIdx = 0;
            for (int i=1; i<mat[0].length; i++) {
                if (mat[mid][i] > max) {
                    max = mat[mid][i];
                    maxIdx = i;
                }
            }
            int left = mid==0 ? -1 : mat[mid-1][maxIdx];
            int right = mid==len-1 ? -1 : mat[mid+1][maxIdx];
            if (mat[mid][maxIdx] > left && mat[mid][maxIdx] > right) {
                int ar[] = new int[2];
                ar[0] = mid;
                ar[1] = maxIdx;
                return ar;
            } else if(left > mat[mid][maxIdx]) high = mid-1;
            else low = mid+1;
        }
        return new int[2];
    }
}