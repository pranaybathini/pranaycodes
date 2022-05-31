//Brute force = dfs- tle
//https://leetcode.com/problems/making-a-large-island
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

//accepted - O(n^2)
class Solution {
    
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,1,-1};
    
    public int largestIsland(int[][] grid) {
        
        int row = grid.length, col = grid[0].length;
        Map<Integer, Integer> areaMap = new HashMap<>();
        int currIndex = 3, maxArea = 0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    areaMap.put(currIndex, dfs(i,j,grid,row,col,currIndex));
                    maxArea = Math.max(maxArea, areaMap.get(currIndex++));   
                }
            }
        }
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 0){
                    Set<Integer> indexSet = new HashSet<>();
                    int area = 1;
                    for(int k=0;k<4;k++){
                        int x = i+dr[k];
                        int y = j+dc[k];
                        if(isValid(x,y,grid,row,col)){
                            int index = grid[x][y];
                            if(index > 2 && !indexSet.contains(index)){
                                area += areaMap.get(index);
                                indexSet.add(index);
                            }   
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        
        return maxArea;
    }
    
    public int dfs(int x, int y, int[][] grid, int row, int col, int index){
        int area = 0;
        grid[x][y] = index;
        for(int k=0;k<4;k++){
            int i = x+dr[k];
            int j = y+dc[k];
            if(isValid(i,j,grid,row,col)&& grid[i][j]==1){
                 area += dfs(i,j,grid,row,col,index);
            } 
        }
        return 1 + area;
    }
    
    public boolean isValid(int x, int y, int[][] grid,int row, int col){
        if(x < 0 || x >= row || y < 0 || y >= col ){
            return false;
        }
        return true;
    }
}



