class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ans =1;
        if(!wordList.contains(endWord)) 
            return 0;
        
        Map<String, Boolean> visited = new HashMap<>();
        
        for(int i =0;i<wordList.size(); i++){
            visited.put(wordList.get(i), false);
        }
        
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        visited.put(beginWord, true);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i =0; i<size; i++){
                String word = q.poll();
                if(word.equals(endWord))
                    return ans;
                match(word, visited, q);
            }
            ans++;
        }
        
        return 0;
    }
    
    public void match(String word, Map<String, Boolean> visited, Queue<String> q){
        for(int i =0; i< word.length(); i++){
            char[] temp = word.toCharArray();
            
            for(int j =0; j<26; j++){
                char c = (char)('a'+j);
                temp[i]= c;
                String s = String.valueOf(temp);
                
                if(visited.containsKey(s) && visited.get(s) == false){
                    q.add(s);
                    visited.put(s,true);
                }
            }
        }
    }
}