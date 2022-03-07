public TreeNode inorderSuccessor(TreeNode root, TreeNode node){
  if(root == null) return null;
  TreeNode successor = null;
  while(root!=null){
    if(root.val < node){
      root = root.right; 
    }else{
     successor = root;
      root = root.left;
    }
  }
  
}
