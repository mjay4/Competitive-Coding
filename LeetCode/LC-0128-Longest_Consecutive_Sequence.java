class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums)
            set.add(i);
        
        int max = 0;
        for(int i : nums){
            if(!set.contains(i-1)){
                int count = 0;
                while(set.contains(i)){
                    count++;
                    i+=1;
                }
                if(count>max){
                    max = count;
                }
            }
        }
        return max;
    }
}