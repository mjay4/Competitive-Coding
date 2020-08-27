class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> ans = new ArrayList<>();   
        int l = rounds[0];
        int r = rounds[rounds.length-1] < l ? n + rounds[rounds.length-1] : rounds[rounds.length-1] ;
        for(int i = l;i<=r;i++){
            if(i%n==0)
                ans.add(n);
            else
                ans.add(i%n);
        }
        Collections.sort(ans);
        return ans;
    }
}