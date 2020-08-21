class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = 0;
        while(j<A.length){
            if((A[j]&1)== 0){
                int temp = A[i];
                A[i++] = A[j];
                A[j] = temp;
            }
            j++;
        }
        return A;
    }
}