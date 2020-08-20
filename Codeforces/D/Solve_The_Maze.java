
import java.util.*;
import java.io.*;

public class Solve_The_Maze{
	static char[][]grid;
	static int n,m;
	public static void main (String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			grid = new char[n][m];
			
			for(int i =0;i<n;i++) {
				String s = br.readLine();
				for(int j=0;j<m;j++) {
					grid[i][j] = s.charAt(j);
				}
			}
			
			boolean can = true;
			for(int i=0; i<n; ++i) {
				for(int j =0; j<m; ++j) {
					if( grid[i][j] == 'B' ) {
						can &= (block(i-1, j) & block(i, j-1)) & (block(i+1, j) & block(i, j+1));
					}
				}
			}
			if( !can ) {
				System.out.println("No");
			} else {
				dfs(n-1, m-1);
				for( int i=0; i<n; ++i) {
					for( int j=0; j<m; ++j) {
						if( grid[i][j] == 'G') can = false;
					}
				}
				System.out.println(can?"Yes":"No");
			}
			
		}
	}

	static boolean block(int row, int col) {
		if( row < 0 || col < 0 || row >= n || col >= m)return true;
		if(grid[row][col] == '.' || grid[row][col] == '#') {
			grid[row][col] = '#';
			return true;
		}
		if(grid[row][col] == 'G') return false;
		return true;
	}
	
	static void dfs(int i, int j) {
		if(grid[i][j] == '#')return;
		grid[i][j] = 'v';
		if(i>0 && grid[i-1][j] != 'v')dfs(i-1,j);
		if(j>0 && grid[i][j-1] != 'v')dfs(i,j-1);
 
		if(i<n-1 && grid[i+1][j] != 'v')dfs(i+1,j);
		if(j<m-1 && grid[i][j+1] != 'v')dfs(i,j+1);
	}
}