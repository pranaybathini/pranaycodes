//https://leetcode.com/problems/longest-consecutive-sequence
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int maxStreak=0;
        for(int num: nums){
            if(!set.contains(num-1)){
                int currStreak=1;
                int currNum = num;
                
                while(set.contains(currNum+1)){
                    currNum++;
                    currStreak++;
                }
                maxStreak = Math.max(maxStreak, currStreak);
            }
        }
            
        
        return maxStreak;
    }
} 
