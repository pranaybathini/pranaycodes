//https://leetcode.com/problems/majority-element/
class Solution {
    public int majorityElement(int[] nums) {
        int count =0, elt=0;
        for(int num: nums){
            if(count == 0){
                elt = num;
            }
            count += (elt == num)?1:-1;
        }
        
        return elt;
    }
}
