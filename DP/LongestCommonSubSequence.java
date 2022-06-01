//https://leetcode.com/problems/longest-common-subsequence/
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        return lcs3(s1,s2,n,m,dp);
    }
    
    public int lcs(String s1, String s2, int n, int m,int[][] dp){
        if(n==0 || m==0) return 0;
        
        if(dp[n][m]!=-1) return dp[n][m];
        
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return dp[n][m]= (1+lcs(s1,s2,n-1,m-1,dp));
        }
        return dp[n][m]=Math.max(lcs(s1,s2,n-1,m,dp),lcs(s1,s2,n,m-1,dp));
    }
    
        
    public int lcs2(String s1, String s2, int n, int m,int[][] dp){
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        
        for(int j=0;j<=m;j++){
            dp[0][j]=0;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        
        return dp[n][m];
    }
    
     public int lcs3(String s1, String s2, int n, int m,int[][] dp){
        int[] prev = new int[m+1];
         int[] curr = new int[m+1];
         
       
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }else{
                    curr[j] = Math.max(curr[j-1], prev[j]);
                }
            }
            prev = curr.clone();
        }
        
        return prev[m];
    }
    
    
}
