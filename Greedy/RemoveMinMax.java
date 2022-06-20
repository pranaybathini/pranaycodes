//https://leetcode.com/problems/removing-minimum-and-maximum-from-array/submissions/
class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length == 1 || nums.length == 2){
            return nums.length;
        }
        int minIndex =0, maxIndex =0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        for(int i = 0;i<nums.length;i++){
            if(nums[i] < min){
                minIndex = i;
                min = nums[i];
            }
            
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        l̥        
        int way1 = Math.max((minIndex-0+1), (maxIndex-0+1));
        int way2 = Math.max((nums.length-minIndex) , (nums.length-maxIndex));
        int min1 = Math.min(way1, way2);
        int way3 = (minIndex-0+1) + (nums.length-maxIndex);
        int min2 = Math.min(min1, way3);
        int way4 = (maxIndex-0+1) + (nums.length-minIndex);
        return Math.min(min2,way4);
    }
}
