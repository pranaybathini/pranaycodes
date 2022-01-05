class Solution {
  //https://leetcode.com/problems/permutations/
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recur(0,nums,ans);
        return ans;
    }
    
    public void recur(int index, int[] nums, List<List<Integer>> ans){
        if(index == nums.length){
            ArrayList<Integer> ds = new ArrayList<>();
            for(int i : nums){
                ds.add(i);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            recur(index+1,nums,ans);
            swap(i,index,nums);
        }
    }
    
    public void swap(int i, int j, int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
