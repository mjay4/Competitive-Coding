class Solution {
    public int numSplits(String s) {
        HashSet<Character> cl = new HashSet<>();
        HashSet<Character> cr = new HashSet<>();
        int left[] = new int[s.length()];
        int right[] = new int[s.length()];
        int len = s.length();
        for(int i =0;i<len; i++){
            char c = s.charAt(i);
            cl.add(c);
            left[i] = cl.size();
        }
        for(int i =len-1;i>=0;i--){
            char c = s.charAt(i);
            cr.add(c);
            right[i] = cr.size();
        }
        
        int count = 0;
        for(int i =0;i<len-1;i++){
            //System.out.println(left[i] + " "+ right[i]);
            if(left[i]== right[i+1])
                count++;
        }
        return count;
    }
}