class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        generate(0, ans, new ArrayList<>(), nums);
        return ans;   
    }

    private void generate(int idx, List<List<Integer>> ans, List<Integer> temp, int[] nums) {
        ans.add(new ArrayList<>(temp));
        for (int i = idx; i<nums.length; i++) {
            temp.add(nums[i]);
            generate(i+1, ans, temp, nums);
            while (i<nums.length-1 && nums[i]==nums[i+1]) i++;
            temp.remove(temp.size()-1);
        }
    }
}