//https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
             int elt = target-nums[i];
            if(map.containsKey(elt)){
                int index = map.get(elt);
                return new int[]{i,index};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        
        while(left<right){
            int sum = nums[left]+nums[right];
            if(sum == target){
                return new int[]{left+1,right+1};
            }else if(sum > target){
                right--;
            }else{
                left++;
            }
        }
        return new int[]{};
    }
}
