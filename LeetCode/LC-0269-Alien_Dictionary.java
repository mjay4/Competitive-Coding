class Solution {
   public String alienOrder(String[] words) {
       
        Map<Character, Set<Character>> vertex = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < words.length ; i++) {
           for(char c: words[i].toCharArray()){
               indegree.put(c,0);
           }
        }
       
        for(int i = 1 ; i < words.length ; i++) {
            String cur = words[i-1];
            String next = words[i];
            // Check that word2 is not a prefix of word1.
            if (cur.length() > next.length() && cur.startsWith(next)) {
                return "";
            }
            int length = Math.min(cur.length(), next.length());
            
            for(int j = 0 ; j < length ; j++) {
                char a1 = cur.charAt(j);
                char a2 = next.charAt(j);
                Integer indegree2 = indegree.get(a2);
                if (a1 != a2) {
                    Set<Character> set=new HashSet<>();
                    if(vertex.containsKey(a1)) set=vertex.get(a1);
                    if (!set.contains(a2)) {
                        set.add(a2);
                        indegree.put(a2, (indegree2 == null ? 0 : indegree2) + 1);
                        vertex.put(a1, set);
                    }
                    break;
                }
            }
        }
       
        LinkedList<Character> queue = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
       
       
        while (!queue.isEmpty()) {
            char elem = queue.poll();
            sb.append(elem);
            if (vertex.containsKey(elem)) {
                for(char c : vertex.get(elem)) {
                    int tmp = indegree.get(c) - 1;
                    indegree.put(c, tmp);
                    if (tmp == 0) {
                        queue.offer(c);
                    }
                }
            }
        }
       
        if(sb.length() < indegree.size()) return "";
        return sb.toString();
    }
}