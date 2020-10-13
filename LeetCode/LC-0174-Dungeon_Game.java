class Solution {
    int cache[][];
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        cache = new int[m][n];
        for(int i =0; i<m; i++){
            Arrays.fill(cache[i], -1);
        }
        if(dungeon == null || n == 0 || m == 0)
            return 0;
        return find(dungeon,m,n,0,0);
    }
    
    public int find(int[][] ar, int m, int n, int i, int j){
        if( i>=m || j>=n)
            return Integer.MAX_VALUE;
        if(cache[i][j] != -1)
            return cache[i][j];
        int health = Math.min(find(ar,m,n,i+1,j),find(ar,m,n,i,j+1));
        
        if(health == Integer.MAX_VALUE)
            health = 1;
        
        if(health - ar[i][j] > 0)
            return cache[i][j] = health-ar[i][j];
        return cache[i][j] = 1;
    }
}