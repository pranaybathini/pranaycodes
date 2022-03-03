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

//https://leetcode.com/problems/diameter-of-binary-tree/

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int[] diameter = new int[1];
        calculateDiameter(root, diameter);
        return diameter[0];
    }
    
    public int calculateDiameter(TreeNode root, int[] diameter){
        if(root == null) return 0;
        int lh = calculateDiameter(root.left, diameter);
        int rh = calculateDiameter(root.right, diameter);
        diameter[0] = Math.max(diameter[0], lh+rh);
        return Math.max(lh,rh)+1;
    }
}
