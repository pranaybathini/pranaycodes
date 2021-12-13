class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int low = 0, high = m*n - 1;
        while(low <= high){
            int mid = (low+high)/2;
            if(matrix[mid/n][mid%n] == target){
                return true;
            }
            if(matrix[mid/n][mid%n] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return false;
    }
}
