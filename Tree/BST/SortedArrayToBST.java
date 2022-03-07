/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
      int low = 0, high = nums.length-1;
        return build(nums,low,high);
    }
    
    public TreeNode build(int[] nums, int low, int high){
       TreeNode node = null;
        if(low <= high){
            int mid = low + (high-low)/2;
            node = new TreeNode(nums[mid]);
            node.left = build(nums,low,mid-1);
            node.right = build(nums,mid+1,high);
            
        }
        return node;
    }
}
