class Solution {

    List<String> res = new LinkedList();
    Map<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for(List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue()).add(ticket.get(1));
        }
        
        // We always start from JFK. 
        dfs("JFK");
        return res;
    }
    
    private void dfs(String curr) {
        while (map.containsKey(curr) && ! map.get(curr).isEmpty()) {
            dfs(map.get(curr).poll());
        }
        
        res.add(0, curr);
    }
}