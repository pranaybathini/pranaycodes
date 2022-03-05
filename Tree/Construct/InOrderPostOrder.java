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
 //https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }
    
    TreeNode build(int[] inorder, int is, int ie, 
                  int[] postorder, int ps, int pe ,Map<Integer,Integer> inMap){
        if(is>ie || ps>pe) return null;
         TreeNode root = new TreeNode(postorder[pe]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - is;
        root.left = build(inorder,is,inRoot-1,postorder,ps,ps+numsLeft-1,inMap);
        root.right = build(inorder,inRoot+1,ie,postorder,ps+numsLeft,pe-1,inMap);
        return root;
    }
}
