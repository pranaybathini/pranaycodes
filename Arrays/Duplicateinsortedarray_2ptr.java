//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length ==0) return 0;
        int i=0,n=nums.length;
        for(int j=1;j<n;j++){
            if(nums[j]!=nums[i]){
                nums[++i] = nums[j];
            }
        }
        
        return i+1;
    }
}
