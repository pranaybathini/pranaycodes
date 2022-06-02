//https://leetcode.com/problems/house-robber-ii/
class Solution {
    public int rob(int[] nums) {
        if(nums.length ==1) return nums[0];
        return Math.max(rb(nums,0,nums.length-1),rb(nums,1,nums.length));
    }
    
    public int rb(int[] nums, int index, int length){
        int prev1 =0 , prev2 =0, curr = 0;
        for(int i=index;i<length;i++){
            int notPick = 0 + prev1;
            int pick = nums[i] + prev2;
            curr = Math.max(pick,notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}
