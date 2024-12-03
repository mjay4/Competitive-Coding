class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int numTrees(int n) {
        if(n==0)
            return 1;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(map.containsKey(n))
            return map.get(n);
        int result =0;
        for(int i=1;i<=n;i++){
            int left = numTrees(i-1);
            int right = numTrees(n-i);
            result+= (left*right);
        }
        map.put(n,result);
        
        return result;
    }
}