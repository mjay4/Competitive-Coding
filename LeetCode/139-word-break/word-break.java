class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String str :wordDict){
            set.add(str);
        }
        return check(s,set,0,new HashMap<Integer, Boolean>());
    }
    public boolean check(String s, HashSet<String> set, int pos , HashMap<Integer, Boolean> cache){

        // Reached the end of String.
        if(pos>=s.length())
            return true;

        // That index value is already updated in Cache. 
        if(cache.containsKey(pos))
            return cache.get(pos);
        
        StringBuilder curr = new StringBuilder();
        boolean isAvailable = false;
        for(int len = pos; len<s.length();len++){
            curr.append(s.charAt(len));
           if(set.contains(curr.toString())){
                // Check the availability of the remaining string. 
                isAvailable = check(s,set,len+1,cache);
                if(isAvailable) {
                    break;
                }
           }     
        }
        cache.put(pos,isAvailable);
        return isAvailable;
    }
}