class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int size = nums.length*2 -1;
        int ar[] = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i =size;i>=0;i--){
            while(!stack.empty() && nums[stack.peek()] <= nums[i%nums.length]){
                stack.pop();
            }
            ar[i%nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i%nums.length);
        }
        
        return ar;
    }
}