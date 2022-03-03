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

//https://leetcode.com/problems/binary-tree-level-order-traversal/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root!=null){
            Queue<TreeNode> queue = new LinkedList<>();
            List<Integer> ans = new ArrayList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                List<Integer> level = new ArrayList<>(); 
                int count = queue.size();
                for(int i=0;i<count;i++){
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                }
                res.add(level);
            }
        }
        return res;
    }
} 
