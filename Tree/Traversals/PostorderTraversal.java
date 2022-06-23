
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        do{
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            
            while(root == null && !stack.isEmpty()){
                root = stack.peek();
                if(root.right == null || root.right == prev){
                    list.add(root.val);
                    prev = stack.pop();
                    root = null;
                }else{
                    root = root.right;
                }
            }
        }while(!stack.isEmpty());
        return list;
        
    }
  
     List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
         if(root!=null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);

        }
        return list;
    }
}
