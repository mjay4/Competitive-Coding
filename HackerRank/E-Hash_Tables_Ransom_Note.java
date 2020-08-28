import java.util.*;

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public Solution(String magazine, String note) {
        this.noteMap = new HashMap<String, Integer>();
        this.magazineMap = new HashMap<String, Integer>();
        
        // Must use an object instead of a primitive because it may be assigned a null reference.
        Integer occurrences;
        
        for(String s : magazine.split("[^a-zA-Z]+")) {
            occurrences = magazineMap.get(s);
            
            if(occurrences == null) {
                magazineMap.put(s, 1);
            }
            else {
                magazineMap.put(s, occurrences + 1);
            }
        }
        
        for(String s : note.split("[^a-zA-Z]+")) {
            occurrences = noteMap.get(s);
            
            if(occurrences == null) {
                noteMap.put(s, 1);
            }
            else {
                noteMap.put(s, occurrences + 1);
            }
        }
        
    }
    
    public void solve() {
        boolean canReplicate = true;
        for(String s : noteMap.keySet()) {
            if(!magazineMap.containsKey(s) || (magazineMap.get(s) < noteMap.get(s)) ) {
                canReplicate = false;
                break;
            }
        }
        
        System.out.println( (canReplicate) ? "Yes" : "No" );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        s.solve();
    }
}
