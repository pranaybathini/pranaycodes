/**
 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
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

class Node{
   
    int min;
     int max;
    int sum;
    
    Node(int min,int max, int sum){
        this.min = min;
        this.max = max;
        this.sum = sum;
    }
}


class Solution {
    private int maxSum=0;
    public int maxSumBST(TreeNode root) {
        maxSum=0;
        maxSumBSTHelper(root);
        return maxSum;
    }
    
    public Node maxSumBSTHelper(TreeNode root){
        if(root == null) return new Node(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        
        Node l = maxSumBSTHelper(root.left);
        Node r = maxSumBSTHelper(root.right);
        
        //valid BST
        if(l.max < root.val && root.val < r.min){
            int sum = l.sum + r.sum + root.val;
            maxSum = Math.max(maxSum,sum);
            return new Node(Math.min(root.val,l.min), Math.max(root.val,r.max)
                           ,sum);
        }
        
        return new Node(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(l.sum,r.sum));
    }
}
