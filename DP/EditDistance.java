//https://leetcode.com/problems/edit-distance/

//Recusive Solution - Exponential TC - O(3^m)
// Will get TLE

class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        return func(m-1,n-1,s1,s2);
    }
    
    int func(int i, int j, String s1, String s2){
        if(i<0) return j+1;
        if(j<0) return i+1;
        
        if(s1.charAt(i) == s2.charAt(j)) return func(i-1,j-1,s1,s2);
        else{
            return 1+ Math.min(func(i-1,j,s1,s2),
                              Math.min(func(i-1,j-1,s1,s2), func(i,j-1,s1,s2)));
        }
    }
    
}

//Apply memoization TC- O(m*n) SC- O(m*n) for dp array + O(m) for recursive stack
// can remove extra recursive stack by tabulation (Bottom up approach)

class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return func(m-1,n-1,s1,s2,dp);
    }
    
    int func(int i, int j, String s1, String s2,int dp[][]){
        if(i<0) return j+1;
        if(j<0) return i+1;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j]= func(i-1,j-1,s1,s2,dp);
        else{
            return dp[i][j] = 1+ Math.min(func(i-1,j,s1,s2,dp),
                              Math.min(func(i-1,j-1,s1,s2,dp), func(i,j-1,s1,s2,dp)));
        }
    }
    
}


//TO Avoid our base cases going to -1 state, we can convert our memoization to 1 based indexing

class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return func(m,n,s1,s2,dp);
    }
    
    int func(int i, int j, String s1, String s2,int dp[][]){
        if(i == 0) return j;
        if(j == 0) return i;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        if(s1.charAt(i-1) == s2.charAt(j-1)) return dp[i][j]= func(i-1,j-1,s1,s2,dp);
        else{
            return dp[i][j] = 1+ Math.min(func(i-1,j,s1,s2,dp),
                              Math.min(func(i-1,j-1,s1,s2,dp), func(i,j-1,s1,s2,dp)));
        }
    }
    
}

//Tabulation - remove extra recursive stack space

class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];
        
        // Step 1 : In Tabulation, first let us convert the base cases
        
        // Base Case 1 -  if(i == 0) return j;
        for(int j=0; j<=n; j++) dp[0][j] = j;
        
        // Base Case 2 -  if(j == 0) return i;
        for(int i=0; i<=m; i++) dp[i][0] = i;
        
        // Step 2: Params range
        for(int i=1; i<=m ; i++){
            for(int j=1; j<=n; j++){
                
                // step 3: Copy the recurrence
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j]= dp[i-1][j-1];
                else{
                    dp[i][j] = 1+ Math.min(dp[i-1][j],
                                      Math.min(dp[i-1][j-1], dp[i][j-1]));
                }
            }
        }
        return dp[m][n];
    }
    
}

// to 1-d Array
class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int prev[] = new int[n+1];
        int curr[] = new int[n+1];
        
        for(int j=0; j<=n; j++) prev[j] = j;
        
        for(int i=1; i<=m ; i++){
            curr = new int[n+1];
            curr[0] = i;
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) 
                    curr[j]= prev[j-1];
                else{
                    curr[j] = 1+ Math.min(prev[j],
                                      Math.min(curr[j-1], prev[j-1]));
                }
            }
             prev = curr;
        }  
        return prev[n];
    }
}

