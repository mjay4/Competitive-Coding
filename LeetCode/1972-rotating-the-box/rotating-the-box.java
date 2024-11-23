class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char ans[][] = new char[n][m];

        for(int i = 0; i<m; ++i){
            int empty = n-1;
            for(int j = n-1; j>=0; --j){
                if(box[i][j] == '*'){
                    empty = j-1;
                }
                if(box[i][j] == '#'){
                    box[i][j] = '.';
                    box[i][empty] = '#';
                    --empty;
                }
            }
        }
        
        for(int i = 0; i<m; ++i){
            for(int j = n-1; j>=0; --j)
                ans[j][m-i-1] = box[i][j];
        }
        return ans;
    }
}