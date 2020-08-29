class Solution {
    public List<List<Integer>> groupThePeople(int[] g) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<g.length;i++){
            List<Integer> temp = new ArrayList<>();
            if(map.containsKey(g[i]))
                temp = map.get(g[i]);
            
            temp.add(i);
            map.put(g[i], temp);
        }
        
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            int key = entry.getKey();
            List<Integer> val = entry.getValue();
            int size = val.size()/key;
            for(int i =0;i<size;i++){
                List<Integer> res = new ArrayList<>();
                for(int j = 0;j<key;j++){
                    res.add(val.remove(0));     
                }
                ans.add(res);
            }
        }
        return ans;
    }
}