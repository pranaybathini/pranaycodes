public boolean bfs(int v, ArrayList<ArrayList<Integer>> adj){
    boolean vis[] = new boolean[v];
    Arrays.fill(vis,false);
  
    for(int i=0;i<v;i++){
      if(vis[i] == false){ 
          if(checkForCycle(i,vis,adj)){
            return true; 
          }
      }
    }
  return false;
}

boolean checkForCycle(int n, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
  Queue<Node> q = new LinkedList();
  q.add(new Node(n,-1));
  vis[n] = true;
  
  while(!q.isEmpty()){
      Node node = q.poll();
      for(Integer i : adj.get(node.node)){
          if(visited[i] == false){
              visited[i] = true;
             q.add(new Node(i,node.node));
          }else if(node.parent!=i){
              return false;
          }
      }
  }
  
  
  return false;
  
}



class Node{
 public int node;
 public int parent;
  
  Node(int node,int parent){
   this.node = node; 
    this.parent = parent;
  }
  
}
