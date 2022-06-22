//https://leetcode.com/problems/minimum-path-sum/

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return min(grid,0,0,dp);
        
    }
    
    int min(int[][] grid, int i, int j, int[][] dp){
        if(i == grid.length-1 && j == grid[0].length-1){
            return dp[i][j]=grid[i][j];
        }
        
        if(i < 0 || j <0 || i > grid.length-1 || j>grid[0].length-1) return Integer.MAX_VALUE;
                if(dp[i][j]!=-1) return dp[i][j];

        int bottom = min(grid, i+1,j,dp);
        int right = min(grid,i,j+1,dp);
        return dp[i][j]=grid[i][j] +Math.min(bottom,right);
    }
}
