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
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValid(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return isValid(root.left,min,root.val) && isValid(root.right,root.val,max);
    } 
}

//another approach using Integer object
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValid(root, null, null);
    }
    
    public boolean isValid(TreeNode root, Integer min, Integer max){
        if(root == null) return true;
        return (min == null || root.val>min) && 
             (max == null || root.val < max) &&                                            
             isValid(root.left,min,root.val) &&
             isValid(root.right,root.val,max);
    } 
}
