class Solution {
  //https://leetcode.com/problems/product-of-array-except-self/
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] ans = new int[size];
        int total = 1;
        int zero = 0;
        for(int i=0;i<size;i++){
                if(nums[i]!=0){
                    total *= nums[i];
                }else{
                    zero++;
                }
             
        }
        
        if(zero==0){
            for(int i=0;i<size;i++){
                ans[i] = total/nums[i];
            }
        }else if(zero == 1){
             for(int i=0;i<size;i++){
                if(nums[i]==0){
                    ans[i] = total;
                }
            }
        }
        
        
        return ans;
    }
  
   public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] ans = new int[size];
        
        ans[0] = 1;
        for(int i=1;i<size;i++){
            ans[i] = ans[i-1]*nums[i-1];
        }
        
        int right = 1;
        for(int i=size-1;i>=0;i--){
            ans[i] = ans[i]*right;
            right  = right*nums[i];
        }
        
        
        return ans;
    }
}
