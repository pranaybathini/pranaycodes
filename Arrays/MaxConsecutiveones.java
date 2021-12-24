//https://leetcode.com/problems/max-consecutive-ones/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count=0;
        for(int i:nums){
            if(i == 0){
                count =0;
            }else{
                count++;
                max = Math.max(max,count);
            }
        }
        return max;
    }
}
