/**
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/submissions/
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

//TC- O(n), SC -2* O(H)


class BSTIterator{
    
    Stack<TreeNode> stack = new Stack<>();
    boolean isReverse = false;
    
    public BSTIterator(TreeNode root, boolean isReverse){
        this.isReverse = isReverse;
        pushAll(root,isReverse);
    }
    
    public int next(){
        TreeNode node = stack.pop();
        if(isReverse == false) pushAll(node.right,false);
        else pushAll(node.left,true);
        return node.val;
    }
    
    public boolean hasNext(){
        return !stack.isEmpty();
    }
    
    public void pushAll(TreeNode node, boolean isRev){
        if(isRev == false){
            for(;node!=null;stack.push(node),node = node.left);
        }else{
           for(;node!=null;stack.push(node),node = node.right);

        }
    }
    
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        BSTIterator l = new BSTIterator(root,false);
        BSTIterator r = new BSTIterator(root,true);
        int i = l.next();
        int j = r.next();
        while(i<j){
            if((i+j) == k) return true;
            if((i+j) < k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}
