class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        for(int i=0;i<nums.length;i++) lis[i]=1;
        
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j] && lis[i] < lis[j]+1){
                    lis[i] = lis[j]+1;
                }
            }
        }
        
        int mx = 0;
        for(int x : lis){
            mx  = Math.max(x,mx);
        }
        
        return mx;
    }
    
    int lis(int[] nums, int i, int len, int prev, int[] dp){
        if(i==len){
           return  0;
        }
        
        int ex = lis(nums,i+1,len,prev,dp);
        int in = 0;
        if(nums[i]>prev){
            in = 1 + lis(nums,i+1,len,nums[i],dp);
        }
        return dp[i] = Math.max(in,ex);
    }
}
