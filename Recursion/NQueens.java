class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        dfs(0,res,board);
        return res;
    }
    
    static void dfs(int col, List<List<String>> res, char[][] board){
        if(col == board.length){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                String s = new String(board[i]);
                temp.add(s);
            }
            res.add(temp);
            return;
        }
        
        for(int row=0;row<board.length;row++){
            if(isValid(board, row,col)){
                board[row][col] = 'Q';
                dfs(col+1,res,board);
                board[row][col] = '.';
            }
        }
    }
    
    static boolean isValid(char[][] board, int row, int col){
        int dupRow = row;
        int dupCol = col;
        
        // diagonal upper left
        while(row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            row--;col--;
        }
        
        row = dupRow;
        col = dupCol;
        
        //row check
        
        while(col>=0){
            if(board[row][col]=='Q') return false;
            col--;
        }
        
         row = dupRow;
         col = dupCol;
        
        //diagonal lower left
        
        while(col>=0 && row<board.length){
            if(board[row][col]=='Q')return false;
            col--;row++;
        }
        
        return true;
        
    }
}
