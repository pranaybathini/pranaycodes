//https://leetcode.com/problems/minimum-size-subarray-sum
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        int i=0,j=0,min = Integer.MAX_VALUE;
        int sum =0;
        while(j<nums.length){
            sum+=nums[j++];
            while(sum >= target){
                min = Math.min(min,j-i);
                sum -= nums[i++];
            }
        }
        return min != Integer.MAX_VALUE ? min : 0;
    }
}
