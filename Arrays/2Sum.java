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
