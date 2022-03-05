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
//https://leetcode.com/problems/binary-tree-maximum-path-sum/

class Solution {
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        int val = getMaxPath(root, maxi);
        maxi[0] = Math.max(maxi[0],val );
        return maxi[0];
    }
    
    int getMaxPath(TreeNode root, int[] maxi){
        if(root==null) return 0;
        int l = Math.max(0,getMaxPath(root.left, maxi));
        int r = Math.max(0,getMaxPath(root.right,maxi));
        maxi[0] = Math.max(maxi[0],l+r+root.val);
        return root.val + Math.max(l,r);
    }
    
}
