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
 //https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE, new int[]{0});
    }
    
    public TreeNode build(int[] preorder, int bound, int[] index){
        if(preorder.length == index[0] || preorder[index[0]]>bound) return null;
        TreeNode root = new TreeNode(preorder[index[0]++]);
        root.left = build(preorder,root.val,index);
        root.right = build(preorder,bound,index);
        return root;
    }
}
