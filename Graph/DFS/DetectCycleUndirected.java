public boolean check(ArrayList<ArrayList<Integer>> adj, int v){

boolean vis[] = new boolean[v];
    Arrays.fill(vis,false);
  
    for(int i=0;i<v;i++){
      if(vis[i] == false){ 
          if(checkForCycle(i,vis,adj,-1)){
            return true; 
          }
      }
    }
  return false;
}

//TC - O(V+E), SC-(V+E) + O(V) for visited array + O(V) for recursive stack

public boolean checkForCycle(int n, boolean[] vis, ArrayList<ArrayList<Integer>> adj,int parent){
  vis[n] = true;
  for(int i: adj.get(n)){
    if(vis[i] == false){
        if(checkForCycle(i, vis, adj, n)){
            return true;
        }
    }else if(i!=parent) return true;
    
  }
  return false;
  
}
