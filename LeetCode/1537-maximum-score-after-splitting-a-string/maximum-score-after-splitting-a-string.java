class Solution {
    public int maxScore(String s) {
        int len = s.length();
        int zeroCountArr[] = new int[len];
        int zeroCount = 0;
        int oneCountArr[] = new int[len];
        int oneCount = 0;
        for (int i =0, j=len-1; i<len; i++, j--) {
            if (s.charAt(i)-'0' == 0) {
                //System.out.println ("Idhar" + s.charAt(i));
                zeroCount++;
            } 
            if (s.charAt(j)-'1' == 0) {
                //System.out.println ("Idhar j" + s.charAt(j));
                oneCount++;
            } 
            zeroCountArr[i] = zeroCount;
            oneCountArr[j] = oneCount;
        }
        int ans = 0;
        for (int i=0; i< len; i++) {
            if (i == 0 && s.charAt(i)-'1' == 0) oneCountArr[i]--;
            if (i == len-1 && s.charAt(i)-'0' == 0) zeroCountArr[i]--;
            ans = Math.max(ans, zeroCountArr[i]+oneCountArr[i]);
        }
        return ans;
    }
}