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
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
class Solution {
    static TreeNode prev = null;
    public void flatten(TreeNode root) {
        prev = null;
        flattenBT(root);
    }
    
    void flattenBT(TreeNode root){
        if(root == null) return;
        flattenBT(root.right);
        flattenBT(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    
       //O(N) - Time, O(1) Space
        public void flatten(TreeNode curr) {
        while(curr!=null){
            if(curr.left!=null){
                TreeNode left = curr.left;
                while(left.right!=null){
                    left = left.right;
                }
                left.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
