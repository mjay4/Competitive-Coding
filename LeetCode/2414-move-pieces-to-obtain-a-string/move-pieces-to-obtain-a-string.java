class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i=0,j=0;

        while(i<=n && j<=n) {
            while(i<n && target.charAt(i)=='_') i++;
            while(j<n && start.charAt(j)=='_') j++;      

            if(i==n || j==n){
                return i==n && j==n;
            }
            char t = target.charAt(i);
            char s = start.charAt(j);

            if(t!=s) return false;
            if(t=='L') {
                if(j<i) return false;
            }
            else{
                if(i<j) return false;
            }
            i++;
            j++;
        }

        return true;
    }
}