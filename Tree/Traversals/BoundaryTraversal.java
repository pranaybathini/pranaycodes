import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> traverseBoundary(TreeNode root){
		// Write your code here.
        ArrayList<Integer> res = new ArrayList<>();
        if(root!=null){
            if(isLeaf(root) == false) res.add(root.data);
            addLeft(root,res);
            preOrder(root,res);
            addRight(root,res);
        }
        return res;
	}
    
    
        public static boolean isLeaf(TreeNode node){
        if(node!=null && node.left==null && node.right==null) return true;
        return false;
    }
    
     static void addLeft(TreeNode root, ArrayList<Integer> res ){
        TreeNode curr = root.left;
        while(curr!=null){
            if(isLeaf(curr)==false) res.add(curr.data);
            if(curr.left!=null) curr = curr.left;
            else curr = curr.right;
        }
    }
    
    static void preOrder(TreeNode root, ArrayList<Integer> res){
        if(root == null) return;
        if(isLeaf(root)) res.add(root.data);
        preOrder(root.left,res);
        preOrder(root.right,res);
    }
    
     static void addRight(TreeNode root, ArrayList<Integer> res ){
        TreeNode curr = root.left;
         ArrayList<Integer> tres = new ArrayList<>();
        while(curr!=null){
            if(isLeaf(curr)==false) tres.add(curr.data);
            if(curr.right!=null) curr = curr.right;
            else curr = curr.right;
        }
         
        for(int i = tres.size()-1;i>=0;i--)res.add(tres.get(i)); 
    }
    
    
}
