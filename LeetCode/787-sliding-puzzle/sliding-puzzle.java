class Solution {
   public int slidingPuzzle(int[][] board) {
        
    Set<String> visited = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            sb.append(String.valueOf(board[i][j]));
        }
    }
    Set<String> begin = new HashSet<>();
    Set<String> end = new HashSet<>();
    begin.add(sb.toString());
    end.add("123450");
    int count = 0;
    int[] dir = {1, -1, 3, -3};
    
    while (begin.size() > 0) {
        if (begin.size() > end.size()) {
            Set<String> temp = new HashSet<>(begin);
            begin = end;
            end = temp;
        }
        Set<String> set = new HashSet<>();
        for (String s : begin) {
            if (end.contains(s))
                return count;
            int i = s.indexOf('0');
            
            for (int d : dir) {
                char[] ch = s.toCharArray();
                int j = i + d;
                if (j >= ch.length || j < 0 || (i == 2 && j == 3) || (i == 3 && j == 2))
                    continue;
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                String newBoard = new String(ch);
                if (end.contains(newBoard))
                    return count + 1;
                if (visited.add(newBoard))
                    set.add(newBoard);
            }
        }
        count++;
        begin = set;
    }
    
    return -1;
   }
}