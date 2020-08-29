class Solution {
    public boolean reorderedPowerOf2(int N) {
        char[] a1 = String.valueOf(N).toCharArray();
        Arrays.sort(a1);
        String s1 = new String(a1);
        
        for (int i = 0; i < 31; i++) {
            //  s2 =   { 1 , 2, 4, 8 , 16, 32, ..... . 1024, 2048, ..... }
            // And we are comparing it with the number n = 76 converted to , "67" after sorting and we are comparing just the sorted values.
            char[] a2 = String.valueOf((int)(1 << i)).toCharArray();
            Arrays.sort(a2);
            String s2 = new String(a2);
            if(s2.length()> s1.length())
                break;
            
            if (s1.equals(s2)) return true;
        }
        
        return false;
    }
}