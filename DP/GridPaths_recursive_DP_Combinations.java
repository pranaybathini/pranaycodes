//https://leetcode.com/problems/unique-paths/
//O(m*n)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        return countPaths(0,0,m,n,grid);
    }
    
    public int countPaths(int i, int j, int m, int n, int[][] grid){
        if(i == m-1 && j == n-1) return 1;
        if(i > m-1 || j > n-1) return 0;
        if(grid[i][j]!=0){
            return grid[i][j];
        }
        return grid[i][j] = countPaths(i+1, j , m, n, grid) +countPaths(i, j+1, m ,n, grid);
    }
}


//O(m) solution
class Solution {
    public int uniquePaths(int m, int n) {
        int N = m+n-2;
        int r = m-1;
        double res = 1;
        for(int i=1;i<=r;i++){
            res = res * (N-r+i)/i;
        }
        return (int)res;
    }
    
}

