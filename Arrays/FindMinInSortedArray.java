//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
class Solution {
    
        public int findMinSol(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        
       int lo=0,hi=nums.length-1;

        while(lo<hi){
            int mid=(lo+hi)/2;
            if(nums[mid]>nums[hi]) lo=mid+1;
            else hi=mid;
        }
        
        return nums[lo];
    }
}

    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        
        int left = 0, right = nums.length-1;
        //if sorted already, return first element.
        if(nums[right]>nums[left]){
            return nums[0];
        }
        
        //If not, need to find the rotation point
        while(right >= left){
            int mid = left + (right-left)/2;
            
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            
            if(nums[mid-1] > nums[mid]){
                return nums[mid];
            }
            
            if(nums[mid] > nums[left]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        
        return -1;
    }
}
