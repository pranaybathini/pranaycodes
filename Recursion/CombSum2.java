//https://leetcode.com/problems/combination-sum-ii/
class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, target, 0);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int rem, int start){
        
        if(rem < 0){
            return;
        }else if(rem == 0){
            res.add(new ArrayList<>(temp));
        }else{
            for(int i=start;i<nums.length;i++){
                if(i>start && nums[i]==nums[i-1])continue;
                temp.add(nums[i]);
                backtrack(res,temp,nums,rem-nums[i],i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
