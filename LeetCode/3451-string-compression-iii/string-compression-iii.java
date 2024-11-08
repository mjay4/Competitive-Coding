class Solution {
    public String compressedString(String word) {
        int val = 1;
        char prev = word.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i =1;i<word.length(); i++) {
            char curr = word.charAt(i);
            if (curr == prev && val < 9) { 
                val++;
            } else if (curr == prev){  
                sb.append(val);
                sb.append(prev);
                val=1;
            } else {
                sb.append(val);
                sb.append(prev);
                prev = curr;
                val = 1;
            }
        }
        sb.append(val);
        sb.append(prev);
        return sb.toString();
    }
}