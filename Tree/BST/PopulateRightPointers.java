//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

//O(n) , O(n) approach

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node node = q.poll();
                if(i<size-1) node.next = q.peek();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
        }
        return root;
    }
}

//space optimized, optimal

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Node node = root;
        while(node!=null && node.left!=null){
            Node curr = node;
            while(curr!=null){
                curr.left.next = curr.right;
                curr.right.next = (curr.next == null) ? null : curr.next.left;
                curr = curr.next;
            }
            node = node.left;
        }
        return root;
    }
}
