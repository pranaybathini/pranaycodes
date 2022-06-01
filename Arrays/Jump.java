//https://leetcode.com/problems/jump-game/
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length,max=0;
        for(int i=0;i<n;i++){
            if(max<i)return false;
            if(max>=n-1)return true;
            max = Math.max(max,i+nums[i]);
        }
        return true;
    }
}
