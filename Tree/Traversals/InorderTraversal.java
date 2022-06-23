//https://leetcode.com/problems/binary-tree-inorder-traversal
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
  
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root!=null){
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }
  
   public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null){
            Stack<TreeNode> stack = new Stack<>();
            while(true){
                while(root!=null){
                    stack.push(root);
                    root = root.left;
                }
                if(stack.isEmpty()){
                    break;
                }

                root = stack.pop();
                list.add(root.val);
                root = root.right;
                
            }
        
        }
        return list;
    }
  
  
    
    //Morris -O(N) TIme, O(1) Space
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null){
            while(root!=null){
                if(root.left == null){
                    list.add(root.val);
                    root = root.right;
                }else{
                    TreeNode node = root.left;
                    while(node.right!=null && node.right != root){
                        node = node.right;
                    }
                    
                    if(node.right == null){
                        node.right = root;
                        root = root.left;
                    }else{
                        node.right = null;
                        list.add(root.val);
                        root = root.right;
                    }
                }
            }
        
        }
        return list;
    }
}
