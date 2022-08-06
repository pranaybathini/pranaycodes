//https://leetcode.com/problems/k-diff-pairs-in-an-array/
class Solution {
    public int findPairs(int[] nums, int k) {
        int count =0;
        int size = nums.length;
        Map<Integer,Integer> map= new HashMap<>();
        for(int x : nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int result =0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(k ==0){
                if(entry.getValue()>1){
                    result++;
                }
            }else{
                if(map.containsKey(entry.getKey()+k)){
                    result++;
                }
            }
        }
     return result;   
    }
        
}
