class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int i = 0, j = 0; 
        int len1 = nums1.length;
        int len2 = nums2.length;
        long mod = 1_000_000_007;
        long ans = 0, sum1 = 0, sum2 = 0; 
        while (i < len1 && j < len2){
            if (nums1[i] < nums2[j]) 
                sum1 += nums1[i++]; 
            
            else if (nums1[i] > nums2[j]) 
                sum2 += nums2[j++]; 
            
            else{
              
                ans += Math.max(sum1, sum2); 
                ans%=mod;
                sum1 = 0; 
                sum2 = 0; 
                while (i < len1 && j < len2 && nums1[i] == nums2[j]){
                    ans+= nums1[i++]; 
                    j++; 
                } 
            } 
        } 
        while (i < len1) 
            sum1 += nums1[i++]; 
        while (j < len2)  
            sum2 += nums2[j++]; 
        ans += Math.max(sum1, sum2); 
        ans = ans%mod;
        return (int) ans; 
    }
}