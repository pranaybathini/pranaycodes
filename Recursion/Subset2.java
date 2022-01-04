//https://leetcode.com/problems/subsets-ii/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
}

public void backtrack(List<List<Integer>> list, ArrayList<Integer> temp, int[] nums, int start){
        list.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1])continue;
            temp.add(nums[i]);
            backtrack(list, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
