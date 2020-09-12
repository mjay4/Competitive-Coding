class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(k, n, ans, new ArrayList<Integer>(), 1);
        return ans;
    }

    public void generate(int k, int target, List<List<Integer>> ans, List<Integer> cur, int start) {
        if (target == 0 && k == 0) {
            ans.add(new ArrayList(cur));
            return;
        }
        if (k < 0 || target < 0)
            return;
        for (int i = start; i <= 9; i++) {
            cur.add(i);
            generate(k - 1, target - i, ans, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}