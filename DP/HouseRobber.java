//https://leetcode.com/problems/house-robber/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+2];
        return rb3(nums,nums.length+1,dp);
    }
    
    int rb(int[] nums, int n,int[] dp){
        if(n<0)return 0;
        if(dp[n]!=-1) return dp[n];
        
        int notPick = rb(nums,n-1,dp);
        int pick = nums[n]+rb(nums, n-2, dp);
        return dp[n]=Math.max(notPick, pick);
    }
    
    int rb2(int[] nums, int n, int[] dp){
        for(int i=2;i<n+1;i++){
            int notPick = dp[i-1];
            int pick = nums[i-2] + dp[i-2];
            dp[i] = Math.max(pick,notPick);
        }
        return dp[n];
    }
    
      int rb3(int[] nums, int n, int[] dp){
          int prev1 = 0, prev2 =0, curr=0;
        for(int i=2;i<n+1;i++){
            int notPick = prev1;
            int pick = nums[i-2] + prev2;
            curr = Math.max(pick,notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
    
}
