class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int idx = -1;
        int end = 1_000_000;
        while(start<end){
            int mid = start + (end-start)/2;
            int ans = 0;
            for(int i : nums){
                ans+= (int) Math.ceil(i*1.0f/mid);
            }
            if(ans<=threshold){
                idx = mid;
                end = mid;
            }else{
                start=mid+1;
            }
        }
        return idx==-1? start : idx;
    }
}