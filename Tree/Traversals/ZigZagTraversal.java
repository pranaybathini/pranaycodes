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
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root != null){
            Queue<TreeNode> q = new LinkedList<>();
            boolean flag = true;
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                List<Integer> res = new ArrayList<>();
                for(int i=0;i<size;i++){
                    TreeNode node = q.poll();
                  
                    if(node.left!=null) q.add(node.left);
                    if(node.right!=null) q.add(node.right);
                    
                    if(flag) res.add(node.val);
                    else res.add(0,node.val);
                    
                }
                ans.add(res);
                flag = !flag;
            }
        }
        return ans;
    }
}
