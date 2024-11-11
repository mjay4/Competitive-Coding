class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(nums,ans,new boolean[nums.length], new ArrayList<Integer>());
        return ans;
    }
    
    public void generate(int[] nums, List<List<Integer>> ans, boolean[] visited, List<Integer> cur){
        if(cur.size()==nums.length){
            ans.add(new ArrayList<>(cur));
            return;   
        }
        for(int i = 0;i<nums.length;i++){
            if(visited[i])
                continue;
            cur.add(nums[i]);
            visited[i] = true;
            generate(nums,ans,visited,cur);
            cur.remove(cur.size()-1);
            visited[i]=false;
        }
    }
}