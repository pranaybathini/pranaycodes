//https://leetcode.com/problems/sort-colors/

class Solution {
    public void sortColors(int[] nums) {
        int zero=0,one=0,two = nums.length-1;
        while(one<=two){
            if(nums[one]==0){
                int temp = nums[one];
                nums[one]  = nums[zero];
                nums[zero] = temp; 
                zero++; one++;
            }else if(nums[one]==1){
                one++;
            }else{
                int temp = nums[one];
                nums[one] = nums[two];
                nums[two] = temp;
                two--;
            }
        }
    }
}
