//KSmallest BST - https://leetcode.com/problems/kth-smallest-element-in-a-bst/

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

//using morris traversal, O(n) time and O(1) space

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        while(root!=null){
            if(root.left == null){
                count++;
                if(count == k) return root.val;
                root = root.right;
            }else{
                TreeNode prev = root.left;
                while(prev.right!=null && prev.right!=root){
                    prev = prev.right;
                }
                
                if(prev.right == null){
                    prev.right = root;
                    root = root.left;
                }else{
                    prev.right = null;
                    count++;
                    if(count == k) return root.val;
                    root = root.right;
                }
            }
        }
        return -1;
    }
}
