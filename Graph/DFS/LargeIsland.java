//Brute force = dfs- tle
class Solution {
    public int largestIsland(int[][] grid) {
        int max = 0;
        int row = grid.length;
        int col = grid[0].length;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 0){
                    boolean[][] vis = new boolean[row][col];
                    grid[i][j] = 1;
                    max = Math.max(max, dfs(i,j,row,col,grid,vis));
                    grid[i][j] = 0;
                }
            }
        }
        return max!=0 ? max: row*col ;
    }
    
    int dfs(int i, int j, int row, int col, int[][] grid,boolean[][] vis ){
        if(i<0 || i>=row || j<0 || j>=col || vis[i][j] ==true || grid[i][j]==0 ){
            return 0;
        }
        vis[i][j]=true;
        int a = dfs(i-1,j,row,col,grid,vis);   
        int d = dfs(i,j-1,row,col,grid,vis);
         int c = dfs(i+1,j,row,col,grid,vis);
         int b = dfs(i,j+1,row,col,grid,vis);
    
        return 1 + a +b+c+d;
    }
}
