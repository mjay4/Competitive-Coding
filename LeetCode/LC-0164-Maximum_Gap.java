class Solution {
    public int maximumGap(int[] nums) {
        /* Idea : We will use Bucked sort to solve this question. 
            
            We have to first define the intervals, We will use the min and max to find the total number of intervals needed.
            
            Now, we need the min and max value of each interval, so we  can compare it with the previous bucket.
            
            In the end we will traverse from the min to the max and then check the elements in each buckets.
            
            To assign a bucket to each element, we will use : nums[i] - min / no_of_intervals.
            
            no_of_intervals = Math.ceil((max-min)/ nums.length-1).
            
            And finally we will use the max element to check if  difference between the final element and the final bucket is the answer.
        */
        int ans =0;
        int size = nums.length;
        // Base Case :
        if(size < 2)
            return 0;
        
        int min = nums[0],max=nums[0];
        
        for(int i : nums){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        
        int interval = (int)Math.ceil((max-min+0.0f)/(size-1));
        
        int[] minOfBucket = new int[size-1];
        int[] maxOfBucket = new int[size-1];
        
        Arrays.fill(minOfBucket, Integer.MAX_VALUE);
        Arrays.fill(maxOfBucket, -1);
        
        //Set the min and max of bucket.
        for(int i =0;i<size; i++){
            if(nums[i]== min || nums[i]==max)
                continue;
            
            int idx = (nums[i] - min)/interval;
            minOfBucket[idx] = Math.min(minOfBucket[idx], nums[i]);
            maxOfBucket[idx] = Math.max(maxOfBucket[idx], nums[i]);
        }
        
        
        // Now we will use min to see the maximum of previous bucket.
        for(int i =0;i<size-1;i++){
            if(maxOfBucket[i]==-1)
                continue;
            ans = Math.max(minOfBucket[i] - min, ans);
            min = maxOfBucket[i];
        }
        
        ans = Math.max(ans, max-min);
        return ans;
    }
}