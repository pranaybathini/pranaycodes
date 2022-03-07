/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//recursive

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        int curr = root.val;
        if(curr < p.val && curr < q.val) 
            return lowestCommonAncestor(root.right,p,q);
        if(curr > p.val && curr > q.val)
            return lowestCommonAncestor(root.left,p,q);
        return root;
    }
}

//iterative TC-O(H) = log2n, O(1)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        while(root!=null){
            int curr = root.val;
            if(curr < p.val && curr < q.val){
                root = root.right;
            }
          else if(curr > p.val && curr > q.val)
                root = root.left;
            else return root;
        }
        return root;
    }
}
