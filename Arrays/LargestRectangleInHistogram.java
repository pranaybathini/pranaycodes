//https://leetcode.com/problems/largest-rectangle-in-histogram

//Brute Force - TLE
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int minHeight = Integer.MAX_VALUE;
            for(int j=i;j<heights.length;j++){
                minHeight = Math.min(minHeight,heights[j]);
                maxArea   = Math.max(maxArea, minHeight * (j-i+1));
            }
        }
        return maxArea;
    }
}
